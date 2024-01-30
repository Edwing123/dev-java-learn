
/*
    Java supports 8 primitive data types:
    - byte: an 8-bits signed integer. Range: -128 to 127.
    - short: a 16-bits signed integer. Range: -32,768 to 32,767.
    - int: a 32-bits signed integer. Range: -2^31 to 2^31-1.
    - long: a 64-bits signed integer. Range: -2^63 to 2^63-1.
    - float: a 32-bits single precision IEEE 754 floating point.
    - double: a double precision 64-bits IEEE 754 floating point.
    - boolean: a single bit of information. Values: true or false.
    - chart: a single 16-bits Unicode character. Range: '\u0000' to '\uffff'.

    Apart from these types, the Java programming language offers types such
    as [java.lang.String], which is a class to represent a string of characters.

    Java provides special support for that class, for example:
    var name = "Edwin"; // name is a String object.

    Strings in Java are immutable, which means that once a String object is
    created, it cannot be modified.
 */
public class PrimitiveTypes {

    public static void main(String[] args) {
        // A single byte.
        byte age = 22;

        // Two bytes.
        short year = 2023;

        // Four bytes.
        int salary = 10_000;

        // Eight bytes.
        long viewsCount = 3_123_456_789L;

        // Four bytes floating point.
        float height = 1.75F;

        // Eight bytes floating point.
        double weight = 214.5;

        // One bit flag.
        boolean isSingle = true;

        // A unicode character.
        char letter = 'A';

        // Print all the variables.
        System.out.println(age);
        System.out.println(year);
        System.out.println(salary);
        System.out.println(viewsCount);
        System.out.println(height);
        System.out.println(weight);
        System.out.println(isSingle);
        System.out.println(letter);

        // Special support from Java.
        String name = "Edwin Garcia";
        System.err.println(name);

        // Default values.
        // Java specifies default values for fields.
        // The table is at the following link:
        // https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html
        // For local variables, Java does not assign a default value.

        // Literal values.

        // Integers.
        int score = 89;
        char letterGrade = 'A';

        // Java allows the following number systems:
        // Base 10 - decimal.
        int birthYear = 2001;

        // Base 16 - Hexadecimal.
        int colorRed = 0xFF0000;

        // Base 2 - Binary.
        byte oneInBinary = 0b000_0001;

        // Literal integers are of type int. To specify a literal of type long,
        // you suffix the value with an L or l. An uppercase L is preferred.
        long goldInStorage = 5_000_200L;

        // Floating point literals.
        // By default floating point literals
        // are of type double. And you can optionally suffix the value with
        // D o d to make it explicit, though this is not common.
        // On the other hand, if you want to have a literal float,
        // you suffix the value with F or f.
        double pi = 3.14D;
        float grades = 87.6F;

        // String and char literals.
        String country = "Nicaragua";
        char ñ = 'ñ';

        // Print all the variables at once, don't make me type tab.
        System.out.printf(
                "age: %d, year: %d, salary: %d, viewsCount: %d, height: %f, weight: %f, isSingle: %b, letter: %c, name: %s, score: %d, letterGrade: %c, birthYear: %d, colorRed: %d, oneInBinary: %d, goldInStorage: %d, pi: %f, grades: %f, country: %s, ñ: %c\n",
                age,
                year,
                salary,
                viewsCount,
                height,
                weight,
                isSingle,
                letter,
                name,
                score,
                letterGrade,
                birthYear,
                colorRed,
                oneInBinary,
                goldInStorage,
                pi,
                grades,
                country,
                ñ
        );
    }
}
