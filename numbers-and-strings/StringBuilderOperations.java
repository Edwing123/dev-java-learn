import java.util.List;

/**
 * String Builder operations.
*/

public final class StringBuilderOperations {
  void main() {
    println("String builder operations.");

	// The [StringBuilder] class provides a myriad
	// of methods for modifying the underlying
	// char sequence, for example:

	final var msg = new StringBuilder();

	final var cards = List.of(
		new Card(CardTypes.DEBIT, "1234", "Edwin Garcia"),
		new Card(CardTypes.CREDIT, "1235", "Edwin Garcia"),
		new Card(CardTypes.DEBIT, "1236", "Ruth Garcia"),
		new Card(CardTypes.CREDIT, "1237", "Yader Valle")
	);

	// Construct CSV string.
	for (final var card : cards) {
		if (card instanceof  Card(var type, var bin, var owner)) {
			msg.append(type);
			msg.append(",");
			msg.append(bin);
			msg.append(",");
			msg.append(owner);
			msg.append("\n");
		}
	}

	// Show the result.
	println("The CSV result is:");
	println(msg);

	// There are a lot of methods
	// for working with strings
	// and other data types.

	// We can delete a range of character
	// by using a start and end index.
	final var poem = "Hello, world";
	final var poemSB = new java.lang.StringBuilder(poem);

	// I have to add + 1 to the returned index because
	// it doesn't extend to the found character.
	poemSB.delete(0, poemSB.indexOf(" ") + 1);

	println(poemSB);

	poemSB.insert(poemSB.length(), ",");

	println(poemSB);

	// Get a [String] instance out of the SB.
	final var result = poemSB.toString();

	println(result);

	/*
	 NOTE: We can print a string builder because as usual,
	 the methods like println call the [toString] method
	 of the provided object.

	 There also exists [StringBuffer], it's similar to
	 [StringBuilder], however, the former is thread-safe,
	 and that's because its methods are synchronized.
	*/

  }

  static void println(Object obj) {
    System.err.println(obj);
  }
}

record Card(CardTypes type, String bin, String owner) {}

enum CardTypes {
	DEBIT,
	CREDIT;

	@Override
	public String toString() {
		return switch (this) {
			case CREDIT ->  "credit";
			case DEBIT ->  "debit";
		};
	}
}
