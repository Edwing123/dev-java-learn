
public class ControllingFlow {

    public static void main(String[] args) {
        var shouldShowCharacterExample = false;

        if (shouldShowCharacterExample) {
            var me = new Character("Edwing123");
            me.levelUp();
            me.levelUp();
            me.levelUp();
            me.receiveDamage(10);

            if (me.isAlive()) {
                System.err.println("The character is still alive.");
            }

            me.heal(10);
            me.receiveDamage(50);
            System.err.println(me.getStats());
        }

        var shouldShowIfElseIf = false;

        if (shouldShowIfElseIf) {
            var javaOffer = new Offer("Java", OfferPriority.LOW);

            // NO.
            if (javaOffer.priority() == OfferPriority.HIGH) {
                System.err.println("Java offer has high priority.");
            } else if (javaOffer.priority() == OfferPriority.LOW) {
                System.err.println("Java offer has low priority.");
            } else {
                System.err.println("No offer has high priority.");
            }
        }

        var shouldShowLoops = true;

        if (shouldShowLoops) {
            var counter = 0;

            while (counter < 10) {
                System.err.println("Counter: " + counter);
                counter++;
            }

            // This time with do-while.
            counter = 0;

            do {
                System.err.println("Counter: " + counter);
                counter++;
            } while (counter < 10);

            // This time with a for-loop.
            for (var i = 0; i < 10; i++) {
                System.err.println("Counter: " + i);
            }

            // Enhanced for-loop.
            var grades = new int[]{89, 78, 80, 90, 100};
            var total = 0;

            for (var grade : grades) {
                total += grade;
            }

            var average = total / grades.length;
            System.err.println("Average: " + average);

            // Java has labeled and unlabeled break and continue statements.
        }
    }
}

enum OfferPriority {
    LOW,
    HIGH,
    NONE
}

record Offer(String name, OfferPriority priority) {

}

class Character {

    // The maximum level a character can reach.
    private final byte MAX_LEVEL = 100;
    private final byte MAX_HP = 100;

    private final String name;
    private byte level;
    private int hp;

    public Character(String name) {
        this.name = name;
        this.level = 0;
        this.hp = 100;
    }

    public void levelUp() {
        if (this.level < MAX_LEVEL) {
            this.level++;
        }
    }

    public void receiveDamage(int damage) {
        if (this.isAlive()) {
            this.hp -= damage;
        }
    }

    public void heal(int heal) {
        if (this.isAlive()) {
            this.hp += heal;
            if (this.hp > MAX_HP) {
                this.hp = MAX_HP;
            }
        }
    }

    public boolean isAlive() {
        return this.hp > 0;
    }

    public String getStats() {
        return STR.





    """
        Name: \{this.name}.
        Level: \{this.level}.
        HP: \{this.hp}.
        """;
    }
}
