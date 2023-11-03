
import static java.lang.StringTemplate.RAW;

public class Inheritance {

    public static void main(String[] args) {
        var archer = new Archer("Robin", 100);
        var warrior = new Warrior("Arthur", 100);
        var witch = new Witch("Merlin", 60);

        var characters = new Character[]{archer, warrior, witch};

        for (var character : characters) {
            System.out.println(character);
        }
    }
}

class Character {

    String name;
    int hp;
    int level;

    public Character(String name, int hp) {
        this.name = name;
        this.hp = hp;
        this.level = 1;
    }

    @Override
    public String toString() {
        StringTemplate st = RAW.
        "\{name}, \{hp}, \{level}";
        return STR.process(st);
    }
}

class Archer extends Character {

    int arrowCount;

    public Archer(String name, int hp) {
        super(name, hp);
        this.arrowCount = 10;
    }

    public void shoot() {
        this.arrowCount--;
    }
}

class Warrior extends Character {

    int swordCount;

    public Warrior(String name, int hp) {
        super(name, hp);
        this.swordCount = 1;
    }

    public int getSwordCount() {
        return swordCount;
    }
}

class Witch extends Character {

    int magicCount;

    public Witch(String name, int hp) {
        super(name, hp);
        this.magicCount = 10;
    }

    public int getMagicCount() {
        return magicCount;
    }
}
