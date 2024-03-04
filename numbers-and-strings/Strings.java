/**
  *
  * @author Edwing123
  *
  * The [String] class.
  *
  * The [String] represents a sequence of characters, and we can
  * create a string using special syntax called string literals.
  *
  * String literals are a sequence of characters enclosed by double quotes,
  * when the compiler sees such syntax, it will create an instance of [String]
  * and set sequence of characters as its value.
  *
  * We can also create a [String] instance manually, the constructor
  * for this class has 13 overloads, yeah, crazy.
  */

public class Strings {
  public static void main(String... args) {
    System.err.println("Working with the [String] class.");

	// String literal.
	final var name = "Edwin Garcia";
	final var country = "Nicaragua";

	// Using the [String] class constructor.
	final var girlfriendName = new String("Ruth");

	// A different constructor.
	final var petName = new String(new char[]{'M', 'i', 'c', 'h', 'i'});

	println(STR."""
			My name is \{name}, I am from \{country}.
			I have girlfriend, her name is \{girlfriendName}.
			I also have pet, it's a kitten, its name is \{petName}.
			""");

	// Strings are immutable in Java.
	// This is not valid.
	// name[0] = "I";

	final var inputs = new String[]{
		"Hello World",
		"Nan",
		"Dot saw I was tod"
	};

	for (var input : inputs) {
		final var output = reverseString(input);
		println(STR."The reverse of '\{input}' is '\{output}'.");
	}

	// We can get a char array out of a string.
	final var letters = name.toCharArray();

	final var letterArray = new char[name.length()];

	name.getChars(0, name.length(), letterArray, 0);

	println(letterArray.length == name.length() && letters.length == name.length());

	// Concatenating strings.
	final var label = "===";
	final var msg = "Hello World";
	final var fullMsg = label.concat(msg).concat(label);

	println(STR."The message is: \{fullMsg}.");

	// Java provides a more convenient way for concatenating strings using
	// the + operator.
	final var message = label + " " + msg + " " + label;

	println(STR."The message is: \{message}.");

	// We can also use the + operator with other objects, too. For non-string
	// objects, the [toString] method of the object is invoked.
	final var price = 20.99D;

	// The [toString] method is invoked implicitly, then the string on the
	// right is concatenated.
	println(price + " = Hello World");

	// We can use the + operator to conveniently create strings that span
	// in multiple lines.
	println(
		"This is a message, " +
		"It spans multiple lines but, " +
		"it still is a single line, well, unless I add a newline."
	);

	// In Java SE 15 a new feature is introduced for creating text blocks.
	final var poem = """
					I was tired, not because I did not get enough rest,
					but rather I was being drawn from my displeasure.
					""";

	println(poem);

	//	Creating format strings.
	// We can use the static method [format] from
	// the [String] class.
	final var welcomeMessage = String.format("Weclcome %s, it is a pleasure to have you here.", name);

	println(welcomeMessage);
  }

  static void println(Object arg) {
	System.err.println(arg);
  }

  static String reverseString(String input) {
	final var len = input.length();
	final var reversedStrArray = new char[len];

	// Traverse the original array from the last element up to the first element.
	// The last element of the string will be inserted in the first position
	// of the target char array, the element before the last element will be inserted
	// in the second position of the target char array, and so on.
	for (int i = len - 1; i >= 0; i--) {
		reversedStrArray[i] = input.charAt((len - 1) - i);
	}

	return new String(reversedStrArray);
  }
}

