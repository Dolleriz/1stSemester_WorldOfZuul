package worldofzuul;

import java.util.ArrayList;

public class Trashcan {

    private Trashtype correctTrashType;

    private String description;
    private ArrayList<Trashtype> typeOfTrashcan;

    public Trashcan (Trashtype trashType, String description) {
        this.correctTrashType = trashType;
        this.description = description;
        typeOfTrashcan = new ArrayList<>();
    }


}
