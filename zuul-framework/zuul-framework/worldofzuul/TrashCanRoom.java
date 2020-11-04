package worldofzuul;

import java.util.HashMap;

public class TrashCanRoom extends Room {

    public TrashCanRoom(String description) {
        super(description);
        createTrashcans();
        showTrashcans();
    }

    /*HashMap trashcans = new HashMap<Trashtype, Trashcan>();*/

    private Trashcan plastic, metalAndGlass, foodWaste, paper, residualWaste;

    public void createTrashcans() {

        plastic = new Trashcan(Trashtype.PLASTIC, "Plastik. " +
                "\nDenne Skraldespand er til plastik." +
                "\nHeri kan der komme f.eks. emballage, plastikposer, fryseposer, madfilm samt andre plastikting.");

        metalAndGlass = new Trashcan(Trashtype.METAL_AND_GLASS, "Metal og glas. " +
                "\nDenne Skraldespand er til metal og glas." +
                "\nHeri kan der komme f.eks. Glasflasker, Dåser, Alubakker, låg samt alufilm.");

        foodWaste = new Trashcan(Trashtype.FOOD_WASTE, "Madaffald. " +
                "\nDenne skraldespand er til madaffald." +
                "\nHeri kan der komme f.eks. Rester, Kaffegrums, frugter, grøntsager samt teblade.");

        paper = new Trashcan(Trashtype.PAPER, "Papir og pap. " +
                "\nDenne skraldespand er til papir og pap." +
                "\nHeri kan der komme f.eks. Blade, Kuverter, Telefonbøger, Morgenmadspakker, Æggebakker samt paprør");

        residualWaste = new Trashcan(Trashtype.RESIDUAL_WASTE, "Restaffald. " +
                "\nDenne skraldespand er til restaffald." +
                "\nHeri kan der komme f.eks. Kartoner, Pizzabakker, Bleer samt støvsugerposer.");
        /*
        trashcans.put(plastic, plastic);
        trashcans.put(metalAndGlass, metalAndGlass);
        trashcans.put(foodWaste, foodWaste);
        trashcans.put(paper, paper);
        trashcans.put(residualWaste, residualWaste);
        */
    }

    public void showTrashcans() {
        System.out.println(plastic.getDescription());
        System.out.println(metalAndGlass.getDescription());
        System.out.println(foodWaste.getDescription());
        System.out.println(paper.getDescription());
        System.out.println(residualWaste.getDescription());
    }
}

