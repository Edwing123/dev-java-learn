import java.util.List;

/**
 * Polymorphism
 *
 * From the tutorial:
 *
 * > The dictionary definition of polymorphism refers to a principle in biology in which an organism or species
 * > can have many different forms or stages. This principle can also be applied to object-oriented programming
 * > and languages like the Java language. Subclasses of a class can define their own unique behaviors and yet
 * > share some of the same functionality of the parent class.
 *
 * In a sense, imagine there exist a class [Character]. Later this class is extended (inherited) by two classes:
 * [Monster] and [Hero]. The [Character] class defines common functionality representing a video-game character.
 * For example, it could have behaviour for getting the character position in the map, or even behaviour for leveling
 * up the character.
 *
 * On the other hand, the classes [Monster] and [Hero] could define their specific state and behaviour beyond what the
 * [Character] class offers. Also, they can override the inherited methods to further customize their behaviour.
 *
 * The idea of polymorphism comes into play when we want to deal with characters only, that is, there could be a set
 * of methods that expect an input parameter of data type [Character], and since [Monster] and [Hero] inherit from
 * [Character], instance of those classes are valid to be passed to those methods.
 */

public final class Polymorphism {
  public static void main(String... args) {
	// Create a list of characters.
	final List<Character> characters = List.of(
		new Monster("Michi"),
		new Hero("Edwing123")
	);

	final var damageAmount = 1_000;

	for (final var character : characters) {
		try {
			character.takeDamage(damageAmount);
		}

		catch (GameException ge) {
			final var msg = switch (ge) {
				case CharacterDeadException _ -> "The character is dead";
				default -> "Unknown exception";
			};

			System.out.println(msg);
		}
	}
  }
}

class Character {
	private final String name;
	private int health;
	private int level;

	Character(String name) {
		this.name = name;
		this.level = 1;
		this.health = 1_000;
	}

	void levelUp() {
		this.level += 1;
	}

	void takeDamage(int amount) throws GameException {
		final var health = this.health  -= amount;

		if (health <= 0) {
			throw new CharacterDeadException();
		}
	}
}

final class Monster extends Character {
	Monster(String name) {
		super(name);
	}
}

final class Hero extends Character {
	Hero(String name) {
		super(name);
	}
}

class GameException extends Exception {}
class CharacterDeadException extends GameException {}

/**
 * Hiding fields.
 *
 * Whenever you define a field that has the same name as one from the superclass,
 * that superclass field is hidden, and the only way to access it is by using [super].
 *
 * NOTE: the field is hidden even if the newly defined field has a different data type.
 * NOTE: Hiding fields is not recommended.
 */

/**
 * The super keyword.
 *
 * If a subclass instance method overrides a superclass instance method, we can refer to the origin superclass
 * instance method by using the [super].[method] mechanism, this also applies to hidden instance fields.
 */

record Transaction(int id, double amount) {}

class TransactionAuthorizer {
	void authorize(Transaction transaction) {
		System.err.printf("Authorizing transaction: %d%n", transaction.id());
	}
}

class FlotaTransactionAuthorizer extends TransactionAuthorizer {
	@Override
	void authorize(Transaction transaction) {
		// Perform logic specific to this kind of authorizer.
		// ...

		// Reuse existing logic in inherited instance method.
		super.authorize(transaction);
	}
}

/**
 * Invoking the superclass constructor using the [super] keyword.
 *
 * When we inherit from a superclass, we must call its constructor inside the subclass
 * constructor. Such call must be the first line inside the body of the subclass constructor.
 *
 */

// If parent class defines no constructors, the compiler inserts one: "the default constructor", such constructor
// expects no arguments when invoked.

class Parent {}

class Child extends Parent {
	Child() {
		// When the parent class only has a default constructor,
		// We can either explicitly call `super()`, or
		// let the compiler do that.
		 super();
	}
}

// In case the parent class defines ONLY one constructor, and that
// constructor is expecting arguments, we must call [super] and provide
// the expected arguments.

class MoreParent {
	MoreParent(boolean isFoo) {
		_ = isFoo;
	}
}

class MoreChild extends MoreParent {
	MoreChild(boolean isFoo) {
		super(isFoo);
	}
}

// If the parent class defines several constructors, the one that gets
// invoked is the one that matches the call (parameters list basically).

class ParentSeveralConstructors {
	// A no-arguments constructor defined explicitly.
	ParentSeveralConstructors() {}

	// It requires an argument.
	ParentSeveralConstructors(boolean isBar) {
		_ = isBar;
	}
}

// It's okay since the no-arguments constructor is called.
class MoreAndMoreChild extends ParentSeveralConstructors {}

class MoreAndMoreChild2 extends ParentSeveralConstructors {
	MoreAndMoreChild2() {
		// Call one constructor.
		super(true);
	}
}

/**
 * Constructor chaining
 *
 * You have to be aware that in an inheritance chain, each constructor is invoked, starting from
 * the child class, up to the constructor of the [Object] class.
 */

/**
 * Writing final classes and methods.
 *
 * We can declare final methods, and this means they can't be overridden
 * by subclasses.
 *
 * We can also declare final classes, and this means they can't be extended.
 */

