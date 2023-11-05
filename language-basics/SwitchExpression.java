

public class SwitchExpression {
    public static void main(String[] args) {
        var role = "software engineer";
        var isSenior = true;

        var salary = switch(role) {
            case "software engineer" -> {
                if (isSenior) {
                    yield 108_000;
                }
                yield 100_000;
            }
            case "manager" -> 200_000;
            case "director" -> 300_000;
            default -> 50_500;
        };

        System.err.println(STR."The role \{role} has a salary of \{salary}.");

        // Using switch expressions with enumeration values.
        System.err.println(STR."The state \{States.READY} has a string value of \{getStateString(States.READY)}.");
    }

    static String getStateString(States state) {
        return switch(state) {
            case READY -> "Ready";
            case RUNNING -> "Running";
            case WAITING -> "Waiting";
            case IO -> "IO";
            case FINISHED -> "Finished";
            case null -> "Null";
        };
    }
}

enum States {
    READY,
    RUNNING,
    WAITING,
    IO,
    FINISHED
}
