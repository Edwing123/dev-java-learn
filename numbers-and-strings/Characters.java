/**
 * @author Edwing123
 *
 * The [Character] class.
 *
 * The [Character] class wraps a single [char] value.
 * It provides useful methods, both in the form of
 * static and instance methods.
 */

public class Characters {
	public static void main(String[] args) {
		// Literal character creation.
		var initial = 'E';

		System.err.println(STR."My initial is \{initial}.");

		// Instantiate a [Character] class.
		// Note: a warning message says that this
		// constructor has been marked for removal.
		// var anotherInitial = new Character('V');

		// Let's use the alternative.
		var anotherInitial = Character.valueOf('V');

		// Get internal value.
		System.err.println(anotherInitial.charValue());

		// Let's use some static methods.
		println(Character.isDigit('0'));
		println(Character.getType('0'));
		println(Character.isWhitespace('\s'));
		println(Character.isWhitespace('\t'));
		println(Character.isWhitespace('d'));
		println(Character.isWhitespace(0x20));
	}

	// Ahh.
	static void println(Object arg) {
		System.err.println(arg);
	}
}
