public class Player {

    public Point coordinates;
    private int hp, hpMax;
    public boolean alive;

    public Player() {
        coordinates = new Point();
        hpMax = 10;
        hp = hpMax;
        alive = true;
    }

    public void setCoordinates(Point p) {
        coordinates = p;
    }

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

    public void move(String dir) {
        if ("North".equals(dir))
            coordinates.y -= 1;
        else if ("East".equals(dir))
            coordinates.x += 1;
        else if ("South".equals(dir))
            coordinates.y += 1;
        else if ("West".equals(dir))
            coordinates.x -= 1;
    }

    public String toString() {
        return hp + "/" + hpMax + " (" + coordinates.x + ", " + coordinates.y + ")";
    }
}
