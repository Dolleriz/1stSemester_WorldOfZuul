package worldofzuul;

import java.util.ArrayList;

public class Trashcan {

    private Trashtype correctTrashType;

    public Trashtype getCorrectTrashType() {
        return correctTrashType;
    }

    private String description;

    public String getDescription() {
        return description;
    }

    public Trashcan (Trashtype trashType, String description) {
        this.correctTrashType = trashType;
        this.description = description;
    }
}
