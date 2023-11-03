
/**
 * In Java there are "different" kind of fields that represent state:
 *  - Instance variables: their values are different for each instance of a class.
 *  - Class variables: fields marked with static belong to the class.
 *  - Local variables: state beloging to a method.
 *  - Parameters: the way to accept values when calling a method.
 *
 * The fields and other declarations of a class are collectilively known as its members.
 *
 * Naming variables.
 *
 * Variables are named following a set of rules defined by Java. Variables
 * must start either with a letter, $, or an underscore, then the rest can be letters,
 * numbers, $, or underscores. Java is case sensitive, so [a] and [A] are different variables.
 *
 * Java follows the camelCase convention for naming variables. And the SNAKE_CASE for constants.
 * */
public class VariablesAndTheirNaming {

    public static void main(String[] args) {
        var me = new Person("Edwin", 22, "Nicaragua");
        var ruth = new Person("Ruth", 17, "Argentina");

        var isSingle = true;
        final var PI = 3.1416;

        // Print all the variables above.
        System.out.println(me);
        System.out.println(ruth);
        System.out.println(isSingle);
        System.out.println(PI);
    }
}

record Person(String name, int age, String country) {

};
