
import java.util.Arrays;

public class VariableDeclarations {
    public static void main(String[] args) {
        var fields = new FieldDeclaration();
        var modifiers = new AccesModifiers();
        System.err.println(Arrays.toString(new Object[]{fields, modifiers}));
    }
}

/**
 * The are several kind of variables.
 *
 * - Member variables in a class: fields.
 * - Variables in a method or block of code: local variables.
 * - Variables in method declarations: parameters.
 */

// class VariableTypes {
//     // Member variables.
//     private int memberVariable;

//     // Local variables.
//     public void method() {
//         int localVariable;
//     }

//     // Parameters.
//     public void method2(int parameter) {
//         int localVariable;
//     }
// }

class FieldDeclaration {
    // A field has of three components:
    // 1. Zero o more modifiers.
    // 2. The field data type.
    // 3. The field name.
    public boolean isJavaOkSoFar = true;
}

class AccesModifiers {
    // The left-most modifier determines
    // the level of access the field has.
    // In other words, can other classes
    // access this field?
    //
    // We have (so far) the following access modifiers:
    // 1. Public: all classes can access the field.
    // 2. Private: ony the class that declares the field can access it.
    //
    // Examples:

    // All classes that can access [AccessModifiers] instances can access this field.
    public String goodMorningMessage = "Hello and good morning!";

    // Only [AccessModifiers] instances can access this field.
    private final String secretMessage = "I'm a secret message!";

    public String getStrings() {
        return goodMorningMessage + " " + secretMessage;
    }
}
