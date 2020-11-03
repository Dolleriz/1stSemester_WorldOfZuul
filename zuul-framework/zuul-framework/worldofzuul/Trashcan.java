package worldofzuul;

import java.util.HashMap;

public class Trashcan {

    private String description;
    private HashMap<Integer, Trashcan> typeOfTrash;

    public Trashcan(String description) {
        this.description = description;
        typeOfTrash = new HashMap<Integer, Trashcan>();
    }

    public void setTypeOfTrash(Integer typeOfTrash) {
        typeOfTrash.intValue();
    }
}
