import java.util.ArrayList;
import java.util.List;

/**
 * Autoboxing and unboxing.
 *
 * Autoboxing is to the automatic conversion the
 * Java compiler does between primitive data types
 * to their corresponding wrappers classes. For example,
 * converting an `int` to an `Integer`. If the process
 * goes the other way around, it's called unboxing.
*/

public final class Autoboxing {
  void main() {
	// A growable array of [Integer] elements.
	final List<Integer> ints = new ArrayList<>();

	for (int i = 0; i < 10; i++) {
		// The compiler performs an automatic
		// conversion, as if it called [Integer.valueOf].
		ints.add(i);
	}

	ints.forEach(Autoboxing::println);

	// Autoboxing happens when:
	// 1. You pass a primitive value to a method that
	// 	  expects wrapper class.
	// 2. You assign a primitive value to a variable that
	//	  expects a wrapper class.

	// Unboxing does the inverse of the above,
	// the compiler makes calls to the wrapper
	// class method that gets the primitive value.

	var sum = 1;

	for (var value : ints) {
		// value is an [Integer]. In this case,
		// the compiler automatically calls [Integer.intValue].
		if ((value % 2) == 0) {
			sum += value;
		}
	}

	// Autoboxing and unboxing lets us write cleaner
	// code by not having us to do these conversions ourselves.
  }

  static void println(Object obj) {
    System.err.println(obj);
  }
}
