/**
 * The [StringBuilder] class is like the [String], except that
 * it can be modified. Internally, this class treats the string
 * as a variable-length array of characters that can be modified at runtime with
 * method invocations.
 *
 * Prior to Java SE 9, concatenating a large number of strings (+) is more efficient
 * when using a [StringBuilder] in a lot of cases. In Java SE 9, concatenating (with +)
 * has been made more efficient than [StringBuilder].
 *
 * The [StringBuilder] class provides methods for getting
 * the [length] of the sequence of characters currently stored, as well as
 * an additional [capacity] method for getting the "capacity" of the string builder,
 * this capacity represents the allocated spaces for storing characters, and it's always
 * >= to the [length] of the string builder instance.
 *
 * In essence, the [StringBuilder] has an internal dynamically allocated array
 * with an initial "size", for example, it initially can hold 16 characters.
 * When you do append a string, let's say "hello", to the string builder,
 * it places those characters into that array, now the length of the string builder
 * is 5 (since "hello" is 5 characters long), and the remaining storing capacity is
 * `capacity - length`, which is 11. If we append " hello", now the length is 11,
 * and the capacity is 5. Now here comes the interesting aspect about a [StringBuilder],
 * at this point when the capacity is 5, it will increase the capacity automatically.
 *
 * From the tutorial:
 *
 * > (The string builder) will automatically expand as necessary to
 * > accommodate additions to the string builder.
 *
 */

public final class StringBuilders {
  public void main() {
    System.err.println("Hello.");

	 // The [StringBuilder] class offers four constructors.

	// #1 An empty string builder with an initial capacity of 16.
	final var emptySB = new StringBuilder();
	printSB(emptySB);

	// #2 One with an initial CharSequence + 16 extra spaces in the capacity.
	final CharSequence msg = new String(new char[]{'h', 'e', 'l', 'l', 'o'});
	final var nonEmptySB = new StringBuilder(msg);
	printSB(nonEmptySB);

	// #3 Same as above, but with a [String] instance.
	final var moreNonEmptySB = new StringBuilder("hello");
	printSB(moreNonEmptySB);

	// #4 By specifying an initial capacity number.
	final var largeEmptySB = new StringBuilder(1024);
	printSB(largeEmptySB);

	// The [StringBuilder] class offers methods that are not
	// available in the [String] class:

	final var welcomeMessage = new StringBuilder("Hello, ");
	printSB(welcomeMessage);

	// Set the length of the character sequence.
	welcomeMessage.setLength(0);

	// If the newLength is less than the current length,
	// all the characters are truncated.
	printSB(welcomeMessage);

	// If the newLength is > than the current length,
	// it fills the spaces up with null.
	welcomeMessage.setLength(5);
	printSB(welcomeMessage);
	println((welcomeMessage.charAt(0) == 0x0) ? "It's null" : "It's not null");

	// Ensure a minimum capacity for the backing variable length array.

	// Before.
	printSB(welcomeMessage);

	welcomeMessage.ensureCapacity(1024);

  	// After.
  	printSB(welcomeMessage);


	// From the tutorial:

	// > A number of operations (for example, append(), insert(), or setLength()
	// > can increase the length of the character sequence in the string builder
	// > so that the resultant length() would be greater than the current capacity().
	// > When this happens, the capacity is automatically increased.

	// This is because the capacity represents the size
	// of the underlying backing array.
	final var gameOverMessage = new StringBuilder("Game Over.");

	printSB(gameOverMessage);

	gameOverMessage.append(" Or maybe not... It's actually over.");

	printSB(gameOverMessage);

	println(gameOverMessage.capacity() > gameOverMessage.length());
  }

  static void println(Object obj) {
	  System.err.println(obj);
  }

  static void printSB(StringBuilder sb) {
	  println(STR."""
		Length: \{sb.length()}
		Capacity: \{sb.capacity()}
		"""
	  );
  }
}

