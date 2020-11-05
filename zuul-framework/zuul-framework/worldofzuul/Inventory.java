package worldofzuul;

public class Inventory {
    Trash[] inventory;

    public Inventory(int f) {
        this.inventory = new Trash[f];
    }

    public void removeTrashFromInventory() {
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] != null) {
                inventory[i] = null;
            }

        }
    }

    public void addTrashToInventory() {
        for (int i = 0; i < inventory.length; i++) {
            inventory[i] = new Trash(Trashtype.PLASTIC);
        }

    }

    @Override
    public String toString() {
        return "Der er: " + inventory.length + " stykker skrald i rummet";
    }
}


