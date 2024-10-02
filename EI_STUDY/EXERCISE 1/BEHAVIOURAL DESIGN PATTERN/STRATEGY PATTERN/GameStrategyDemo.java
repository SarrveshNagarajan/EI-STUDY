interface AttackStrategy {
    void attack();
}

class SwordAttack implements AttackStrategy {
    @Override
    public void attack() {
        System.out.println("Attacking with a sword! Slash!");
    }
}

class BowAttack implements AttackStrategy {
    @Override
    public void attack() {
        System.out.println("Shooting arrows from a bow! Twang!");
    }
}

class MagicAttack implements AttackStrategy {
    @Override
    public void attack() {
        System.out.println("Casting a magical spell! Whoosh!");
    }
}

class GameCharacter {
    private String name;
    private AttackStrategy attackStrategy;

    public GameCharacter(String name) {
        this.name = name;
    }

    public void setAttackStrategy(AttackStrategy attackStrategy) {
        this.attackStrategy = attackStrategy;
    }

    public void attack() {
        System.out.print(name + " is ");
        attackStrategy.attack();
    }
}

public class GameStrategyDemo {
    public static void main(String[] args) {
        GameCharacter knight = new GameCharacter("Sir Galahad");
        GameCharacter archer = new GameCharacter("Robin Hood");
        GameCharacter mage = new GameCharacter("Merlin");

        knight.setAttackStrategy(new SwordAttack());
        archer.setAttackStrategy(new BowAttack());
        mage.setAttackStrategy(new MagicAttack());

        knight.attack();
        archer.attack();
        mage.attack();

        System.out.println("\nKnight picks up a bow:");
        knight.setAttackStrategy(new BowAttack());
        knight.attack();
    }
}