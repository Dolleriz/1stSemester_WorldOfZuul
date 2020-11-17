package worldofzuul;

import java.util.ArrayList;
import java.util.Scanner;

public class Trashcan {

    private Trashtype correctTrashType;

    private String description;

    public String getDescription() {
        return description;
    }

    public Trashcan (Trashtype trashType, String description) {
        this.correctTrashType = trashType;
        this.description = description;
    }

    private void sortingTrash (String trashtype, Trashtype trashtypeEnum, int point) {

        Scanner trashcan = new Scanner(System.in);

        for (int i = 0; i < PlayerInventory.getPlayerInventoryMax(); i++) {
            if (.inventory.get(i).getType() == trashtypeEnum) {
                try {
                    garbageArea.printTrashcans();
                    if (trashcan.nextLine().equalsIgnoreCase(trashtype)) {
                        playerScore.increasePlayerScore(point);
                        playerInventory.inventory.remove(i);
                        trashThrownOut();
                    } else {
                        playerScore.decreasePlayerScore(point);
                        System.out.println("Dette var ikke korrekt.");
                        playerScore.showPlayerScore();
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Du skal skrive en type, prøv igen.");
                }
            }
            else {
                System.out.println("Du har ikke denne type affald i tasken, prøv igen.");
            }
        }
    }

    private void trashThrownOut () {
        System.out.println("Du har sorteret korrekt, godt arbejde!");
        printPlayerInventory(playerInventory);
        System.out.println(" ");
        playerScore.showPlayerScore();
    }

    public boolean accepts(Trashtype trashType) {
        return trashType == correctTrashType;
    }
}
