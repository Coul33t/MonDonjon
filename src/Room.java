import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Room {
    private HashMap<String, Room> adjacentRooms;
    public boolean isFirst;
    public boolean isLast;

    public Room() {
        adjacentRooms = new HashMap<String, Room>();
        isFirst = false;
        isLast = false;
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
