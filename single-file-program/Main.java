
import java.util.Scanner;
import java.util.regex.MatchResult;

public class Main {

    public static void main(String[] args) {
        var input = """
        Hel o World,
        this is a poem,
        for the girl I like.
        """;

        try (var scanner = new Scanner(input)) {
            scanner.findAll("is").map(MatchResult::group).forEach(System.err::println);
        }
    }
}
