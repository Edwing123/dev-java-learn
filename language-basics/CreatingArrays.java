
public class CreatingArrays {

    public static void main(String[] args) {
        // A fixed-length sequense of elements of the same type.
        // The length of an array is established when the array is created.
        // After creation, its length is fixed.
        int[] grades;

        grades = new int[5];

        // Set values to each position of the array.
        grades[0] = 70;
        grades[1] = 65;
        grades[2] = 67;
        grades[3] = 90;
        grades[4] = 70;

        // Print the elements of the array.
        System.err.println("Grades: %d".formatted(grades.length));
        System.out.println(grades[0]);
        System.out.println(grades[1]);
        System.out.println(grades[2]);
        System.out.println(grades[3]);
        System.out.println(grades[4]);

        // And assign a new instance of an array
        // with a different size.
        grades = new int[2];

        // Set values.
        grades[0] = 70;
        grades[1] = 65;

        // Print the elements of the array.
        System.err.println("Grades: %d".formatted(grades.length));
        System.out.println(grades[0]);
        System.out.println(grades[1]);

        // Shortcut syntax for initializing an array.
        int[] ages = {22, 17, 17, 20};
        var agesLength = ages.length;
        System.err.println("Ages: %d".formatted(agesLength));

        // Using System.arraycopy() to copy an array to another.
        var positions = new Position[]{
            new Position(1, 2),
            new Position(3, 4),
            new Position(5, 6)
        };

        var destinationPositions = new Position[2];

        // Src array, starting position in src array, dest array,
        // starting position in dest array, number of elements to copy.
        System.arraycopy(positions, 0, destinationPositions, 0, 2);

        System.err.println(positions[0]);

        System.err.println(destinationPositions[0]);

        // Java provides methods to do common array manipulations.
        // For example: find elements, copy arrays, sort arrays, etc.
        var countries = new String[]{"Brazil", "USA", "Japan", "China", "Russia"};
        var exampleCountries = java.util.Arrays.copyOfRange(countries, 0, 2);

        for (var exampleCountry : exampleCountries) {
            System.err.println(exampleCountry);
        }

        // It has more helpful methods. For example, toString() method.
        System.err.println(java.util.Arrays.toString(countries));
    }
}

record Position(int x, int y) {

};
