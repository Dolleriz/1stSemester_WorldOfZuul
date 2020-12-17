package worldofzuul;

import java.util.ArrayList;

/**
 * The type Trashcan.
 */
public class Trashcan {

    private Trashtype correctTrashType;

    private String description;

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Instantiates a new Trashcan.
     *
     * @param trashType   the trash type
     * @param description the description
     */
    public Trashcan (Trashtype trashType, String description) {
        this.correctTrashType = trashType;
        this.description = description;
    }
}
