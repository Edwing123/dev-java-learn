
import static java.lang.StringTemplate.STR;
import java.util.List;

public class ExpressionsStatementsBlocks {
    public static void main(String[] args) {
        // An expression is a programming construct
        // where you have variables, literal values, and
        // function calls, operators, and when the expression
        // is evaluated it'll resolve to a single value.
        //
        // The type of the resolved value will depend on the
        // type of the values involved in the expression.
        //
        // For example, if you have two integer values and
        // you add them together, the result will be an integer.
        // However, if you concatenate two strings, the result
        // will be a string.

        var friends = List.of(
            new Friend("Ruth", 17),
            new Friend("Michi", 1),
            new Friend("Michell", 17),
            new Friend("Joseph", 27)
        );

        for (var friend : friends) {
            // This is a comparision expression.
            // The operator used in `>=`, and their
            // operands are `friend.age()` and `18`.
            // The resulting value will be a boolean,
            // which can be used in a conditional statement.
            // Or stored in a variable that will eventually
            // be used in a boolean context.
            var isAdult = friend.age() >= 18;

            if (isAdult) {
                System.out.println(friend.name() + " is an adult.");
            } else {
                System.out.println(friend.name() + " is not an adult.");
            }
        }

        // Only adults.
        var onlyAdultFriends = friends.stream()
            .filter(Friend::isAdult)
            .toList();

        System.err.println(STR."Adult friends: \{onlyAdultFriends.toString()}");

        // Statements are the units of execution in Java.
        // Java has several types of statements, such as,
        // expression statements, declaration statements,
        // and control flow statements.

        // Expression statements are statements that contain an expression.
        var dayPayment = 700.00D;
        var daysWorked = 4;
        var totalPayment = dayPayment * daysWorked;
        System.out.println(STR."Your payment is \{totalPayment}.");

        // Declaration statements are statements that declare entities or variables.
        var name = "Ruth";
        var age = 17;
        var isAdult = age >= 18;

        // Print all the values at once using template strings.
        System.out.println(STR."Name: \{name}, Age: \{age}, Is adult: \{isAdult}.");

        // Control flow statements are statements that control the flow of execution of
        // the statements in the program.
        if (isAdult) {
            System.out.println("Ruth is an adult.");
        } else {
            System.out.println("Ruth is not an adult.");
        }

        // Blocks in Java let us group statements together.
        // A block is begins with a `{` and ends with a `}`.
        // The statements are put within the block.
        {
            // This is valid.
            var x = 123;
            System.err.println(STR."x = \{x} inside the block.");
        }

        // x doesn't exist outside the block.
        // System.err.println(STR."x = \{x} outside the block.");
    }
}

record Friend(String name, int age) {
    boolean isAdult() {
        return age >= 18;
    }
}
