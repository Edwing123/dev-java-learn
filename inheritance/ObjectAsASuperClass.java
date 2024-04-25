/**
 * The [Object] class of the [java.lang] package sits at the top of the class hierarchy tree.
 * Every class is a descendant, direct or indirect, of the [Object] class. Every class we use or
 * write inherits the instance methods of [Object].
 *
 * The instance methods discussed in this lesson are:
 *
 * - `protected Object clone()` - Creates and returns a copy of this object.
 * - `public boolean equals(Object other)` - Indicates whether some other object "is equal" to this one.
 * - `public void finalize()` - Called by the GC when it determines there are no more references to this object.
 * - `public final Class getClass()` - Returns the runtime class of an object.
 * - `public int hashCode()` - Returns an integer hash code representing the value.
 * - `public String toString()` - Returns a string representation of the object.
 *
 */

public final class ObjectAsASuperClass {
  public static void main(String... args) {
	var obj = new Object() {
		@Override
		public void finalize() {
			println("Clean up for this object instance.");
		}

		// Stackoverflow exception haha.
		//		@Override
		//		public Object clone() {
		//			return clone();
		//		}
	};

	println(obj.equals(obj));
	println(obj.toString());
	println(obj.hashCode());
	println(obj.getClass());

	// It can't be accessed (unless we override it as a public method).
	//	println(obj.clone());

	obj = null;

	// I was hoping for the [finalize] method to be invoked at
  	// some point by forcefully waiting.
	//	for (var i = 0; i < 5; i++) {
	//		try {
	//			Thread.sleep(1_000);
	//		} catch (Exception exception) {
	//			// 	_ = exception;
	//		}
	//	}
  }


  static void println(Object obj) {
	  System.err.println(obj);
  }
}

