package worldofzuul;

/**
 * The enum Command word.
 */
public enum CommandWord
{
    /**
     * Go command word.
     */
    GO("gå"),
    /**
     * Quit command word.
     */
    QUIT("afslut"),
    /**
     * Help command word.
     */
    HELP("hjælp"),
    /**
     * Unknown command word.
     */
    UNKNOWN("?"),
    /**
     * Pickup command word.
     */
    PICKUP("tag"),
    /**
     * Inventory command word.
     */
    INVENTORY("taske"),
    /**
     * Trashcan command word.
     */
    TRASHCAN("skraldespand "),
    /**
     * Throwout command word.
     */
    THROWOUT("smid"),
    /**
     * Trashdescription command word.
     */
    TRASHDESCRIPTION("beskriv");


    private String commandString;
    
    CommandWord(String commandString)
    {
        this.commandString = commandString;
    }
    
    public String toString()
    {
        return commandString;
    }
}
