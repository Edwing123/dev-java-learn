import java.util.List;

public class FindingOccurences {
	public void main() {
		final var message = "Hello, this is me";
		final var chars = List.of("h", "e", "u", "m");

		println(STR."Finding the position of the following characters: \{chars}.");
		chars.forEach((var chr) -> {
			final var position = message.indexOf(chr);
			final var warning = switch (position) {
				case -1 -> " (Not found)";
				default ->  "";
			};

			println(STR."\{chr} at \{position}\{warning}.");
		});

		final var userMessage = "Hello, this is Edwin, the guy from Versatec, do you remember me?".toLowerCase();
		final var keywords = List.of("hello", "is", "guy", "Versatec");

		keywords.forEach((var keyword) -> {
			final var answer = userMessage.contains(keyword) ? "Yes" : "No";
			final var anotherMessage = STR."Is \{keyword} in the message? \{answer}.";
			println(anotherMessage);
		});
	}

	static void println(Object obj) {
		System.err.println(obj);
	}
}
