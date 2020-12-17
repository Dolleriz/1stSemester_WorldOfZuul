package worldofzuul;


//Most code in here is for the CLI version as we used solely imageViews in our GUI version.
public class TrashCanRoom extends Room {
    public TrashCanRoom(String description) {
        super(description);
        createTrashcans();

    }

    public TrashCanRoom(){
        createTrashcans();
    }


    Trashcan plastic, metalAndGlass, foodWaste, paper, residualWaste;

    public Trashcan getPlastic() {
        return plastic;
    }

    public Trashcan getMetalAndGlass() {
        return metalAndGlass;
    }

    public Trashcan getFoodWaste() {
        return foodWaste;
    }

    public Trashcan getPaper() {
        return paper;
    }

    public Trashcan getResidualWaste() {
        return residualWaste;
    }

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

    }



    public void showPlastic() {
        System.out.println(plastic.getDescription());
    }

    public void showMetalAndGlass() {
        System.out.println(metalAndGlass.getDescription());
    }

    public void showFoodWaste() {
        System.out.println(foodWaste.getDescription());
    }

    public void showPaper() {
        System.out.println(paper.getDescription());
    }

    public void showResidualWaste() {
        System.out.println(residualWaste.getDescription());
    }
}


