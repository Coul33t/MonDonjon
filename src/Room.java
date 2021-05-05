import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.stream.Collectors;

public class Room {
    public boolean isFirst;
    public boolean isLast;

    public Trap trap;
    public Monster monster;
    private HashMap<String, Room> adjacentRooms;



    public Room() {
        adjacentRooms = new HashMap<String, Room>();
        isFirst = false;
        isLast = false;

        trap = null;
        Random r = new Random();
        if(r.nextInt(10) > 8) {
            trap = new Trap(r.nextInt(2) + 1);
        }

        monster = null;
        if(r.nextInt(20) > 15) {
            monster = new Monster();
        }
    }

    // Check if the room has a trap, and if the trap is active or not
    public boolean hasActiveTrap() {
        return (trap != null && trap.isActive);
    }

    public boolean hasAliveMonster() {
        return (monster != null && monster.alive);
    }

    public void setRoomInDirection(String dir, Room r) {
        adjacentRooms.put(dir, r);
    }

    // TODO: custom exception
    public Room getRoomInDirection(String dir) {
        if (adjacentRooms.containsKey(dir))
            return adjacentRooms.get(dir);
        return null;
    }

    // Returns a list of possible directions from the current room
    public ArrayList<String> getPossibleDirection() {
        // Yeah weird ass methods chaining to just have a fucking list of Strings uh
        return (ArrayList<String>)adjacentRooms.keySet()
                                               .stream()
                                               .collect(Collectors.toList());
    }

}
