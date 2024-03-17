import java.util.List;

public class ReplacingStrings {
	public void main() {
		final var names = List.of("Ruth", "Edwin", "Joseph", "Yader");
		final var replacements = List.of('a', 'i', 'e');

		names.forEach((var name) -> {
			var newName = name.toLowerCase();
			// Override the value of name by continuously replacing
			// the found characters [replacements] with an asterisk.
			for (var replacement : replacements) {
				newName = newName.replace(replacement, '*');
			}

			println(STR."""
     				Original: \{name}.
     				Modified: \{newName}.
     				"""
			);
		});

		final var blacklist = List.of("bitch", "hooker", "cock", "asshole", "piss", "pussy");
		final var suspiciusMessage = """
               Hello, bitch, this is me, your pimp, it's time to work,
               you useless cock sucker. Make sure to make wet that ugly pussy,
               stupid hooker.
               """;

		var sanitizedMessage  = suspiciusMessage;

        for (var badWord : blacklist) {
            sanitizedMessage = sanitizedMessage.replace(badWord, "*$#%");
        }

		println("Input: " + suspiciusMessage);
		println("Output: " + sanitizedMessage);

		// There are more methods that deal with replacements.
		// String#replaceAll, String#replaceFirst.
		final var input = "JavaScript";

		println(input.replace("Java", "Type") + ".");
		println("Hi, Hi, hello.".replaceFirst("Hi", "Hello") + ".");
		println("Hiiii".replaceFirst("i+", "i"));
    }

	static void println(Object obj) {
		System.err.println(obj);
	}
}
