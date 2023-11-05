
public class BranchingWithSwitch {

    public static void main(String[] args) {
        // the switch statement is a handy way to
        // branch based on a value in a more simplified way than
        // using if-else statements.
        //
        // In Java, the switch statement can only be used with
        // byte, short, char, and int primitive data types.
        // As well as the wrappers for those types: Byte, Short, Character, and Integer.
        // And finally, the enum type and String class.

        stringSwitch();

        // Breakthough.
        // String userRole = null;
        var userRole = "cms";

        switch (userRole) {
            case "admin":
                System.out.println("You are an admin.");
                break;
            case "cms":
                System.out.println("You are a content manager.");
                break;
            default:
                System.out.println("You are a guest.");
                break;
        }

        // You can combine multiple case labels in order to have "compound matches",
        // that is, if one of the cases match, the statements for those cases get executed.
        var dayOfWeek = 6;
        var isFreeDay = false;

        switch (dayOfWeek) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                isFreeDay = true;
                break;
            case 6:
            case 7:
                isFreeDay = false;
                break;
            default:
                System.out.println("Invalid day of week.");
                break;
        }

        System.err.println(STR.  "Am I free? \{isFreeDay ? "Yes" : "  No"}.");
    }

    static void stringSwitch() {
        String qualitativeScore;
        int score = 90;

        switch (score) {
            case 90:
                qualitativeScore = "A";
                break;
            case 80:
                qualitativeScore = "B";
                break;
            case 70:
                qualitativeScore = "C";
                break;
            case 60:
                qualitativeScore = "D";
                break;
            default:
                qualitativeScore = "F";
                break;
        }

        System.err.println(STR.


    "Qualitative result: \{qualitativeScore}.");
    }
}
