package worldofzuul;

import java.util.HashMap;

public enum Trashtype {

    PLASTIC("Plastik. " +
            "\nDet er lavet af olie og andre organiske materialer." +
            "\nDenne type af affald er lang tid om at blive nedbrudt, " +
            "\nhvilket betyder det vil ligge i naturen i lang tid, hvor det kan skade økosystemer og dyr."),

    METAL_AND_GLASS("Metal  og glas. " +
            "\nDisse typer af affald er skinnende, hårde og skarpe. " +
            "\nDet består af dåser, sølvpapir samt glas og flasker,  og bliver brugt til at opbevare mad og drikke."),

    FOOD_WASTE("Madaffald. " +
            "\n Denne type af affald består af madrester og andet organisk materiale."),

    PAPER("Papir og pap. " +
            "\nDenne type af affald består normalt af papkasser, aviser, og andre papir ting."),

    RESIDUAL_WASTE("Restaffald. " +
            "\nDenne type af affald er alle ting der ikke passer ind i de fire andre kategorier.");

    private String trashString;

    Trashtype(String trashType){
        this.trashString = trashType;
    }

    public String toString() {
        return trashString;
    }
}
