import java.util.Arrays;

public class GettingCharactersAndSubStrings {
	public void main(String... args) {
		if (args.length < 1) {
			throw new RuntimeException("You must provide the type of operation to perform");
		}

		final var operation = Operations.valueOf(args[0]);
		final var operationArgs = java.util.Arrays.copyOfRange(args, 1, args.length);

		println(operation);
		println(java.util.Arrays.toString(operationArgs));

		try {
			switch(operation) {
				case CharAt:
					indexOfExample(operationArgs);
					break;

				case SubString:
					subStringExample(operationArgs);
					break;
				default:
					throw new RuntimeException("Undefined operation.");
			}
		} catch (Exception exception) {
			println("An exception occured:");
			println(exception.getMessage());
		}
	}

	static void indexOfExample(String... args) {
		if (args.length < 1) {
			throw new RuntimeException("You must provide an integer index.");
		}

		final var arg = args[0];
		final var index = Integer.parseInt(arg);

		println(STR."The index is \{index}.");

		final var message = "Hello, world";
		final var foundChar = message.charAt(index);

		println(STR."The found char at \{index} is '\{foundChar}'.");
	}

	static void subStringExample(String... args) {
		if (args.length < 2) {
			throw new RuntimeException("You must provide two integer indexes.");
		}

		final var firstArg = args[0];
		final var startIndex = Integer.parseInt(firstArg);

		final var secondArg = args[1];
		final var endIndex = Integer.parseInt(secondArg);

		println(STR."Start: \{startIndex}, end: \{endIndex}.");

		final var message = "Hello, this is a message from Edwin";

		println(STR."The message is '\{message}'");

		final var subStringMessage = message.substring(startIndex, endIndex);

		println(STR."message[\{startIndex}, \{endIndex}] = '\{subStringMessage}'.");
	}

	static void println(Object text) {
		System.err.println(text);
	}
}

enum Operations {
	CharAt,
	SubString,
}
