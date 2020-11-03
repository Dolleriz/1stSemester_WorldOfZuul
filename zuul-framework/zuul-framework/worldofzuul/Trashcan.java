package worldofzuul;

import java.util.HashMap;

public class Trashcan {

    private String description;
    private HashMap<Integer, Trashcan> typeOfTrashcan;

    public Trashcan(String description) {
        this.description = description;
        typeOfTrashcan = new HashMap<Integer, Trashcan>();
    }

    public void setTypeOfTrashcan(Integer typeOfTrash) {
        typeOfTrash.intValue();
    }
}
