package worldofzuul;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

public enum Trashtype {

    FOOD_WASTE("Madaffald.", "img\\trash.png"),

    METAL_AND_GLASS("Metal og glas.", "img\\trash.png"),

    PAPER("Papir og pap.", "img\\trash.png"),

    PLASTIC("Plastik.", "img\\trash.png"),

    RESIDUAL_WASTE("Restaffald.", "img\\trash.png");

    private String trashString;
    Image image;

    Trashtype(String trashType, String filePath) {
        this.trashString = trashType;
        try{
        this.image = new Image(new FileInputStream(filePath));}
        catch (FileNotFoundException e){
            System.out.println("File not found");
        }
    }

    public String toString() {
        return trashString;
    }
}
