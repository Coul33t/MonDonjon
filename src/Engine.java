import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Engine {
    private Dungeon dungeon;
    private Player player;

    public Engine() {
        dungeon = new Dungeon();
        player = new Player();
    }

    // Initialise the dungeon and the player position
    public void init() {
        dungeon.buildDungeon();
        player.setCoordinates(dungeon.getFirstRoomCoordinates());
    }

    // Writes the intro of the game
    public void introText() {
        System.out.println("---------------------------------------------------------");
        System.out.println("Slt sava?");
        System.out.println("B1venu ds le donjon hinhinhin");
        System.out.println("Tu a peure? C NORMALE XDDDD");
        System.out.println("Okayyyyyy let's goooooooo...(t'es mature pour ton âge :3)");
        System.out.println("---------------------------------------------------------");
        System.out.println("\n\n\n");
    }

    public void endText() {
        System.out.println("Merci d'avoir joué à Dungeon Walking Simulator.");
        System.out.println("...");
        System.out.println("Aller casse-toi maintenant ptn j'suis pas ta mère");
    }

    // Format the direction chosen by the player
    private String formatDirection(String playerChoice) {
        String formated = "None";

        if("n".equals(playerChoice.toLowerCase()) || "north".equals(playerChoice.toLowerCase()))
            formated = "North";

        else if("e".equals(playerChoice.toLowerCase()) || "east".equals(playerChoice.toLowerCase()))
            formated = "East";

        else if("s".equals(playerChoice.toLowerCase()) || "south".equals(playerChoice.toLowerCase()))
            formated = "South";

        else if("w".equals(playerChoice.toLowerCase()) || "west".equals(playerChoice.toLowerCase()))
            formated = "West";

        return formated;
    }

    // Checks if the direction chosen by the player is valid
    private boolean checkPlayerChoice(String playerChoice) {
        ArrayList<String> possibilities = dungeon.getRoom(player.coordinates).getPossibleDirection();

        for (String dir: possibilities) {
            if (dir.equals(formatDirection(playerChoice)))
                return true;
        }

        return false;
    }

    public void run() {
        init();
        introText();
        boolean playing = true;

        Scanner scanner = new Scanner(System.in);
        String playerChoice;
        ArrayList<String> possibleDirections;

        while(playing) {
            Display.writeChoices(dungeon.getRoom(player.coordinates).getPossibleDirection());
            playerChoice = scanner.nextLine();
            playerChoice = formatDirection(playerChoice);

            if(playerChoice != null && checkPlayerChoice(playerChoice)) {
                player.move(playerChoice);
                if (dungeon.getRoom(player.coordinates).isLast) {
                    endText();
                    return;
                }

                else if (dungeon.getRoom(player.coordinates).hasActiveTrap()) {
                    player.takeDamage(dungeon.getRoom(player.coordinates).trap.damagePlayer());
                }

                System.out.println(player);

                if (!player.alive) {
                    System.out.println("T mor hinhinhin");
                    return;
                }
            }

            else {
                System.out.println("Veuillez choisir une direction valide.");
            }

        }
    }
}
