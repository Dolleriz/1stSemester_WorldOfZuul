package worldofzuul;


//We added code here mostly for the CLI version to access command words to get functionality for sorting, pickUp
//help, inventory etc.
public enum CommandWord
{
    GO("gå"), QUIT("afslut"), HELP("hjælp"), UNKNOWN("?"),
    PICKUP("tag"), INVENTORY("taske"), TRASHCAN("skraldespand "),
    THROWOUT("smid"), TRASHDESCRIPTION("beskriv");


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
