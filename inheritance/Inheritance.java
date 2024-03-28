import java.util.Arrays;

/**
 * Inheritance.
 *
 * Classes in Java can inherit from other classes, by doing this, those
 * classes inherit the method and fields from those classes.
 *
 * The terminology goes like:
 *
 * The class which is inheriting from another classes is called a subclass, however,
 * it's also known as a derived class, or child class, or an extended class.
 *
 * On other hand, the class which we are inheriting from is known as the superclass,
 * or base class, or parent class.
 *
 * Excepting the [Object] class, which does not have a superclass, every class has one
 * and only ONE direct superclass (this is known as single inheritance). In the absence of
 * an explicit subclass, every class implicitly inherits from the [Object] class.
 *
 * From the tutorial:
 *
 * > Classes can be derived from classes that are derived from classes that are
 * > derived from classes, and so on, and ultimately derived from the topmost class, [Object].
 * > Such a class is said to be descended from all the classes in the inheritance chain
 * > stretching back to [Object].
 *
 * A derived class inherits all the members of the superclass:
 *
 * - Fields.
 * - Methods.
 * - Nested classes.
 *
 * Constructors are not members, so they are not inherited, but the constructors
 * of the superclass can be invoked from the subclass.
 *
 * The [Object] class, defined in the [java.lang] package, defines and implements behavior
 * common to all classes.
 */

public final class Inheritance {
	public static void main(String... args) {

	}

	static void println(Object obj) {
		System.err.println(obj);
	}
}

// Example of inheritance.

class Bicycle {
	// The defining characteristics (state) of
	// the bicycle.
	public int cadence;
	public int gear;
	public int speed;

	// It has single constructor for receiving
	// the initial values for the state.
	public Bicycle(int cadence, int gear, int speed) {
		this.cadence = cadence;
		this.gear = gear;
		this.speed = speed;
	}

	// It has behavior.
	public void setCadence(int newCadence) {
		this.cadence = newCadence;
	}

	public void setGear(int newGear) {
		this.gear = newGear;
	}

	public void applyBrake(int decrement) {
		this.speed -= decrement;
	}

	public void speedUp(int increment) {
		this.speed += increment;
	}
}

// A more specialized kind of bike.
class MountainBike extends Bicycle {
	public int seatHeight;

	public MountainBike(
		int seatHeight,
		int cadence,
		int gear,
		int speed
	) {
		super(cadence, gear, speed);
		this.seatHeight = seatHeight;
	}

	// This class adds a new method, specific to it.
	public void setSeatHeight(int newSeatHeight) {
		this.seatHeight = newSeatHeight;
	}
}

// More on inheritance.

/**
 * Private members in a superclass.
 *
 * A subclass can only access the public and protected members of the
 * superclass, however, it can gain indirect class to private members through
 * those public and protected members, for example, a protected method [getAge],
 * inherited by the subclass, can access a private field member [age], and therefore
 * in this way the subclass has a kind of indirect access to private members.
 */

class Store {
	private static final String VERSION = "1.0.0";

	public static class Record {
		public String getVersion() {
			return Store.VERSION;
		}
	}
}

class InMemoryStore extends  Store {
	public InMemoryStore() {
		// We can access the private VERSION field.
		// final var directAccess = Store.VERSION;
		final var version = new Record().getVersion();
	}
}

/**
 * What you can do in a subclass.
 *
 * What you can in terms of the inherited (public and protected) members:
 *
 * - You can use them as-is (like you normally do when accessing a member).
 * - You can hide field members by declaring a field with the same name.
 * - You can declare (unsurprisingly) new members.
 * - You can replace a superclass method by declaring a method with the same
 * 	 signature as the method inherited from the superclass, this is called "method overriding".
 * - You can hide inherited static methods by defining new ones with the same name and signature.
 * - You can write a subclass constructor that invokes the constructor of the superclass,
 * 	 either implicitly or by using the keyword `super`.
 */

/**
 * Casting objects.
 *
 * We have learned that the data-type of a value is the class from which
 * it was instantiated from (except primitive data types, which are not classes).
 *
 * For example:
 *
 * final var mountainBike = new MountainBike(...);
 *
 * Here, [mountainBike] is of type [MountainBike].
 *
 * The thing is: [MountainBike] is descended from [Bicycle] and [Object]. Therefore,
 * an instance of a [MountainBike] is also a [Bicycle] and an [Object], and it can be used
 * whenever an instance of one of those is required (in methods, or field and variable declarations).
 *
 * By now, the inheritance chain for [MountainBike] is:
 *
 * [MountainBike] > [Bicycle] > [Object].
 */

class Casting {
	public Casting() {
		// Implicit casting of objects.

		// Java performs an implicit conversion of types,
		// and this is a valid assignment because [Object]
		// is part of the inheritance chain of [MountainBike].
		final Object obj = new MountainBike(4, 1, 1, 0);

		// However, this is not valid.
		// final MountainBike mountainBike = obj;

		// From the eyes of the compiler, we are assigning a value of type [Object]
		// to a variable of type [MountainBike], even though we for sure know
		// that the variable [obj] contains a [MountainBike] instance which was
		// implicitly cast.

		// We can perform an explicit cast to tell the compiler
		// we promise that [obj] is an instance of [MountainBike].
		// This explicit cast inserts a runtime check to verify
		// this is true, and if this check fails, we will get
		// a runtime exception.
		final MountainBike mountainBike = (MountainBike)obj;

		// We can even perform a runtime check to validate this ourselves
		// by using the `instanceof` operator.
		if (obj instanceof MountainBike) {
			System.err.println("obj is indeed an instance of [MountainBike].");
		}
	}
}

/**
 * Multiple inheritance of state, implementation, and type.
 *
 * Inheritance of state -> class inheritance.
 * Inheritance of implementation -> inherited methods.
 * Inheritance of type -> A class implementing multiple interfaces.
 *
 */
