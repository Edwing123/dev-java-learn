
import java.util.List;

public class UsingRecords {

    public static void main(String[] args) {
        // Records let us create unmutable objects to
        // merely store data.
        //
        // The Java compiler will generate `toString`,
        // `equals`, `hashCode` and `get` methods for us.

        var points = List.of(
                new Point()
        );

        for (var point : points) {
            System.out.println(point);
            System.err.println(point.hashCode());
            System.err.println(point.equals(0));
        }
    }
}

record Point(int x, int y) {

    // There can only be one canonical constructor,
    // whether it is compact or complete.
    // That's why this compact constructor is commented out.
    // public Point  {
    //     if (x < 0 || y < 0) {
    //         x = 0;
    //         y = 0;
    //     }
    // }

    // The canonical constructor is the only one that can use `this` to assign fields' values.
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        System.err.println("Canonical constructor.");
    }

    public Point() {
        this(0, 0);
        System.err.println("Custom constructor.");
    }
}
