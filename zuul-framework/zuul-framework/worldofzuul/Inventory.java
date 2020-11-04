package worldofzuul;

public class Inventory
{
    Trash[] inventory = new Trash[(int) (Math.random()*5) + 5];

    public Inventory()
    {

    }

    @Override
    public String toString() {
        return "Der er: " + inventory.length + " stykker skrald i rummet";
    }
}
