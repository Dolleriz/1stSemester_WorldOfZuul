package worldofzuul;

import java.util.HashMap;
import java.util.Scanner;

/**
 * The type Trash can room.
 */
public class TrashCanRoom extends Room {
    //HashMap trashcans = new HashMap<String, Trashcan>();

    /**
     * Instantiates a new Trash can room.
     *
     * @param description the description
     */
    public TrashCanRoom(String description) {
        super(description);
        createTrashcans();
    }


    private Trashcan plastic, metalAndGlass, foodWaste, paper, residualWaste;

    /**
     * Create trashcans.
     */
    public void createTrashcans() {

        plastic = new Trashcan(Trashtype.PLASTIC, "Plastik. " +
                "\nDenne Skraldespand er til plastik." +
                "\nDet er lavet af olie og andre organiske materialer." +
                "\nDenne type af affald er lang tid om at blive nedbrudt," +
                "\nhvilket betyder det vil ligge i naturen i lang tid, hvor det kan skade økosystemer og dyr." +
                "\nHeri kan der komme f.eks. emballage, plastikposer, fryseposer, madfilm samt andre plastikting.");

        metalAndGlass = new Trashcan(Trashtype.METAL_AND_GLASS, "Metal og glas. " +
                "\nDenne Skraldespand er til metal og glas." +
                "\nDisse typer af affald er skinnende, hårde og skarpe. " +
                "\nDet består af dåser, sølvpapir samt glas og flasker, " +
                "\nog bliver brugt til at opbevare mad og drikke." +
                "\nHeri kan der komme f.eks. Glasflasker, Dåser, Alubakker, låg samt alufilm.");

        foodWaste = new Trashcan(Trashtype.FOOD_WASTE, "Madaffald. " +
                "\nDenne skraldespand er til madaffald." +
                "\n Denne type af affald består af madrester og andet organisk materiale." +
                "\nHeri kan der komme f.eks. Rester, Kaffegrums, frugter, grøntsager samt teblade.");

        paper = new Trashcan(Trashtype.PAPER, "Papir og pap. " +
                "\nDenne skraldespand er til papir og pap." +
                "\nDenne type af affald består normalt af papkasser, aviser, og andre papir ting." +
                "\nHeri kan der komme f.eks. Blade, Kuverter, Telefonbøger, Morgenmadspakker, Æggebakker samt paprør");

        residualWaste = new Trashcan(Trashtype.RESIDUAL_WASTE, "Restaffald. " +
                "\nDenne skraldespand er til restaffald." +
                "\nDenne type af affald er alle ting der ikke passer ind i de fire andre kategorier." +
                "\nHeri kan der komme f.eks. Kartoner, Pizzabakker, Bleer samt støvsugerposer.");

        /*trashcans.put("plastic", plastic);
        trashcans.put("metalAndGlass", metalAndGlass);
        trashcans.put("foodWaste", foodWaste);
        trashcans.put("paper", paper);
        trashcans.put("residualWaste", residualWaste);*/

    }

    /**
     * Print trashcans.
     */
    public void printTrashcans() {
        System.out.println("Hvor vil du gerne smide dette ud?");
        System.out.println(" ");
        System.out.println("> Plastik" +
                "\n> Metal og Glas" +
                "\n> Madaffald" +
                "\n> Papir og Pap" +
                "\n> Restaffald");
    }

    /**
     * Show plastic.
     */
    public void showPlastic() {
        System.out.println(plastic.getDescription());
    }

    /**
     * Show metal and glass.
     */
    public void showMetalAndGlass() {
        System.out.println(metalAndGlass.getDescription());
    }

    /**
     * Show food waste.
     */
    public void showFoodWaste() {
        System.out.println(foodWaste.getDescription());
    }

    /**
     * Show paper.
     */
    public void showPaper() {
        System.out.println(paper.getDescription());
    }

    /**
     * Show residual waste.
     */
    public void showResidualWaste() {
        System.out.println(residualWaste.getDescription());
    }

    /**
     * Gets trash can description.
     */
    public void getTrashCanDescription() {
        Scanner inputTrash = new Scanner(System.in);
        System.out.println("Hvilken skraldespand vil du gerne vide mere om?");
        String trashcanInput = inputTrash.next();
        if (trashcanInput.equals("plastik")) {
            showPlastic();
        } else if (trashcanInput.equalsIgnoreCase("metal-og-glas")) {
            showMetalAndGlass();
        } else if (trashcanInput.equalsIgnoreCase("madaffald")) {
            showFoodWaste();
        } else if (trashcanInput.equalsIgnoreCase("papir")) {
            showPaper();
        } else if (trashcanInput.equalsIgnoreCase("restaffald")) {
            showResidualWaste();
        }
    }
}



