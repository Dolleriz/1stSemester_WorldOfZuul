package worldofzuul;

import java.util.HashMap;

public enum Trashtype {

    PLASTIC("Plastik"),

    METAL_AND_GLASS("Metal og glas"),

    FOOD_WASTE("Madaffald"),

    PAPER("Papir og pap"),

    RESIDUAL_WASTE("Restaffald");

    private String trashString;

    Trashtype(String trashType){
        this.trashString = trashType;
    }

    public String toString() {
        return trashString;
    }
}
