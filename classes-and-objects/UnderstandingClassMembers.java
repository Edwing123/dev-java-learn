/**
 * @author edwing123
 * Understanding Class Members
 *
 * In Java, by default member declarations, specially fields,
 * belog to the instance built based off the class. This means
 * that even though two instances of the same class have
 * the same field, each field storage location is different(!).
 *
 * See how it is "storage location", not "value". This means that
 * if you change the value of a field in one instance, the
 * value of the same field in another instance will not change.
 *
 * Of course, there can be a case where a field of two instances
 * could be pointing to the same object.
 *
 * So, what about if instead we want the class itself to hold its
 * own kind of state?
 *
 * We can do this by using the static keyword. This keyword
 * makes the field belong to the class itself, not to the instances.
 *
 * members with the static modifier are called class members o static members.
 */

import static java.lang.StringTemplate.STR;
import java.util.List;

public class UnderstandingClassMembers {
	public static void main(String[] args) {
		// To be fair, I haven't watched any of these movies.
		var books = List.of(
			Book.create("The Lord of the Rings"),
			Book.create("The Hobbit"),
			Book.create("The Silmarillion"),
			new Book("The Children of Húrin"),
			new Book(5, "The Fall of Gondolin")
		);

		for (var book : books) {
			System.err.println(book);
		}

		final var PI = Mathy.PI;
		final var E = Mathy.E;

		System.err.println(STR."The value of PI is \{PI}.");
		System.err.println(STR."The value of PI is \{E}.");

		var config = new ServerConfig();
		var serverPort = ServerConfig.PORT;
		System.err.println(STR."The server port is \{serverPort}.");
		config.printServerInfo();
	}
}

record Book(int id, String title) {
	private static int internal_id = 0;

	// I don't know if this is the best way to do this,
	// even when I don't like overloaded constructors.
	public Book(String title) {
		this(++internal_id, title);
	}

	// On the other hand, having a specific method
	// makes it clear that we are creating a new instance,
	// and we only need the title.
	public static Book create(String title) {
		return new Book(++internal_id, title);
	}
}

/**
 * As we can see, static members are accessed with <ClassName>.<MemberName>.
 * For example, Book.internal_id or Book.create("The Lord of the Rings").
 *
 * Having said that, we can access static members from instances, but it's
 * not recommended. It's better to access them from the class itself, otherwise
 * they might be confused with instance members.
 */

/**
 * static and final modifiers let us achieve something called constants,
 * which are values that cannot be changed.
 */

class Mathy {
	public static final double PI = 3.1415;
	public static final double E = 2.7182;

	// Wow, I didn't know we could have static blocks!
	static {
		// Invalid, compile error.
		// PI = 123;
	}
}

/**
 * Once a variable declaration is marked with final, we can only assign
 * a value to it once. This means that we can't change the value of a
 * a variable once it is assigned.
 */

/**
 * Instance variables can be initialized by either providing a default value
 * when declaring them, or by putting up logic inside a constructor or method.
 *
 * The advantage of the latter is that we have more flexibility in the things
 * we can do to calculate a value for the instance (error handling, for example).
 *
 * For class variables though, it seems there's no way to accomplish this.
 *
 * NOTE: later I discovered Java has static initialization blocks, so, it's possible.
 */

class ServerConfig {
	public static final int PORT;

	static {
		var portInEnvVar = System.getenv("JHCORE_PORT");
		if (portInEnvVar == null) {
			PORT = 8080;
		} else {
			// What to do if an exception is thrown?
			PORT = Integer.parseInt(portInEnvVar);
		}
	}

	public String hostname;

	// Java also lets you have instance initialization blocks.
	// The initialization block is copied to every constructor of
	// the class.
	{
		// Default value for hostname.
		hostname = "localhost";
	}

	// We can also use final methods(!). This modifier
	// makes the final non-overridable in subclasses.
	public final void printServerInfo() {
		System.err.println(STR."The server is running on \{hostname}:\{PORT}.");
	}
}
