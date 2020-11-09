package worldofzuul;

public class RegularRoom extends Room {
    public RegularRoom(String description) {

        super(description);
        roomInventory.addTrashToInventory();
    }

    public Inventory fillUpRoom() {
        for (int i = 0; i < roomInventory.inventory.length; i++) {
            roomInventory.inventory[i] = new Trash(Trashtype.PLASTIC);
        }
        return roomInventory;

    }
}