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