package worldofzuul;

public class Trash {
    private Trashtype type;
    Sprites sprite;


    public Trash(Trashtype type, Sprites sprite) {
        this.type = type;
        this.sprite = sprite;
    }

    public Trashtype getType() {
        return type;
    }

    public Sprites getSprite() {
        return sprite;
    }
}
