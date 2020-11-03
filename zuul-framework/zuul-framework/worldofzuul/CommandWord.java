package worldofzuul;

public enum CommandWord
{
    GO("gå"), QUIT("quit"), HELP("help"), UNKNOWN("?"), PICKUP("pickup"), INVENTORY("inventory");
    
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
