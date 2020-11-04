package worldofzuul;

public class RegularRoom extends Room {

    public RegularRoom(String description) {
        super(description);
    }

    Inventory roomInventory = new Inventory();
}
