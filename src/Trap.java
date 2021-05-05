public class Trap {

    private int damage;
    public boolean isActive;

    public Trap() {
        damage = 2;
        isActive = true;
    }

    public Trap(int dmg) {
        damage = dmg;
        isActive = true;
    }

    // Return the damage and deactivate the trap
    public int damagePlayer() {
        System.out.println("Oh non! Tu a marché sur une banane, tu prends " + damage + " points de dégâts !");
        isActive = false;
        return damage;
    }
}
