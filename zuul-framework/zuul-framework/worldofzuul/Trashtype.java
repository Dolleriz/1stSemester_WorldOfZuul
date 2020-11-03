package worldofzuul;

import java.util.HashMap;

public enum Trashtype {

    PLASTIC("Plastic. " +
            "\nIt is made of oil and other organic molecules." +
            "\nThis type of trash takes a long time to decay, " +
            "\nmeaning it can lay for a long time in nature, damaging ecosystems and animals."),

    METAL_AND_GLASS("Metal and glass. " +
            "\nThis type of trash is shiny, and hard. " +
            "\nIt consists of cans, aluminum foil, and is used to preserve foods or drinks."),

    ORGANIC("Organic trash. " +
            "\nThis type of trash consists of foods and other organic substances."),

    PAPER("paper. " +
            "\nThis type of trash is usually used for pizza packaging, hand-towels and other recyclable things."),

    RESIDUAL_WASTE("Residual waste. " +
            "\nThis type of trash is all the things that, does not fit into any of the four other categories.");

    private String trashString;

    Trashtype(String trashType){
        this.trashString = trashType;
    }

    public String toString() {
        return trashString;
    }
}
