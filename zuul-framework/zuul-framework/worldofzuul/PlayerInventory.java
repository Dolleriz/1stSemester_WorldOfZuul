package worldofzuul;

import java.util.Arrays;

public class PlayerInventory extends Inventory {

    public PlayerInventory(int f) {
        super(f);
    }

    Inventory[] playerInventory;



    @Override
    public String toString() {
        return Arrays.toString(playerInventory);
    }
}
