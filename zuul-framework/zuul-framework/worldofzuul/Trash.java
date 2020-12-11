package worldofzuul;

//Our trash class that makes us able to set a sprite and a type
//Is used to distinguish the trash in both our GUI and CLI version.
public class Trash {
    private Trashtype type;
    Sprites sprite;


    public Trash(Trashtype type, Sprites sprite) {
        this.type = type;
        this.sprite = sprite;
    }
    public Trash(Trashtype type) {
        this.type = type;
    }

    public Trashtype getType() {
        return type;
    }

    public Sprites getSprite() {
        return sprite;
    }
}
