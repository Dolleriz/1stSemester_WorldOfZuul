package worldofzuul;


//mostly used code for our CLI version.
//Pretty much just used to get a description of our TrashCans as we didn't use the trashType here for comparison
//We used a normal String instead
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
