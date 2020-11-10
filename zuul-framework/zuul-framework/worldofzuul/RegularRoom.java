package worldofzuul;

public class RegularRoom extends Room {
    public RegularRoom(String description) {

        super(description);
        roomInventory.fillUpRoom();
    }

    public void printRoomInventory() { //can print the contents of the roomInventory without throwing a nullpointerexception
        int trashInRoom = 0;
        for (int i = 0; i < roomInventory.inventory.length; i++) {

            if (roomInventory.inventory[i] != null) {
                trashInRoom++;
            }
        }
        if (trashInRoom != 0) {
            for (int i = 0; i < roomInventory.inventory.length; i++) {
                if (roomInventory.inventory[i] != null) {
                    System.out.println(roomInventory.inventory[i].getType().toString());
                }
            }
        } else {
            System.out.println("Der er ikke mere affald");
        }
    }
}

