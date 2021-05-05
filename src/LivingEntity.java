import java.util.Random;

abstract class LivingEntity {
    protected int hp, hpMax, damage;
    public boolean alive;

    public void takeDamage(int damage) {
        hp -= damage;

        if (hp <= 0)
            alive = false;
    }

    // We could use takeDamage() with negative damage
    public void heal(int heal) {
        hp += heal;

        if (hp > hpMax)
            hp = hpMax;
    }

    public void attack(LivingEntity target) {
        Random r = new Random();
        int finalDamage = damage;

        // If we score 18 or more, we double the damage done (critical strike)
        if (r.nextInt(20) >= 18) {
            System.out.println("CRITICAL STRIKE!!!");
            finalDamage = damage * 2;
        }

        // Else, it's a normal strike, which is in the range (damage - 1, damage + 1)
        else {
            finalDamage = damage + (r.nextInt(3) - 1);
        }

        target.takeDamage(finalDamage);
    }
}
