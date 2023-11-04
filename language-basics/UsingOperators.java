
public class UsingOperators {
    public static void main(String[] args) {
        // The postfix operators have the highest precedence.
        int x;
        int y;

        x = 1;
        x++;
        x--;
        System.err.println(STR."x = \{x}.");

        // Unary operators.
        y = 1;
        x = -x + y + +1;
        System.err.println(STR."x = \{x}.");

        // Multiplicative operators.
        x = x * y * 2 / 2 % 2;
        System.err.println(STR."x = \{x}.");

        // Additive operators.
        y = x + y + -1 + ++y;
        System.err.println(STR."y = \{y}.");

        // Shift operators.
        byte flags = 1;
        flags = (byte) ((flags << 7) - 1);
        System.err.println(STR."flags = \{flags}.");

        // Relational operators.
        var acccountAmmount = 2300.45D;
        var keyboardPrice = 4000.00D;
        var hasEnoughMoney = acccountAmmount >= keyboardPrice;
        System.err.println(STR."hasEnoughMoney = \{hasEnoughMoney}.");

        var what = Boolean.TRUE instanceof Boolean;
        System.err.println(STR."true instanceof Boolean = \{what}.");

        // Equality operators.
        var isTheSame = true == false;
        System.err.println(STR."true == false = \{isTheSame}.");

        // The assignment operators have the lowest precedence.
        // And it's right-associative, meaning that it evaluates
        // things from right to left.
        // Also, this might be surprising, it's an operators,
        // just like + or /, and thus resolves to a value, this
        // means it can be use whenever an expression is expected.
        int z;
        z = 1 + 232;
        System.err.println(STR."z = \{z}.");

        // Boolean operators exhibit "short-circuiting" behavior.
        if (true || getValue()) {
            System.err.println("Hello from if.");
        }

    }

    static boolean getValue() {
        System.err.println("Hello from getValue.");
        return true;
    }
}
