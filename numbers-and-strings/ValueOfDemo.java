public class ValueOfDemo {
	public void main(String... args) {
		if (args.length < 2) {
			throw new RuntimeException("You must provide two command line arguments");
		}

		final var firstNumber = Integer.valueOf(args[0]);
		final var secondNumber = Integer.valueOf(args[1]);

		for (var operation : Operations.values()) {
			final var result = switch(operation) {
				case ADD -> firstNumber + secondNumber;
				case SUBTRACT -> firstNumber - secondNumber;
				case MULTIPLY -> firstNumber * secondNumber;
				case DIVIDE -> firstNumber / secondNumber;
				case MOD -> firstNumber % secondNumber;
			};

			System.err.println(STR."\{firstNumber} \{operation} \{secondNumber} = \{result}.");
		}
	}
}

enum Operations {
	ADD,
	SUBTRACT,
	MULTIPLY,
	DIVIDE,
	MOD;

	@Override
	public String toString() {
		return switch(this) {
			case ADD ->  "+";
			case SUBTRACT ->  "-";
			case MULTIPLY ->  "*";
			case DIVIDE ->  "/";
			case MOD ->  "%";
		};
	}
}
