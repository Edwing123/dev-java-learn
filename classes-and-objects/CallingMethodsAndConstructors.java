
import java.util.Arrays;

public class CallingMethodsAndConstructors {
    public static void main(String[] args) {
        errPrint("This method", " takes", " several", " arguments.");

        var foo = new Foo("This constructor", " takes", " several", " arguments.");
        foo.bar(1, 2, CallingMethodsAndConstructors::errPrint, 1, 2, 3);
    }

    static void errPrint(Object... args) {
        System.err.println(Arrays.toString(args));
    }
}

interface Printer {
    void print(Object... args);
}

/**
 * Parameters let us get values from the outside, that is, when a method or constructor
 * is involked, the calling code can provide values (known as arguments) for the parameters
 * defined in the method or constructor being called.
 *
 * Parameters have the syntax: <data type> <parameter name>.
 * If you have more than one parameter, you can separate them
 * with commas.
 *
 * The arguments passed to a method or constructor must match the number, order, and type
 * of the parameters declared by the method or constructor.
 *
 * Java methods and constructors support something called varargs, which stands for
 * variable-length arguments. This feature allows the calling code to pass in an arbitrary
 * number of values.
 *
 * There can only exist one such type of parameter in a method or constructor
 * declaration, and it must be the last parameter.
 */

class Foo {
    // Foo expects zero o more arguments.
    // Here the vararg has the following syntax: <data type>... <parameter name>.
    Foo(Object... args) {
        // Args is basically an array of elements of type [Object].
        System.err.println(Arrays.toString(args));
    }

    // The vararg must be the last parameter.
    void bar(int x, int y, Printer printer, int... more) {
        // x -> int.
        // y -> int.
        // more -> int[].
        printer.print(x, y, more);
    }
}

/**
 * When calling methods and constructors and passing values (arguments) to them,
 * there's often this idea of "passing by value" and "passing by reference" semantics.
 */
