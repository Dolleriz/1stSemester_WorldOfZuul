package worldofzuul;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

public enum Trashtype {

    FOOD_WASTE("Madaffald.", "worldofzuul/img/TrashSprites/BittenApple.png"),

    METAL_AND_GLASS("Metal og glas.", "worldofzuul/img/TrashSprites/Can.png"),

    PAPER("Papir og pap.", "worldofzuul/img/TrashSprites/CrumbledPaper.png"),

    PLASTIC("Plastik.", "worldofzuul/img/TrashSprites/BottleofWater.png"),

    RESIDUAL_WASTE("Restaffald.", "worldofzuul/img/TrashSprites/TrashBag.png");

    private String trashString;
    Sprites sprite;
    String filepath;

    Trashtype(String trashType, String filePath) {
        this.trashString = trashType;
        this.filepath = filePath;
        sprite = new Sprites();
        sprite.setImage(filePath);
            }

    public String getFilepath() {
        return filepath;
    }

    public String toString() {
        return trashString;
    }
}
