
/*
    The var keyword in Java.
 */
import static java.lang.StringTemplate.STR;
import java.util.List;

public class UsingVar {

    public static void main(String[] args) {
        var username = "Edwing123";
        var keyboardPrice = 99.99;

        System.err.println(STR."""
            Username: \{username}.
            Keyboard price: \{keyboardPrice}.
        """);

        var friends = List.of("Edwin", "Ruth", "Michell", "Michi", "Minino");

        for (var friend : friends) {
            System.out.println(friend);
        }
    }
}
