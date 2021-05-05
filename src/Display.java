import java.util.ArrayList;

public class Display {
    public static void displayDungeon(Dungeon dungeon) {

        for (int y = 0; y < dungeon.getMap().length; y++) {
            for (int x = 0; x < dungeon.getMap()[0].length; x++) {
                if (dungeon.getRoom(x, y) != null)
                    System.out.print("R");
                else
                    System.out.print("·");
                System.out.print(" ");
            }

            System.out.println();
        }
    }

    public static void writeChoices(ArrayList<String> choices) {
        System.out.println("Quelle direction voulez-vous prendre ?");
        for (String dir: choices) {
            System.out.println(dir);
        }
    }
}
