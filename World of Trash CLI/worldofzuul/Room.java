package worldofzuul;

import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;


/**
 * The type Room.
 */
public class Room
{
    private String description;
    private HashMap<String, Room> exits;
    /**
     * The Room inventory.
     */
    Inventory roomInventory = new Inventory(10);

    /**
     * Instantiates a new Room.
     *
     * @param description the description
     */
    public Room(String description)
    {
        this.description = description;
        exits = new HashMap<String, Room>();
    }

    /**
     * Sets exit.
     *
     * @param direction the direction
     * @param neighbor  the neighbor
     */
    public void setExit(String direction, Room neighbor)
    {
        exits.put(direction, neighbor);
    }

    /**
     * Gets short description.
     *
     * @return the short description
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * Gets long description.
     *
     * @return the long description
     */
    public String getLongDescription()
    {
        return "Du er " + description + ".\n" + getExitString();
    }

    private String getExitString()
    {
        String returnString = "Udgange:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    /**
     * Gets exit.
     *
     * @param direction the direction
     * @return the exit
     */
    public Room getExit(String direction)
    {
        return exits.get(direction);
    }
}

