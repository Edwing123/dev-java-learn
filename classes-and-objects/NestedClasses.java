/**
 * @author edwing123
 * NestedClasses
 *
 * In Java, you can define classes inside other classes.
 * This means, inside the body of a class declaration.
 *
 * Such classes are called nested classes, and they are
 * divided in two categories:
 *
 * 1. non-static: non-static nested classes are called inner classes.
 * 2. static: nested classes declared with the static modifier are called static nested classes.
 */


public class NestedClasses {
	private static final String TITLE = "Inner classes vs static nested classes";

	public static void main(String... args) {
		Animal.run();
		Character.run();

		var server = new Server();

		// Inner nested classes require this syntax(!).
		var config = server.new Config();
		server. applyConfig(config::applyConfig);

		// Static nested classes don't need such special syntax.
		var staticConfig = new Server.StaticConfig();

		//  This works, but I don't know why.
		// Alright, I now know why.
		// I finally get it.
		server.applyConfig(staticConfig::applyConfig);

		// Can't access the field since it's private.
		// server.applyConfig((var s) -> s.name = "web server");
	}

	// This works. How about the nested classes?
	static {
		System.err.println("Ok...");
	}

	// Inner class example.
	class Animal {
		public static final String NAME = "Animal";

		// This type of nested class has access to the enclosing class members (fields and methods).
		// static {
		// 	System.out.println(TITLE);
		// 	System.err.println(NAME);
		// 	System.err.println(Character.class);
		// }

		static void run() {
			System.err.println(NAME);
			System.out.println(TITLE);
			System.err.println(Character.class);
		}
	}

	// Static nested class example.
	static class Character {
		public static final String NAME = "Character";

		// On the other hand, static nested classes do not have
		// access to the outer class members.
		// static {
		// 	System.err.println(TITLE);
		// 	System.err.println(NAME);
		// 	System.err.println(Animal.class);
		// }

		static void run() {
			System.err.println(NAME);
			System.err.println(TITLE);
			System.err.println(Animal.class);
		}
	}
}

/**
 * Ajam, so, I'm seeing the difference is that
 * Animal (inner class) can access instance members
 * of the outer class.
 *
 * The idea is that sometimes one specific class might need access
 * to instance members of another class, and in order to do that, we
 * need to specify the members of the class (target) as
 * public, the downside of this is that other classes
 * will also have access to those members.
 *
 * So, by having an inner class, we can specify the members
 * of the outer class as private (or protected), and
 * the inner class instances will still have access to them.
 *
 * Let's try it.
 */

interface ConfigApplier {
	void applyConfig(Server server);
}

class Server {
	private String name = "default name";

	void applyConfig(ConfigApplier configApplier) {
		configApplier.applyConfig(this);
	}		//

	String getName() {
		return name;
	}

	class Config {
		public void applyConfig(Server server) {
			// We have access to Server.name!
			// WTF, we can access the outer class instance members.
			var currentName = getName();
			System.err.println("Applying config...");
			server.name = currentName;
		}
	}

	static class StaticConfig {
		public void applyConfig(Server server) {
			// We have access to Server.name!
			System.err.println("Applying static config...");
			server.name = "server";
		}
	}
}


