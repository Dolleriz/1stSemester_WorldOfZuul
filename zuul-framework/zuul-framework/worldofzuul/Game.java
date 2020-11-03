package worldofzuul;

public class Game 
{
    private Parser parser;
    private Room currentRoom;
    Inventory inventory = new Inventory();


    public Game() 
    {
        createRooms();
        parser = new Parser();
    }

    private void createTrashCans() {
        Trashcan plastic, metal, organic, paper, residualWaste;

        plastic = new Trashcan("plastic. " +
                "\nThis Trashcan is for plastics");

        metal = new Trashcan("metal. " +
                "\nThis Trashcan is for metals.");

        organic = new Trashcan("organic. " +
                "\nThis trashcan is for organic trash");

        paper = new Trashcan("paper. " +
                "\nThis trashcan is for paper and cardboard");

        residualWaste = new Trashcan("Residual waste. " +
                "\nThis trashcan is for trash that does not fit into other trashcans");

        plastic.setTypeOfTrashcan(1);

        metal.setTypeOfTrashcan(2);

        organic.setTypeOfTrashcan(3);

        paper.setTypeOfTrashcan(4);

        residualWaste.setTypeOfTrashcan(5);
    }

    private void createTrashtypes() {
        Trashtype plastic, metalAndGlass, organic, paper, residualWaste;

        plastic = new Trashtype("plastic. " +
                "\nIt is made of oil and other organic molecules." +
                "\nThis type of trash takes a long time to decay, " +
                "\nmeaning it can lay for a long time in nature, damaging ecosystems and animals.");

        metalAndGlass = new Trashtype("Metal and glass. " +
                "\nThis type of trash is shiny, and hard. " +
                "\nIt consists of cans, aluminum foil, and is used to preserve foods or drinks.");

        organic = new Trashtype("organic. " +
                "\nThis type of trash consists of foods and other organic substances.");

        paper = new Trashtype("paper. " +
                "\nThis type of trash is usually used for pizza packaging, handtowels and other recycleable things.");

        residualWaste = new Trashtype("Residual waste. " +
                "\nThis type of trash is all the things that, does not fit into any of the four other categories.");

        plastic.setTypeOfTrash(1);

        metalAndGlass.setTypeOfTrash(2);

        organic.setTypeOfTrash(3);

        paper.setTypeOfTrash(4);

        residualWaste.setTypeOfTrash(5);
    }

    private void createRooms()
    {
        Room outside, garbageArea, entrance, livingRoom, kitchen, bedRoom, bathRoom, parentsRoom;
      
        outside = new Room("outside. " +
                "\nto the east is your house, filled with trash that needs to be collected. " +
                "\nTo the north is the garbage area.");
        garbageArea = new Room("in the garbage area, in front of you is a set of bins. " +
                "\nThey are all labeled with numbers:" +
                "\n1. Plastic.\n2. Metal.\n3. Organic waste. \n4. Paper and cardboard.\n5. Residual Waste." +
                "\nIn your inventory you should have a bunch of garbage, ready to be sorted. Otherwise, get collecting!");
        entrance = new Room("in the entrance. The walls are decorated with dull paintings and generic family photos. " +
                "\nYou are facing the wall with the photos on them. Outside is to the west and the living room is to the east");
        livingRoom = new Room("in the living Room. Large carpet on the floor, Sofa together with TV in the corner. " +
                "Walls decorated with family photos. " +
                "\nTo the north is the kitchen, west is the entrance and east is the parents bedroom");
        kitchen = new Room("in the kitchen." +
                "\nIn the middle is a very square dinner table, draped with a sorta 60s looking cloth." +
                "\nPretty much your average kitchen." +
                "\nSouth is the living room, west is your room and east is the bathroom");
        bedRoom = new Room("in your room!" +
                "\nFull of all the cool toys you know and love. There might be some trash nearby..." +
                "\nTo the east is the kitchen");
        bathRoom = new Room("in the bathroom." +
                "\n a rather small bathroom for a family." +
                "\nTo the west is the kitchen and to south is the parents bedroom");
        parentsRoom = new Room("your parents bedroom." +
                "\nTo the side is a double bed and the walls are decorated with tasteless paintings." +
                "\nEach side of the bed has a nightstand." +
                "\nTo the north is the bathroom and to the west is the living room");
        
        outside.setExit("east", entrance);
        outside.setExit("north", garbageArea);

        garbageArea.setExit("south", outside);

        entrance.setExit("west", outside);
        entrance.setExit("east", livingRoom);

        livingRoom.setExit("east", parentsRoom);
        livingRoom.setExit("north", kitchen);
        livingRoom.setExit("west", entrance);

        kitchen.setExit("west", bedRoom);
        kitchen.setExit("east", bathRoom);
        kitchen.setExit("south", livingRoom);

        bedRoom.setExit("east", kitchen);

        bathRoom.setExit("west", kitchen);
        bathRoom.setExit("south", parentsRoom);

        parentsRoom.setExit("west", livingRoom);
        parentsRoom.setExit("north", bathRoom);

        currentRoom = outside;

        if (currentRoom == garbageArea) {
            createTrashCans();
        }
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
        else if (commandWord == CommandWord.PICKUP){
            pickup(command);
        }
        else if (commandWord == CommandWord.INVENTORY){
            printInventory(inventory);
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

    private void pickup(Command command)
    {
        if(!command.hasSecondWord()) {
            System.out.println("Pickup what?");
            return;
        }


    }

    private void printInventory(Inventory inventory) {
        System.out.println("You can hold a maximum of 5 pieces of trash. " +
                "\nIn your inventory, you have: " +
                "\n");

        for (int i = 0; i < inventory.inventory.length; i++) {
            if (inventory.inventory[i] == null) {
                System.out.println("Nothing in this slot!");

            } else {
                System.out.print(inventory.inventory[i] + " ");
                System.out.println(" ");
            }
        }
    }
}
