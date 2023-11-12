
public class MoreNestedClasses {
	public static void main(String[] args) {
		if (Outer.shouldExecuteStaticExample) {
			var outer = new Outer();
			var inner = new Outer.StaticInner();

			Outer.StaticInner.displayOuterStaticMembers();
			inner.displayInstanceMembers(outer);
		}

		if (MoreOuter.shouldExecuteInnerClassExample) {
			var moreOuter = new MoreOuter();

			// So, InnerClass is "attached" to an instance of MoreOuter.
			// And we can directly access instance members of MoreOuter.
			var inner = moreOuter.new InnerClass();

			inner.displayStaticMembers();
			inner.displayInstanceMembers();
		}
	}
}

/**
 * Alright, let's start from the beginning.
 * We have two type of nested classes:
 *
 * 1. static nested classes.
 * 2. non-static nested classes, these are called "inner classes".
 *
 * Ok, what's the difference in semantics?
 *
 * Syntactically, static nested classes are declared
 * using the [static] modifier.
 *
 * If we remember what this means for methods and fields, the
 * static modifier marks methods and fields as belogging to the
 * class itself, not to the instances of the class.
 *
 * Also, it's important to remember that static methods and fields
 * can't access instance methods and fields.
 *
 * On the other hand, instance methods and fields can access class
 * methods and fields.
 *
 * Alright: what about static nested classes?
 *
 * As per the documentation at https://dev.java/learn/classes-objects/nested-classes/
 *
 * > Static nested classes do not have access to
 * > other members of the enclosing class.
 *
 * It might sound confusing, and to me it is, because I thought that by "other members
 * of the enclosing class" meant both instance and class members.
 *
 * But it turns out that it only means instance members, the same meaning
 * as static methods and fields, we cannot access DIRECTLY members
 * of the outer class instances. And it makes sense we cannot access them
 * because static methods are not associated with a particular instance that
 * is attached to [this].
 *
 * Ok, what's special about this static nested classes though?
 *
 * Basically, static classes are what most people would expect
 * from other languages that allow nesting declarations of types
 * inside other types, pretty much rendering the surounding type
 * as a kind of namespace.
 *
 * We can see a better explanation from the same documentation page:
 *
 * > As with class methods and variables, a static nested class is
 * > associated with its outer class. And like static class
 * > methods, a static nested class cannot refer directly to
 * > instance variables or methods defined in its enclosing class: it
 * > can use them only through an object reference.
 *
 * Something that might not be obvious -and it was not to me- is that
 * static nested classes can access private members of the outer class.
 * We gain that access level. We're gonna see an example of this.
 */

class Outer {
	private static final String NAME = "Outer";
	private final String description = "This is the description of the outer class.";
	public static boolean shouldExecuteStaticExample = true;


	// We have access to [Outer] private members. Be them static or not.
	// Of course, we need a reference to an instance of [Outer] in order
	// to access its instance members.
	static class StaticInner {
		public static void displayOuterStaticMembers() {
			// Ajam, we can DIRECTLY access static members of the outer class.
			// Though we can also access them through an instance of the outer class
			// or a direct reference to the outer class:
			//
			// 1. new Outer().NAME;
			// 2. Outer.NAME
			System.err.println("Outer.NAME: " + NAME);
		}

		public void displayInstanceMembers(Outer outer) {
			// Outer.description is private, but since this
			// access is being done from a nested class within [Outer],
			// then it's permitted, just like static methods and fields.
			System.err.println("Outer.description: " + outer.description);
		}

		// To make it clear, if we pass an instance of [Outer] to
		// a method of a class defined outside [Outer], we would get
		// a compile-error because [Outer.description] is private.
	}
}

/**
 * This was a good enough explanation and exploration to me,
 * I probably made it complicated for myself, but I think
 * I got it.
 *
 * I found this JEP that seems related: https://openjdk.org/jeps/181.
 * I haven't read it yet, and based on the summary:
 *
 * > Introduce nests, an access-control context that aligns with
 * > the existing notion of nested types in the Java programming language.
 * > Nests allow classes that are logically part of the same code entity,
 * > but which are compiled to distinct class files, to access each other's
 * > private members without the need for compilers to insert accessibility-broadening
 * > bridge methods.
 *
 * I wonder whether this semantic of nested classes works in both directions.
 * Can an outer class access private members of a nested class/instance?
 */

/**
 * Now let's move on to inner classes.
 *
 * First of all, I want to say that I haven't seen real-world examples
 * about how inner classes might be useful, YET. I'm still very
 * green with Java, so I don't have a strong opinion about this
 * particular feature, though at first it looks odd to me.
 *
 * Ok, let's start saying that inner classes are attached to an instance
 * of the outer class. What does this mean? Well, first, we cannot directly
 * instantiate an inner class, we first need to instantiate an instance of
 * the outer class which the inner class is defined in.
 *
 * After doing that, we have to use a special syntax for instantiating
 * the inner class. Let's see first.
 *
 * Below there is the declaration of the class. Above in the main method
 * there is an example of how to instantiate the inner class.
 */

class MoreOuter {
	private static final String NAME = "MoreOuter";
	private final String description = "This is the description of the MoreOuter class.";
	public static boolean shouldExecuteInnerClassExample = true;

	class InnerClass {
		public void displayStaticMembers() {
			// The same as static nested classes, we can access
			// static members of the outer class, either directly
			// or through an explicit reference to the outer class.
			System.err.println("MoreOuter.NAME: " + NAME);
		}

		public void displayInstanceMembers() {
			// He comes the _interesting_ part, we can access DIRECTLY the instance members,
			// without the need of a reference to an instance of the outer class.
			//
			// As the docs say:
			//
			// > Non-static nested classes (inner classes) have access to
			// > other members of the enclosing class, even if they are declared private.
			//
			// Remember though, here "other members" means instance members, not static members.
			// But sure, we can access static members, just like normal instance methods and fields.
			System.err.println("MoreOuter instance description: " + description);

			// We can do the same for instance methods.
		}
	}
}

/**
 * How is this useful? As I said, I haven't seen real-world examples
 * of projects using this feature. So, I can't say much about it.
 */
