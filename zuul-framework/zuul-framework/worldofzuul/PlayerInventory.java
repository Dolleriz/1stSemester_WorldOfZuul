package worldofzuul;

import java.util.ArrayList;
import java.util.Arrays;

public class PlayerInventory extends Inventory {

    PlayerInventory playerInventory;

    public static int getPlayerInventoryMax() {
        return PLAYER_INVENTORY_MAX;
    }

    private static final int PLAYER_INVENTORY_MAX = 5;

    public PlayerInventory(PlayerInventory playerInventory) {
        super(PLAYER_INVENTORY_MAX);
        this.playerInventory = playerInventory;
        printPlayerInventory();
    }

    private void printPlayerInventory() {
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

    @Override
    public String toString() {
        return toString();
    }
}
