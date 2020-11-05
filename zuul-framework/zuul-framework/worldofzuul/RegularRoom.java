package worldofzuul;

public class RegularRoom extends Room {
    Inventory roomInventory = new Inventory((int)(Math.random()*10)+5);

    public RegularRoom(String description) {

        super(description);
        roomInventory.addTrashToInventory();
    }

    /*public Inventory fillUpRoom() {
        for (int i = 0; i < roomInventory.inventory.length; i++) {
            roomInventory.inventory[i] = new Trash(Trashtype.PLASTIC);
        }
        return roomInventory;
        */
    }