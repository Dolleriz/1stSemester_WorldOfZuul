package worldofzuul;
import java.util.HashMap;


/**
 * The type Command words.
 */
public class CommandWords
{
    private HashMap<String, CommandWord> validCommands;

    /**
     * Instantiates a new Command words.
     */
    public CommandWords()
    {
        validCommands = new HashMap<String, CommandWord>();
        for(CommandWord command : CommandWord.values()) {
            if(command != CommandWord.UNKNOWN) {
                validCommands.put(command.toString(), command);
            }
        }
    }

    /**
     * Gets command word.
     *
     * @param commandWord the command word
     * @return the command word
     */
    public CommandWord getCommandWord(String commandWord)
    {
        CommandWord command = validCommands.get(commandWord);
        if(command != null) {
            return command;
        }
        else {
            return CommandWord.UNKNOWN;
        }
    }

    /**
     * Is command boolean.
     *
     * @param aString the a string
     * @return the boolean
     */
    public boolean isCommand(String aString)
    {
        return validCommands.containsKey(aString);
    }

    /**
     * Show all.
     */
    public void showAll()
    {
        for(String command : validCommands.keySet()) {
            System.out.print(command + "  ");
        }
        System.out.println();
    }
}
