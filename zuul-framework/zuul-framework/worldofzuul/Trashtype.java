package worldofzuul;

import java.util.HashMap;

public class Trashtype {

    private String description;
    private HashMap<Integer, Trashtype> typeOfTrash;

    public Trashtype (String description) {
        this.description = description;
        typeOfTrash = new HashMap<Integer, Trashtype>();
    }

    public void setTypeOfTrash(Integer typeOfTrash) {
        typeOfTrash.intValue();
    }
}
