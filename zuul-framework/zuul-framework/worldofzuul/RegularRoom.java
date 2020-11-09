package worldofzuul;

public class RegularRoom extends Room {
    public RegularRoom(String description) {

        super(description);
        roomInventory.fillUpRoom();
    }
}