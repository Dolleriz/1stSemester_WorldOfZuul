package worldofzuul;

public class Trash {
    private Trashtype type;


    public Trash(Trashtype type) {
        this.type = type;
        Trashtype plastic = Trashtype.PLASTIC;
        Trashtype metalAndGlass = Trashtype.METAL_AND_GLASS;
        Trashtype foodWaste = Trashtype.FOOD_WASTE;
        Trashtype paper = Trashtype.PAPER;
        Trashtype residualWaste = Trashtype.RESIDUAL_WASTE;
    }
}
