package worldofzuul;

public class Trashcan {

    private Trashtype correctTrashType;

    private String description;

    public String getDescription() {
        return description;
    }

    public Trashcan (Trashtype trashType, String description) {
        this.correctTrashType = trashType;
        this.description = description;
    }

    public Trashtype getTrashType(){
        return this.correctTrashType;
    }
}
