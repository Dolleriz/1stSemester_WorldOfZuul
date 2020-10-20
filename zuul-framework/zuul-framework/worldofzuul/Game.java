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
        Room outside, garbageArea, entrance, livingRoom, kitchen, bedRoom, bathroom, parentsRoom;
      
        outside = new Room("outside. " +
                "\nto the east is your house, filled with trash that needs to be collected. " +
                "\nTo the north is the garbage area.");
        garbageArea = new Room(" in the garbage area, in front of you is a set of bins. " +
                "\nIn your inventory you should have a bunch of garbage, ready to be sorted. Otherwise, get collecting!");
        entrance = new Room("in the entrance. The walls are decorated with dull paintings and generic family photos. " +
                "\nYou are facing the table with the photos on them. Outside is to the west and the living room is to the east");
        livingRoom = new Room("in the living Room. Large carpet on the floor, Sofa together with TV in the corner. " +
                "Walls decorated with family photos. " +
                "\nTo the north is the kitchen, west is the entrance and east is the parents bedroom");
        kitchen = new Room("");
        bedRoom = new Room("");
        bathroom = new Room("");
        parentsRoom = new Room("");
        
        outside.setExit("east", entrance);
        outside.setExit("north", garbageArea);

        garbageArea.setExit("south", outside);

        entrance.setExit("west", outside);
        entrance.setExit("east", livingRoom);

        livingRoom.setExit("east", parentsRoom);
        livingRoom.setExit("north", kitchen);
        livingRoom.setExit("west", entrance);

        kitchen.setExit("west", bedRoom);
        kitchen.setExit("east", bathroom);
        kitchen.setExit("south", livingRoom);

        bedRoom.setExit("east", kitchen);

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
        System.out.println("You are lost. There are many places to go, and lots of trash around the house.");
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
