package worldofzuul;


import java.util.ArrayList;

public class Inventory {
    ArrayList<Trash> inventory;


    public Inventory(ArrayList<Trash> inventory) {
        this.inventory = inventory;
    }

    public Inventory(int size) {
        this.inventory = new ArrayList<>();
    }
}

/*    public void addTrashToPlayer(Command command) { we don't know if we need it
        String trashTypeString;

        for (int i = 0; i < 1; i++) {
            trashTypeString = command.getSecondWord();
            if (trashTypeString == "plastik") {
                inventory.add(i, new Trash(Trashtype.PLASTIC));
            } else if (trashTypeString == "metal") {
                inventory.add(i, new Trash(Trashtype.METAL_AND_GLASS));
            } else if (trashTypeString == "mad") {
                inventory.add(i, new Trash(Trashtype.FOOD_WASTE));
            } else if (trashTypeString == "papir") {
                inventory.add(i, new Trash(Trashtype.PAPER));
            } else if (trashTypeString == "restaffald") {
                inventory.add(i, new Trash(Trashtype.RESIDUAL_WASTE));
            }
        }
   }
*/

/*  This is not used right now
    @Override
    public String toString() {
        int trashInRoom = 0;
        for (int i = 0; i < inventory.length; i++) {

            if (inventory[i] != null) {
                trashInRoom++;
            }
        }

        return "Der er: " + trashInRoom + " stykker skrald i rummet";
    }
    */