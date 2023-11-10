
/**
 * Access Control Levels
 *
 * @author edwing123
 *
 * Access control let us define if other classes (outside the class where
 * members are defined) can access to the members of a class.
 *
 * There are two levels of access control: At the top level: we have [public] or
 * [package-private] (when no modifier is specified). At the member level: we
 * have [public], [private], [protected], and [package-private] (when no
 * modifier is specified).
 */
// This class is accessible to all classes __everywhere__.
public class AccessControlLevels {

    public static void main(String... args) {
        // I can access [Car].
        var dadCar = new Car("Toyota", "Corolla");
        System.err.println(dadCar);

        var grid = new Grid(5, 5, new Player[]{
            new Player("Edwin", new Point(1, 1)),
            new Player("Minino", new Point(4, 5)),
            new Player("Michi", new Point(1, 1))
        });

        var position = new Point(1, 1);
        var count = grid.countPlayersAtPosition(position);

        System.err.println(STR."There are \{count} players in \{position}.");
    }
}

// This is package-private, meaning it can only be accessed
// from classes in the same package.
record Car(String brand, String model) {

}

// Members also have [public] and [package-private] access control modifiers,
// and they have the same behavior as the top-level modifiers.
//
// Additionally, members can be [private] and [protected].
// [private] means that the member can only be accessed
// from within the class where it is defined.
//
// [private] means that the member can only be accessed from:
// 1. From within the class where it is defined.
// 2. From all classes defined within the same package ([package-private]).
// 3. From within subclasses defined in other packages.
class Grid {

    // These fields are accessible to all classes __everywhere__.
    public int rows;
    public int columns;

    // On the other hand, these fields are only
    // accessible to classes defined within the same package.
    final Player[] players;

    public Grid(int rows, int columns, Player[] players) {
        this.rows = rows;
        this.columns = columns;
        this.players = players;

		var shouldDebug = System.getenv("DEBUG_APP");
		switch (shouldDebug) {
			case null -> {}
			case "0" -> {}
			case "1" -> this.debugGrid();
			default -> throw new IllegalArgumentException(STR."Invalid value for DEBUG_APP: \{shouldDebug}.");
		}
    }

    private void debugGrid() {
        System.err.println(STR.
        "Grid: \{this.rows}x\{this.columns}.");

        // Get headers.
        var columnHeader = "";
        var columnHeaderBorder = "";
        var body = "";

        for (var i = 0; i <= this.rows; i++) {
            body += STR."\{i}|";

            for (var j = 0; j <= this.columns; j++) {
                // Only build this header in the first iteration of columns
                // because we only need it once.
                if (i == 0) {
                    columnHeader += STR."\{j} ";
                    columnHeaderBorder += "- ";
                }

				var count = this.countPlayersAtPosition(new Point(i, j));
                if (count > 0) {
                    body += STR."\{count}|";
                } else {
                    body += " |";
                }
            }

            // Each row in a single line.
            body += "\n";
        }

        var gridString = STR.
        "  \{columnHeader}\n  \{columnHeaderBorder}\n\{body}";
        System.err.println(gridString);
    }

    public int countPlayersAtPosition(Point position) {
        var count = 0;

        for (var player : this.players) {
            if (player.position().equals(position)) {
                count++;
            }
        }

        return count;
    }
}

record Point(int x, int y) {

}

record Player(String name, Point position) {

}
