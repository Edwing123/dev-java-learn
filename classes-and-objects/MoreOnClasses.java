
public class MoreOnClasses {
    public static void main(String[] args) {
        ReturningValuesFromMethods.run();
        ReturningAClassOrInterface.run();
        var thisIsIt = new ThisIsIt("Hello, World!");
        System.err.println(thisIsIt);
        var thisInvocation = new ThisInvocation();
        System.err.println(thisInvocation);
    }
}

class ReturningValuesFromMethods {
    static void run() {
        var message = ReturningValuesFromMethods.getMessage();
        System.out.println(message);

        ReturningValuesFromMethods.printAgeWarning(17);
        ReturningValuesFromMethods.printAgeWarning(22);
    }

    // The value returned from within a method
    // must be of the same as the return type of
    // method.
    //
    // For example, the following method return type
    // is a String.
    static String getMessage() {
        return "Ruth, espero estes bien.";
    }

    // The special return type void is used to
    // indicate that a method doesn't return a value.
    // And within a method body, we are not required
    // to use the return keyword, however, we can still
    // opt into using it if we desired to terminate
    // the execution of a method early, for exaple: inside
    // an if statement.
    //
    // In such cases, the return keyword is used naked,
    // that is, without a value.
    static void printAgeWarning(int age) {
        if (age <= 17) {
            // Return early if age is less than or equal to 17.
            return;
        }

        System.out.println("You are old enough to drive, at least in Nicaragua.");
    }

    // A method can return both values of primitive and reference types.
}

// Covarient return types (?).
class ReturningAClassOrInterface {
    static void run() {
        var bar = new Bar();
        var object = bar.getObject();
        System.out.println(object);
    }
}

class Foo {
    Object getObject() {
        return new Object();
    }
}

class Bar extends Foo {
    // We have narrowed the return type of [getObject].
    // And this is valid because [String] is a subclass of [Object].
    @Override
    String getObject() {
        super.getObject();
        return "Hello, World!";
    }
}

/**
 * [this] reffers to the object a particular method or constructor
 * was invoked on.
 *
 * [this] is often used to explicitly refer to instance fields
 * when they are shadowed by method parameters or local variables, as
 * well as methods.
 */

class ThisIsIt {
    private final String msg = "This is it";

    ThisIsIt(String msg) {
        // [msg] reffers to the method parameter.
        printMsg();
        var lowerCasedMsg = this.msg.toLowerCase();
        System.err.println(lowerCasedMsg);
    }

    private void printMsg() {
        // [msg] reffers to the instance field because
        // there is no local variable with the same name,
        // neither a method with the same name.
        System.out.println(msg);
    }
}

/**
 * [this] inside a constructor can be called to invoke
 * a constructor. This is called explict constructor invocation.
 */

class ThisInvocation {
    private int x, y;

    public ThisInvocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public ThisInvocation() {
        this(0, 0);
    }

    public String getCoords() {
        return String.format("(%d, %d)", x, y);
    }
}

/**
 * Which constructor will be called by [this] is something
 * that the compiler will determine based on the arguments
 * passed to [this]: the number of arguments and their types.
 *
 * Also, if [this] is used to invoke a constructor, it must
 * be the first statement in the constructor body.
 */
