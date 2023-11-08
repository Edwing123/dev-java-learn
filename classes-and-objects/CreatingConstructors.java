
public class CreatingConstructors {
    public static void main(String[] args) {
        var foo = new Foo();
        System.err.println(foo);

        var adder = new Adder(2, 3);
        System.err.println(adder.eval());

        var multiplier = new Multiplier(2, 3);
        System.err.println(multiplier.eval());

        var multiplier2 = new Multiplier();
        System.err.println(multiplier2.eval());
    }
}

/**
 * A constructor is a special kind method that has the same name
 * as the class where it was defined. A constructor is invoked
 * when an instance of a class is created, for example:
 */

class Foo {
    Foo() {
        System.err.println("I'm inside the constructor for [Foo].");
    }
}

/**
 * One different from methods is that constructors don't have
 * a return value. That's why the constructor above does not have
 * a ruturn data type.
 *
 * The thing to understand is that the constructor is a way
 * to gather values from the outside when an instance of a class
 * is being created. So, when doing `new Foo()`, we can think as
 * if the `()` parenthesis are invoking the constructor.
 */

/**
 * As it's said above, a constructor is a place to ask for external values,
 * such values can be used to, for example, initialize class fields.
 *
 * Inside the () of the constructor we define parameters the same we do it
 * in a method. For example.
 */

class Adder {
    private final int x;
    private final int y;

    Adder(int x, int y) {
        // Two values of type int must be provided when creating
        // an instance of [Adder].
        this.x = x;
        this.y = y;
    }

    int eval() {
        return this.x + this.y;
    }
}

/**
 * Java supports constructor overloading, as in methods.
 */

class Multiplier {
    private final int x;
    private final int y;

    Multiplier(int x, int y) {
        this.x = x;
        this.y = y;
    }

    Multiplier() {
        this.x = 1;
        this.y = 1;
    }

    int eval() {
        return this.x * this.y;
    }
}

/**
 * Depending how many arguments we provide when creating the
 * instance of a class, the appropiate constructor will be invoked.
 *
 * For example:
 * var m1 = new Mutiplier(2, 3); // Invokes the first constructor.
 * var m2 = new Mutiplier(); // Invokes the second constructor.
 */

/**
 * If a class doesn't have a constructor, the Java platform
 * will provide a default constructor that does not take
 * any arguments.
 *
 * Also, you can specify access modifiers to constructors.
 */
