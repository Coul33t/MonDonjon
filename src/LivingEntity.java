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
        target.takeDamage(damage);
    }
}
