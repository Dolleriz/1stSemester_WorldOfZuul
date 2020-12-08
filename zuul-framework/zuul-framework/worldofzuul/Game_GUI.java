package worldofzuul;

public class Game_GUI {

    public static final Game_GUI INSTANCE = new Game_GUI();

    Room currentRoom;
    TrashCanRoom garbageArea;
    RegularRoom outside, entrance, livingRoom, kitchen, bedRoom, bathRoom, parentsRoom;
    PlayerScore playerScore = new PlayerScore(0);
    Inventory playerInventory = new Inventory(5);

    public Game_GUI() {
        createRooms();

    }

    void createRooms() {
        outside = new RegularRoom();
        outside.fillUpRoomGUI();

        entrance = new RegularRoom();
        entrance.fillUpRoomGUI();

        livingRoom = new RegularRoom();
        livingRoom.fillUpRoomGUI();

        kitchen = new RegularRoom();
        kitchen.fillUpRoomGUI();

        bedRoom = new RegularRoom();
        bedRoom.fillUpRoomGUI();

        bathRoom = new RegularRoom();
        bathRoom.fillUpRoomGUI();

        parentsRoom = new RegularRoom();
        parentsRoom.fillUpRoomGUI();

        garbageArea = new TrashCanRoom("ved skraldespandene, Foran dig er der et sæt skraldespande." +
                "\nHver skraldespand har et nummer:" +
                "\n1. Plastik.\n2. Metal og glas.\n3. Madaffald.\n4. Papir og pap.\n5. Restaffald." +
                "\nDu burde nu have en masse affald i din taske, som skal sorteres. Ellers, kom i gang!");

        currentRoom = outside;
    }
}
