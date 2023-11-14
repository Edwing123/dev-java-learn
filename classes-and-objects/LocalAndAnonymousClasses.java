/**
 * @author Edwing123
 * Local and anonymous classes in Java
 *
 * In Java, we can declare a class inside a method,
 * this type of class declaration is called a local class.
 *
 * On the hand, we can also declare a local class
 * without a name, this type of class declaration is called
 * an anonymous class.
 */


public class LocalAndAnonymousClasses {
	public static void main(String[] args) {
		var offerController = new OfferController();
		var response = offerController.getOffer(1);
		System.err.println(response);
	}
}

class OfferController {
	public static final int HTTP_STATUS_OK = 200;
	public static final String HTTP_STATUS_TEXT_OK = "Ok";

	public Response getOffer(int id) {
		// Local class definition.
		class SimpleOffer {
			public static String VERSION = "0.0.1";

			public int id;
			public String title;

			public SimpleOffer(int id, String title) {
				this.id = id;
				this.title = title;
			}

			public String toJSON() {
				return STR."""
				{"id": \{id},"title": "\{title}", "version": "\{VERSION}"}\
				""";
			}

			public static void printVersion() {
				System.out.println(VERSION);
			}
		}

		var offer = getOfferFromStore(id);
		var simpleOffer = new SimpleOffer(offer.id(), offer.title());
		return new Response(HTTP_STATUS_OK, HTTP_STATUS_TEXT_OK, simpleOffer.toJSON());
	}

	public Offer getOfferFromStore(int id) {
		return new Offer(id, "Offer title", false);
	}
}

record Response(int status, String statusText, String response) {}



record Offer(int id, String title, boolean is_draft) {}

/**
 * Details about local classes:
 *
 * - A local class can access to members of the enclosing class [1].
 * - A local classs can access local variables, but only if they are final or effectively final.
 * 		- A local variable is effectively final if its value does not change after it is first assigned.
 * - Starting in Java SE 8, local classes can access method parameters.
 * - The local class member definitions showdow definitions of the surrounding scope.
 *
 * [1]: except if the local class is defined in a static method, in that case
 * 		it can only access static members of the enclosing class.
 *
 * Even though local classes are similar to inner classes (they can access instance members
 * , provided they are not declared inside a static method), there are some details
 * that are confusing me:
 *
 * According to the docs, the following code should throw a compilation error:
 */

// class Testing {
// 	public void sayGoodbyeInEnglish() {
// 		class EnglishGoodbye {
// 			public static void sayGoodbye() {
// 				System.out.println("Bye bye");
// 			}
// 		}
// 		EnglishGoodbye.sayGoodbye();
// 	}
// }

/**
 * I could be misunderstanding the docs, but if I compile the code above, it compiles
 * without any problem, even if the local class declares a static method.
 *
 * Finally, I won't write about anonymous classes, yet.
 * I'll learn about them in the future.
 */
