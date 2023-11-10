
public class CreatingAndUsingObjects {
    public static void main(String[] args) {
        // An object is created using the new keyword.
        // new <ClassName>(<ConstructorArguments>).
        // It resolves to a reference to the newly created object.
        // That's where its name comes from.
        var position = new Coordinate(0, 0);
        var me = new Character("Edwing123");
        me.setPosition(position);
        me.levelUp();

        System.err.println(me.getPosition());
    }
}

class Coordinate {
    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(int x, int y) {
        this.x += x;
        this.y += y;
    }

    public String getCoordinate() {
        return STR."x=\{this.x} y=\{this.y}";
    }
}

class Character {
    private final String name;
    private int level;
    private Coordinate position;

    public Character(String name) {
        this.name = name;
        this.level = 1;
        this.position = new Coordinate(0, 0);
    }

    public int levelUp() {
        return ++this.level;
    }

    public void setPosition(Coordinate position) {
        this.position = position;
    }

    public String getPosition() {
        return STR."Character(\{this.name}) at \{this.position.getCoordinate()}.";
    }
}
