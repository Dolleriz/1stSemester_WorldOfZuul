package worldofzuul;

public class Inventory {
    Trash[] inventory;


    public Inventory(int size) {
        this.inventory = new Trash[size];
    }

    public void removeTrashFromInventory(int length) {
        for (int i = 0; i < length; i++) {
            if (inventory[i] != null) {
                inventory[i] = null;
            }
        }
    }

    public void fillUpRoom() {
        double trashTypeNumber;

        for (int i = 0; i < inventory.length; i++) {
            trashTypeNumber = Math.random()*5;
            if (trashTypeNumber <= 1) {
                inventory[i] = new Trash(Trashtype.PLASTIC);
            }
             else if (trashTypeNumber <= 2) {
                inventory[i] = new Trash(Trashtype.METAL_AND_GLASS);
            }
             else if (trashTypeNumber <= 3) {
                 inventory[i] = new Trash(Trashtype.FOOD_WASTE);
            }
             else if (trashTypeNumber <= 4) {
                 inventory[i] = new Trash(Trashtype.PAPER);
            }
             else if (trashTypeNumber <= 5) {
                 inventory[i] = new Trash(Trashtype.RESIDUAL_WASTE);
            }
        }
    }

    public void addTrashToPlayer(Command command) {
        String trashTypeString;

        for (int i = 0; i < 1; i++) {
            trashTypeString = command.getSecondWord();
            if (trashTypeString == "plastik") {
                inventory[i] = new Trash(Trashtype.PLASTIC);
            }
            else if (trashTypeString == "metal") {
                inventory[i] = new Trash(Trashtype.METAL_AND_GLASS);
            }
            else if (trashTypeString == "mad") {
                inventory[i] = new Trash(Trashtype.FOOD_WASTE);
            }
            else if (trashTypeString == "papir") {
                inventory[i] = new Trash(Trashtype.PAPER);
            }
            else if (trashTypeString == "restaffald") {
                inventory[i] = new Trash(Trashtype.RESIDUAL_WASTE);
            }
        }
    }

    public boolean isInventoryFull() {
        while (true) {
            for (int i = 0; i < inventory.length; i++) {
                if (inventory[i] != null)
                    return true;
            }
            return false;
        }
    }

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
}


