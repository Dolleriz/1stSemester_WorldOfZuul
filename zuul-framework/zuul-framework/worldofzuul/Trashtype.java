package worldofzuul;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

public enum Trashtype {

    FOOD_WASTE("Madaffald.", "worldofzuul/img/Transperent/Icon1.png"),

    METAL_AND_GLASS("Metal og glas.", "worldofzuul/img/Transperent/Icon2.png"),

    PAPER("Papir og pap.", "worldofzuul/img/Transperent/Icon3.png"),

    PLASTIC("Plastik.", "worldofzuul/img/Transperent/Icon4.png"),

    RESIDUAL_WASTE("Restaffald.", "worldofzuul/img/Transperent/Icon5.png");

    private String trashString;
    Sprites sprite;

    Trashtype(String trashType, String filePath) {
        this.trashString = trashType;
        sprite = new Sprites();
        sprite.setImage(filePath);
            }

    public String toString() {
        return trashString;
    }
}
