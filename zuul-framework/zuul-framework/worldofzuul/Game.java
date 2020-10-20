package worldofzuul;

public class Game 
{
    private Parser parser;
    private Room currentRoom;
        

    public Game() 
    {
        createRooms();
        parser = new Parser();
    }


    private void createRooms()
    {
        Room outside, garbageArea, entrance, livingRoom, lab, office;
      
        outside = new Room("outside, to the west is your house, filled with trash that needs to be collected. " +
                "North, is the garbage area.");
        garbageArea = new Room("Garbage area, in front of you is a set of bins. " +
                "In your inventory you should have a bunch of garbage, ready to be sorted. Otherwise, get collecting!");
        entrance = new Room("Entrance. The walls are decorated with dull paintings and generic family photos." +
                "You are facing the table with photos on them. Outside is to the west and the living room is to the east.");
        livingRoom = new Room("Living Room. ");
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office");
        
        outside.setExit("east", entrance);
        outside.setExit("north", garbageArea);

        garbageArea.setExit("south", outside);

        entrance.setExit("west", outside);
        entrance.setExit("east", livingRoom);

        livingRoom.setExit("east", outside);

        lab.setExit("north", outside);
        lab.setExit("east", office);

        office.setExit("west", lab);

        currentRoom = outside;
    }

    public void play() 
    {            
        printWelcome();

                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Trash!");
        System.out.println("World of Trash! is a new, incredibly exciting trash-collecting adventure game.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help, or don't know what to write.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        if(commandWord == CommandWord.UNKNOWN) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        if (commandWord == CommandWord.HELP) {
            printHelp();
        }
        else if (commandWord == CommandWord.GO) {
            goRoom(command);
        }
        else if (commandWord == CommandWord.QUIT) {
            wantToQuit = quit(command);
        }
        return wantToQuit;
    }

    private void printHelp() 
    {
        System.out.println("You are lost. There are many places to go, and lots of trash");
        System.out.println("around the house.");
        System.out.println();
        System.out.println("Your ways are:");
        parser.showCommands();
    }

    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }

    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;
        }
    }
}
