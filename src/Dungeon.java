public class Dungeon {
    private Room[][] dungeonMap;

    public Dungeon() {
        dungeonMap = new Room[3][4];
    }

    public Room[][] getMap() {
        return dungeonMap;
    }

    // TODO: custom exception
    public Point getFirstRoomCoordinates() {
        for (int y = 0; y < dungeonMap.length; y++) {
            for (int x = 0; x < dungeonMap[0].length; x++) {
                if (dungeonMap[y][x] != null && dungeonMap[y][x].isFirst)
                    return new Point(x, y);
            }
        }

        return new Point(-1, -1);
    }

    // TODO: custom exception
    public Point getLastRoomCoordinates() {
        for (int y = 0; y < dungeonMap.length; y++) {
            for (int x = 0; x < dungeonMap[0].length; x++) {
                if (dungeonMap[y][x].isLast)
                    return new Point(x, y);
            }
        }

        return new Point(-1, -1);
    }

    // TODO: custom exception
    public Room getRoom(int x, int y) {
        if (x >= 0 && x < dungeonMap[0].length &&
            y >= 0 && y < dungeonMap.length &&
            dungeonMap[y][x] != null)

            return dungeonMap[y][x];

        return null;
    }

    // TODO: custom exception
    public Room getRoom(Point p) {
        if (p.x >= 0 && p.x < dungeonMap[0].length &&
            p.y >= 0 && p.y < dungeonMap.length &&
            dungeonMap[p.y][p.x] != null)

            return dungeonMap[p.y][p.x];

        return null;
    }
    /*
        Build a dungeon like this:
                  R5--R6
                  |
                 R4
                 |
        R1--R2--R3
     */
    public void buildDungeon() {
        dungeonMap[2][0] = new Room();
        dungeonMap[2][1] = new Room();
        dungeonMap[2][2] = new Room();
        dungeonMap[1][2] = new Room();
        dungeonMap[0][2] = new Room();
        dungeonMap[0][3] = new Room();

        dungeonMap[2][0].isFirst = true;
        dungeonMap[0][3].isLast = true;

        // R1
        dungeonMap[2][0].setRoomInDirection("East", dungeonMap[2][1]);

        // R2
        dungeonMap[2][1].setRoomInDirection("East", dungeonMap[2][2]);
        dungeonMap[2][1].setRoomInDirection("West", dungeonMap[2][0]);

        // R3
        dungeonMap[2][2].setRoomInDirection("North", dungeonMap[1][2]);
        dungeonMap[2][2].setRoomInDirection("West", dungeonMap[2][1]);

        // R4
        dungeonMap[1][2].setRoomInDirection("North", dungeonMap[0][2]);
        dungeonMap[1][2].setRoomInDirection("South", dungeonMap[2][2]);

        // R5
        dungeonMap[0][2].setRoomInDirection("East", dungeonMap[0][3]);
        dungeonMap[0][2].setRoomInDirection("South", dungeonMap[1][2]);

        // R6
        dungeonMap[0][3].setRoomInDirection("West", dungeonMap[0][2]);
    }
}
