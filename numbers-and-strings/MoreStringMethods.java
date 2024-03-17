public class MoreStringMethods {
	public void main() {
		final var msg = "Hello World";
		final var pattern = "\s";
		final var words = msg.split(pattern);

		println(STR."Splitting \{msg} by '\{pattern}'.");

		final var list = java.util.List.of(words);

		list.forEach((var word) -> {
			println(word);
		});

		println("Now let's split and also specify a maximum array size.");

		final var anotherMsg = "This is a simple sentence.";
		final var anotherPattern = "\s";
		final var limit = 3;
		final var moreWords = java.util.List.of(anotherMsg.split(anotherPattern, limit));

		println(STR."Splitting \{anotherMsg} by '\{anotherPattern}', with limit \{limit}.");

		moreWords.forEach((var word) -> {
			println(word);
		});

		// subSequence -> an instance of {@code CharSequence}.
		final var poem = "Hello, Peter. This is an email, I have a question";
		final var charSequence = poem.subSequence(0, 10);

		println(STR."subsequence on: [\{poem}].");

		charSequence.chars().forEach((var value) -> {
			println(java.lang.Character.toString(value));
		});

		final var userInput = "   Hello, Eva.";
		final var trimmedInput = userInput.trim();

		final var template = StringTemplate.RAW."Input: [\{userInput}], trimmed: [\{trimmedInput}].";
		final var result = STR.process(template);

		println(result);

		final var nameInput = "Edwin Garcia";

		println(STR."""
    			Input: \{nameInput}.
    			Uppercase: \{nameInput.toUpperCase()}.
    			Lowercase: \{nameInput.toLowerCase()}.
    			"""
		);
	}

	static void println(Object obj) {
		System.err.println(obj);
	}
}
