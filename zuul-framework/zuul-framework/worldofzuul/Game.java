package worldofzuul;

import java.util.concurrent.ThreadLocalRandom;

public class Game
{
    private Parser parser;
    private Room currentRoom;
    Inventory inventory = new Inventory();


    public Game() 
    {
        createRooms();
        createTrashCans();
        parser = new Parser();
    }

    private void createTrashCans() {
        Trashcan plastic = new Trashcan(Trashtype.PLASTIC, "Plastic. " +
                "\nThis Trashcan is for plastics");

        Trashcan metalAndGlass = new Trashcan(Trashtype.METAL_AND_GLASS, "Metal and glass. " +
                "\nThis Trashcan is for metals.");

        Trashcan organic = new Trashcan(Trashtype.ORGANIC, "Organic. " +
                "\nThis trashcan is for organic trash");

        Trashcan paper = new Trashcan(Trashtype.PAPER, "Paper and cardboard. " +
                "\nThis trashcan is for paper and cardboard");

        Trashcan residualWaste = new Trashcan(Trashtype.RESIDUAL_WASTE, "Residual waste. " +
                "\nThis trashcan is for trash that does not fit into other trashcans");
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
    }

    public void play() 
    {            
        printWelcome();

                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Tak for spillet.  Farvel.");
    }

    private void printWelcome()
    {
        System.out.println();
        System.out.println("Velkommen til En Verden af Affald!");
        System.out.println("En Verden af Affald! er et nyt spændende affaldsindsamlingsspil.");
        System.out.println("Skriv '" + CommandWord.HELP + "' hvis du har brug for hjælp, eller ikke ved hvad du kan gøre.");
        System.out.println();
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        if(commandWord == CommandWord.UNKNOWN) {
            System.out.println("Jeg forstår ikke hvad du mener...");
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
        System.out.println("Du er forvirret. Der er mange steder at gå hen, og mange ting du kan gøre.");
        System.out.println();
        System.out.println("Dine muligheder er:");
        parser.showCommands();
    }

    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            System.out.println("Gå hvorhen?");
            return;
        }

        String direction = command.getSecondWord();

        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("Der er ikke nogen dør!");
        }
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }

    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Afslut hvad?");
            return false;
        }
        else {
            return true;
        }
    }

    private void pickup(Command command)
    {
        if(!command.hasSecondWord()) {
            System.out.println("Tag hvad?");
            return;
        }


    }

    private void printInventory(Inventory inventory) {
        System.out.println("Du kan max have 5 stykker affald i dine lommer. " +
                "\nI dine lommer har du: " +
                "\n");

        for (int i = 0; i < inventory.inventory.length; i++) {
            if (inventory.inventory[i] == null) {
                System.out.println("Der er ikke noget i denne lomme!");

            } else {
                System.out.print(inventory.inventory[i] + " ");
                System.out.println(" ");
            }
        }
    }
}
