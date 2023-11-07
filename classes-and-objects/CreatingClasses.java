
public class CreatingClasses {
    public static void main(String[] args) {
        // Create an attack sequense between a wizard and an archer.
        Wizard wizard = new Wizard(10, "Gandalf");
        Archer archer = new Archer(10, "Legolas");

        // The wizard attacks the archer.
        wizard.attack(archer);
        System.out.println(archer.getStats());

        // The archer attacks the wizard.
        archer.attack(wizard);
        System.out.println(wizard.getStats());
    }
}

class Character {
    private static final int DAMAGE_HIT = 10;

    // A class has field declarations.
    // They represent the state of the class,
    // in other words, its attributes, the things
    // that make it be itself.
    private final String name;
    private int health;
    private int level;

    // A class has a constructor.
    // This is a special method that gets called
    // when you create a new instance of the class with `new`.
    public Character(String name) {
        this.name = name;
        this.health = 100;
        this.level = 1;
    }

    // A class has methods. They represent
    // the behaviour of the class. In other words,
    // actions.
    public void takeDamage(int damage) {
        this.health -= damage;
    }

    public void attack(Character target) {
        target.takeDamage(DAMAGE_HIT);
    }

    public void levelUp() {
        this.level++;
    }

    public String getStats() {
        return STR."""
        == Character stats ==
        Name: \{name}.
        Level: \{level}.
        Health: \{health}. \
        """;
    }
}

class Wizard extends Character {
    // The unique properties of a Wizard.
    private int mana;

    public Wizard(int mana, String name) {
        super(name);
        this.mana = mana;
    }

    @Override
    public void attack(Character target) {
        // If the Wizard has no mana, it can't attack.
        if (this.mana == 0) {
            return;
        }

        super.attack(target);
        this.mana--;
    }
}

class Archer extends Character {
    // The unique properties of an Archer.
    private int arrows;

    public Archer(int arrows, String name) {
        super(name);
        this.arrows = arrows;
    }

    @Override
    public void attack(Character target) {
        // If the Archer has no arrows, it can't attack.
        if (this.arrows == 0) {
            return;
        }

        super.attack(target);
        this.arrows--;
    }
}

/**
 * A class declaration has the following structure:
 *
 * <optional class modifier> class ClassName <extends parent> <implements comma-separated list of interfaces> {
 *  <field declarations>
 *  <constructor declarations>
 *  <method declarations>
 * }
 */
