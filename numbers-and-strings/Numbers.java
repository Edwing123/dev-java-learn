
import static java.lang.StringTemplate.STR;
import java.util.Locale;


/**
 * @author Edwing123
 *
 * Primitive numbers and their wrapper classes.
 *
 * The Java platform provides wrapper classes for each
 * primitive data type. These classes wrap the primitive
 * in an object. This is often done by the compiler. For example,
 * if you pass a primitive to a method and that method expects
 * an object, then the compiler will first wrap the primitive
 * in its corresponding wrapper class and then pass it to the
 * method.
 *
 * Similarly, if you pass a numeric object where a numeric primitive
 * is expected, then the compiler unboxes the primitive value.
 *
 * In a way, we can think of the wrapper classes as a class that internally
 * holds the primitive value, and then adds useful methods on top of it.
 *
 * All the numberic wrapper classes are subclasses of the abstract class [Number]:
 *
 * Number:
 * 	- Byte.
 * 	- Short.
 * 	- Integer.
 * 	- Long.
 * 	- Float.
 * 	- Double.
 *
 * As a note, the guide tell us that there are four more subclasses of [Number]:
 * 	- BigDecimal.
 * 	- BigInteger.
 * 	- AtomicInteger.
 * 	- AtomicLong.
 *
 * There are three reasons to use a wrapper class:
 * 	1. As an argument of a method that expects an object.
 * 	2. To use constants defined by the class (e.g, MAX_VALUE and MIN_VALUE).
 * 	3. For doing value transformations (to and from other primitive types, for example).
 */

public class Numbers {

    public static void main(String... args) throws Throwable {
        if (false) {
            // Instance methods from the wrapper classes.
            var age = 22;

            var integerAge = Integer.valueOf(age);

            // Get the interal int value.
            System.err.println(integerAge.intValue());

            // Get a value out of the interal int.
            System.err.println(integerAge.byteValue());

            // More convertions.
            System.err.println(integerAge.toString());

            // Methods for comparison.
            var values = new Integer[]{18, 16, 28, 22};

            for (var value : values) {
                var result = integerAge.compareTo(value);

                var msg = switch (result) {
                    case 0 ->
                        "Equals";
                    case 1 ->
                        "Greater";
                    case -1 ->
                        "Less";
                    default ->
                        "No idea";
                };

                System.err.println(STR."\{integerAge} \{msg} \{value}.");
			}

			// We also get static methods for several purposes.
			var scanner = new java.util.Scanner(System.in);
			var input = scanner.next();
			System.err.println(input);

			var result = Integer.decode(input);

			System.err.println(STR."\{input} is decoded as \{result}.");
		}

		if (false) {
			// Formatting numeric output.
			// The class [java.io.PrintStream] includes two methods that can be used
			// for creating strings using templates, that is, you provide a template
			// string (known as a format string) where you specify regular text plus
			// a special set of specifiers to indicate that a particular value goes
			// there, and you also provide a set of arguments to be used to create
			// the output string.
			//
			// [System.out] or [System.err] are instances of such class, so
			// we can use those methods to create formatted output.
			var age = 22;
			var friendsCount = 0;
			var knownLanguages = 3;

			System.err.format(
				"My age is %d, I have %d friends and I speak %d languages.%n",
				age, friendsCount, knownLanguages
			);

			var moneyInAccount = 5250.65D;

			// We can print numbers based on locales (location aware).
			System.err.format(Locale.JAPAN, "I have %f in my account.%n", moneyInAccount);
			System.err.format(Locale.FRANCE, "I have %f in my account.%n", moneyInAccount);
			System.err.format(Locale.CANADA, "I have %f in my account.%n", moneyInAccount);

			// There a big table with format specifies, converters and flags.
			// specifier: %FC.
			// converter: <data type to format>, for example: d for integers.
			// flags: not sure.

			// Some exaples.

			// A decimal number with 3 digits after the decimal point.
			format("I've got %.3f in the back.%n", moneyInAccount);

			var prices = new double[]{99.78, 999.65, 67.55, 6565.88};

			for (var price : prices) {
				format("%+.2f.%n", price);
			}
		}

		if (false) {
			// The [DecimalFormat] class.
			final var PATTERN = "C$###,###.###";
			final var moneyFormatter = new java.text.DecimalFormat(PATTERN);
			final var prices = java.util.List.of(5235.76, 1234.99, 99, 99);

			for (var price : prices) {
				System.err.println(moneyFormatter.format(price));
			}
		}

		if (true) {
			// Beyond basic arithmetic.
			//
			// The Java platform provides more advanced mathematical functions, and
			// constants in the [Math] class. This functionality is provided
			// though static methods and constants.
			final var PI = java.lang.Math.PI;
			System.err.println(STR."The value of PI is \{PI}.");

			// Handy methods.
			println(Math.abs(-123));
			println(Math.clamp(10, 0, 5));
			println(Math.clamp(10, 0, 5));
			println(Math.max(10, 0));

			// The [java.lang.Math] class provides many methods.
			// I won't cover all of them, however, if I need
			// mathemetical functionality, I'll know where to search for them.

			// Trigonometric functions.
			// Exponentiation.
			// Square roots.
			// Random numbers.
		}
	}

	static void format(String format, Object... args) {
		System.err.format(format, args);
	}

	static void println(Object arg) {
		System.err.println(arg);
	}
}
