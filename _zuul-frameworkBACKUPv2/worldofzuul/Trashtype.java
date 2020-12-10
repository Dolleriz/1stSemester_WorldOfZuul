package worldofzuul;

public enum Trashtype {

    FOOD_WASTE("food", "worldofzuul/img/TrashSprites/BittenApple.png"),

    METAL_AND_GLASS("Metal", "worldofzuul/img/TrashSprites/Can.png"),

    PAPER("paper", "worldofzuul/img/TrashSprites/CrumbledPaper.png"),

    PLASTIC("plastic", "worldofzuul/img/TrashSprites/BottleofWater.png"),

    RESIDUAL_WASTE("residual", "worldofzuul/img/TrashSprites/TrashBag.png");

    private String trashString;
    Sprites sprite;
    String filepath;

    Trashtype(String trashType, String filePath) {
        this.trashString = trashType;
        this.filepath = filePath;
        sprite = new Sprites();
        sprite.setImage(filePath);
            }

    public String getFilepath() {
        return filepath;
    }

    public String toString() {
        return trashString;
    }
}
