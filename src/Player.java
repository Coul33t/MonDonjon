public class Player {

    public Point coordinates;

    public Player() {
        coordinates = new Point();
    }

    public void setCoordinates(Point p) {
        coordinates = p;
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
}
