package worldofzuul;

public class RegularRoom extends Room {

    public RegularRoom(String description) {

        super(description);
        fillUpRoom();
    }

    public RegularRoom() {
    }

    public void fillUpRoom() {
        for (int i = 0; i < 10; i++) {
            double trashTypeNumber;

            trashTypeNumber = Math.random() * 5;
            if (trashTypeNumber <= 1) {
                roomInventory.inventory.add(new Trash(Trashtype.PLASTIC, Trashtype.PLASTIC.sprite));
            } else if (trashTypeNumber <= 2) {
                roomInventory.inventory.add(new Trash(Trashtype.METAL_AND_GLASS, Trashtype.METAL_AND_GLASS.sprite));
            } else if (trashTypeNumber <= 3) {
                roomInventory.inventory.add(new Trash(Trashtype.FOOD_WASTE, Trashtype.FOOD_WASTE.sprite));
            } else if (trashTypeNumber <= 4) {
                roomInventory.inventory.add(new Trash(Trashtype.PAPER, Trashtype.PAPER.sprite));
            } else if (trashTypeNumber <= 5) {
                roomInventory.inventory.add(new Trash(Trashtype.RESIDUAL_WASTE, Trashtype.RESIDUAL_WASTE.sprite));
            }
        }
    }

    public void fillUpRoomGUI() {
        for (int i = 0; i < roomInventoryGUI.length; i++) {
            double trashTypeNumber;

            trashTypeNumber = Math.random() * 5;
            if (trashTypeNumber <= 1) {
                roomInventoryGUI[i] = (new Trash(Trashtype.PLASTIC, Trashtype.PLASTIC.sprite));
            } else if (trashTypeNumber <= 2) {
                roomInventoryGUI[i] = (new Trash(Trashtype.METAL_AND_GLASS, Trashtype.METAL_AND_GLASS.sprite));
            } else if (trashTypeNumber <= 3) {
                roomInventoryGUI[i] = (new Trash(Trashtype.FOOD_WASTE, Trashtype.FOOD_WASTE.sprite));
            } else if (trashTypeNumber <= 4) {
                roomInventoryGUI[i] = (new Trash(Trashtype.PAPER, Trashtype.PAPER.sprite));
            } else if (trashTypeNumber <= 5) {
                roomInventoryGUI[i] = (new Trash(Trashtype.RESIDUAL_WASTE, Trashtype.RESIDUAL_WASTE.sprite));
            }
        }
    }


    public void printRoomInventory() { //can print the contents of the roomInventory without throwing a nullpointerexception
        if (roomInventory.inventory.isEmpty()) {
            System.out.println("Der er ikke noget affald.");
        } else {
            for (Trash trash : roomInventory.inventory) {
                System.out.println(trash.getType().toString());
            }
        }
    }
}

