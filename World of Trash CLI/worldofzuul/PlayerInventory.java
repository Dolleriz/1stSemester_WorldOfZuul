package worldofzuul;

import java.util.Arrays;

/**
 * The type Player inventory.
 */
public class PlayerInventory extends Inventory {

    /**
     * Instantiates a new Player inventory.
     *
     * @param size the size
     */
    public PlayerInventory(int size) {
        super(size);
    }

    @Override
    public String toString() {
        return toString();
    }

    /**
     * Print player inventory.
     *
     * @param playerInventory the player inventory
     */
    public void printPlayerInventory(PlayerInventory playerInventory) {
        System.out.println("Du kan max have 5 stykker affald i dine lommer. " +
                "\nI dine lommer har du: ");

        for (int i = 0; i < playerInventory.inventory.size(); i++) {
            if (playerInventory.inventory.get(i) == null) {
                System.out.println("Der er ikke noget i denne lomme!");
                break;

            } else {
                System.out.println(playerInventory.inventory.get(i).getType().toString());
            }
        }
    }
}
