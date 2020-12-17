package worldofzuul;


import java.util.ArrayList;

/**
 * The type Inventory.
 */
public class Inventory {
    /**
     * The Inventory.
     */
    ArrayList<Trash> inventory;

    /**
     * Instantiates a new Inventory.
     *
     * @param inventory the inventory
     */
    public Inventory(ArrayList<Trash> inventory) {
        this.inventory = inventory;
    }

    /**
     * Instantiates a new Inventory.
     *
     * @param size the size
     */
    public Inventory(int size) {
        this.inventory = new ArrayList<>();
    }
}