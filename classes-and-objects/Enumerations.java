/**
 * @author edwing123
 * Enumerations in Java
 *
 * As my understanding goes, an enumeration is used
 * to represent a type that has a known list of instances.
 *
 * By known it means that the compiler knows the instances
 * of the enumeration.
 */


public class Enumerations {
	public static void main(String... args) {
		var myOS = OS.Linux;
		var msg = getWelcomeMessage(myOS);
		System.err.println(msg);

		var jobOfferType = OfferType.Internship;
		System.err.println(jobOfferType.getDescription());
		System.err.println(jobOfferType.description);

		System.err.println(" === List of CSS tokens ===");

		for (var token : CSSToken.values()) {
			System.err.println(token.name());
			System.err.println(token.ordinal());
		}

		System.err.println(" === List of HTTP status codes ===");

		for (var statusCode : HttpStatus.values()) {
			System.err.println(statusCode.name());
			System.err.println(statusCode.code);
		}
	}

	static String getWelcomeMessage(OS os) {
		return switch (os) {
			case Linux -> "Welcome to Linux.";
			case Windows -> "Welcome to Windows.";
			case MacOS -> "Welcome to MacOS.";
		};
	}
}

// An enumeration is defined using the enum keyword.
enum OS {
	/**
	 * Inside the enum body, we define a comma separated list
	 * of enum members, each member represents a constant
	 * instance of the type [OS].
	 *
	 * Sounds weird?
	 * Well, behind the scenes, enums are classes. And
	 * each member below represents an instance of this
	 * class [OS].
	 *
	 * If we hover over the enum member, we can see that
	 * the type: public static final OS <enum member name>.
	 *
	 * So each member looks like an implicit instantiation,
	 * and such instantiation is done by the compiler, and it
	 * can only happen inside the enum body.
	 */
	Linux,
	Windows,
	MacOS,
}

/**
 * All enumerations implicitly extend java.lang.Enum.
 * And they cannot extend any other class, neither can
 * other classes extend them. They can implement interfaces though.
 */

// class Gradient {}

// enum Color extends Gradient {
// 	Red,
// 	Blue,
// 	Green,
// }

/**
 * Just like classes, enums can have member declarations, as well constructors.
 */

enum OfferType {
	FullTime("Tiempo completo"),
	PartTime("Medio tiempo"),
	Internship("Prácticas profesionales");

	// Members can be public, private, protected, etc.
	// Though enums can't be superclasses.
	public String description;

	// Enum constructors can only be private.
	private OfferType(String description) {
		this.description = description;
	}

	public String getDescription() {
		return this.description;
	}
}

/**
 * Enumerations comes with useful instance and static methods.
 *
 * First of all, they can be compare using the == operator.
 *
 * The instance contains methods:
 *
 * 1. name(): returns the name of the enumeration.
 * 2. ordinal(): returns the position of the enum according to the order of the enum members declaration.
 *
 * It also contains static methods:
 *
 * 1. values(): returns an array of the enum members.
 * 2. valueOf(String name): returns the enum member with the given name.
 */

// I'm using the CamelCase naming convention, but Java recommends
// using the SCREAMING_SNAKE_CASE naming convention for enumerations.
enum CSSToken {
	Selector,
	LeftCurlyBracket,
	RightCurlyBracket,
	Colon,
	SemiColon,
	Comma,
	SingleLineComment,
	MultiLineComment,
	SingleQuote,
	DoubleQuote,
}

// More examples
enum HttpStatus {
	OK(200),
	NOT_FOUND(404),
	INTERNAL_SERVER_ERROR(500);

	public int code;

	private HttpStatus(int code) {
		this.code = code;
	}
}
