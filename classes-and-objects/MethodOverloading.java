
public class MethodOverloading {
    public static void main(String[] args) {
        say(123);
        say("Hello World.");
    }

    static void say(String text) {
        System.out.println(text);
    }

    static void say(int number) {
        System.out.println(Integer.toString(number) + ".");
    }
}
