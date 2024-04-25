/**
 * Overriding and hiding methods.
 *
 * Overriding instance methods in a subclass.
 */

public final class OverridingAndHidingMethods {
  public static void main(String... args) {
   System.err.println("Overriding and hiding methods.");
  }
}

/**
 * Instance methods.
 *
 * If we define an instance method with the same name and signature from that
 * of one of the superclasses up in the inheritance chain, we are effectively overriding
 * that method: This means, whenever we call that method through an instance of the
 * subclass, the method that will be invoked is the new one we defined in the subclass.
 *
 * This comes in handy when the subclass wants to provide specialized behavior that the
 * inherited method does not perform (see example 1.0 below).
 *
 * From the tutorial:
 *
 * > The ability of a subclass to override a method allows a class to inherit from
 * > a superclass whose behavior is "close enough" and then to modify behavior as needed.
 *
 *  Also, the tutorial mentions this:
 *
 *  >  An overriding method can also return a subtype of the type returned by the overridden method.
 *  > This subtype is called a covariant return type.
 *
 *  Let's make a test in example 1.2 below to if this means what I think it means.
 *
 *  There exist an annotation named [Override] that is put above a method that is
 *  overriding a method up in the inheritance chain. This annotation tells the compiler
 *  that this method is overriding a method from the superclass , but if it detects
 *  such a method does not exist in the superclass, it'll generate an error.
 */

// Example 1.0 - Overriding methods.

class Person {
	public final String firstName;
	public final String lastName;

	Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public void display() {
		System.err.printf("Hi, I am %s %s.", this.firstName, this.lastName);
	}
}

class Programmer extends Person {
	public final String[] languages;
	Programmer(String[] languages, String firstName, String lastName) {
		super(firstName, lastName);
		this.languages = languages;
	}

	@Override
	public void display() {
		// Let's create specific behavior for a programmer.
		System.err.printf("I program in %d languages.", this.languages.length);

		// However, we can still access the original method from
		// the superclass by using the [super].[method] mechanism.
		super.display();
	}
}

// Example 1.2 - Covariant return type.
//
// I can't think of a useful and realistic example,
// so this code snippet only checks whether this works.

class Foo {
	public Foo getSelf() {
		return this;
	}
}

class Bar extends Foo {
	// The idea is that we're still overriding
	// the method, even though the return type
	// is different, however, the return type
	// is within the inheritance chain.
	@Override
	public Bar getSelf() {
		return this;
	}
}

// Example 1.3 - Covariant return type part 2.

class ChildOfBar extends Bar {
	// This is an error!?
	//	@Override
	//	public Foo getSelf() {
	//		return this;
	//	}

	// This works fine.
	@Override
	public ChildOfBar getSelf() {
		return this;
	}
}

/**
 * Static methods.
 *
 * If the subclass defines a static method with the same signature as the
 * method from the superclass, then the method in the subclass HIDES the method
 * in the superclass.
 *
 * There exist a distinction between hiding a static method and overriding
 * an instance method.
 *
 * There are implications:
 *
 * - The version of the overridden instance method that gets invoked is the
 * 	 one in the subclass (see example 2.0).
 *
 * - Unsurprisingly, the static method that gets invoked depends on
 * 	 the class we use to call it (see example 2.1).
 */

// Example 2.0 - Which instance method gets invoked.

class InstanceMethodParent {
	public void print() {
		System.err.println("From the parent class.");
	}
}

class InstanceMethodChild extends InstanceMethodParent {
	@Override
	public void print() {
		System.err.println("From the child class.");
	}
}

class InstanceMethodExample {
	public static void main() {
		final var instanceMethodChild = new InstanceMethodChild();

		// An implicit cast.
		final InstanceMethodParent instanceMethodParent = instanceMethodChild;

		// Invoke the method.
		instanceMethodParent.print();
	}
}


// Example 2.1 - Which static method gets invoked.

class StaticMethodParent {
	public static void print() {
		System.err.println("From the parent class.");
	}
}

class StaticMethodChild extends StaticMethodParent {
	public static void print() {
		System.err.println("From the child class.");
	}

	// Testing.
	static {
		StaticMethodParent.print();
		StaticMethodChild.print();
	}
}

/**
 * Interface methods.
 *
 * Subclasses can inherit both default methods from interfaces they implement,
 * and instance methods from superclasses, in these situations, both the
 * superclass and the interface might have methods with the same signature,
 * so a naming conflict is created.
 *
 * In these cases, the Java compiler follows inheritance rules to resolve
 * this conflict. These rules are driven by two principles:
 *
 * - Instance methods (from the superclass) are preferred over interface default methods.
 */

interface Fighter {
	default public void fight() {
		System.err.println("A fighter fights.");
	}
}

interface Soldier {
	default public void fight() {
		System.err.println("A soldier fights, too.");
	}
}

class Smasher {
	public void fight() {
		System.err.println("A smasher fights, too.");
	}
}

class Character extends Smasher implements Fighter, Soldier {}

/**
 * I don't understand the principle #2 at all:
 *
 * > Methods that are already overridden by other candidates are ignored.
 * > This circumstance can arise when supertypes share a common ancestor.
 */

// Here is the code from the tutorial anyways.

public interface Animal {
	default public String identifyMyself() {
		return "I am an animal.";
	}
}

public interface EggLayer extends Animal {
	default public String identifyMyself() {
		return "I am able to lay eggs.";
	}
}

public interface FireBreather extends Animal { }

public class Dragon implements EggLayer, FireBreather {
	public static void main (String... args) {
		Dragon myApp = new Dragon();
		System.out.println(myApp.identifyMyself());
	}
}

/**
 * More on interfaces.
 *
 * If two default interface methods conflict, then the class implementing
 * those interfaces must override the conflicting method.
 *
 * Also, an abstract interface method and a default interface method
 * can lead to this conflict, and in this case, the implementing class
 * must override the conflicting methods.
 */

interface Window {
	default public  void close() {}
}

interface Screen {
	default public  void close() {}
	default public  void open() {}
}

interface Device {
	default public  void close() {}
}

class MainWindow implements  Window, Screen {
	@Override
	public void close() {
		// We can access the default implementations
		// by using the [super] keyword on the
		// [Window] and [Screen] interfaces.
		Window.super.close();
		Screen.super.close();

		// This is possible.
		Screen.super.open();

		// Direct access, too.
		// Because there is no conflict.
		open();

		// Not possible since [MainWindow] does not
		// implement [Device].
		// Device.super.close();

		// We can use [super] to call any superinterface or superclass
		// methods.
	}
}

/**
 * Inherited instance methods from superclasses can override
 * methods from interfaces that the subclass implements.
 */

interface Pooper {
	public void poop();
}

class PersonThatCanPoop {
	public void poop() {
		System.err.println("i can poop.");
	}
}

class Thomas extends PersonThatCanPoop implements Pooper {
	// [Thomas] inherits [poop] from [PersonThatCanPoop],
	// [poop] from [PersonThatCanPoop] implements the interface.
}

/**
 * Static methods from interfaces are not inherited.
 */

/**
 * Access modifiers and type modifiers (static).
 *
 * Overriding methods can allow more, but not less, access than
 * the overridden methods.
 *
 * For example: if the parent class method is [protected], then,
 * you can only specify the overriding method with [protected] or [public].
 */

class FooProtected {
	protected void getFoo() {}

	public void setFoo() {}
}

class BarPublic extends FooProtected {
	// From [protected] to [public].
	@Override
	public void getFoo() {}

	// We cannot go the other way around.
	// @Override
	// private void setFoo() {}
}
