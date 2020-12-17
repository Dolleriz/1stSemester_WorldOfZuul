package worldofzuul;

import java.util.HashMap;

/**
 * The enum Trashtype.
 */
public enum Trashtype {

    /**
     * Plastic trashtype.
     */
    PLASTIC("Plastik."),

    /**
     * The Metal and glass.
     */
    METAL_AND_GLASS("Metal og glas."),

    /**
     * Food waste trashtype.
     */
    FOOD_WASTE("Madaffald."),

    /**
     * The Paper.
     */
    PAPER("Papir og pap."),

    /**
     * Residual waste trashtype.
     */
    RESIDUAL_WASTE("Restaffald.");

    private String trashString;

    Trashtype(String trashType){
        this.trashString = trashType;
    }

    public String toString() {
        return trashString;
    }
}
