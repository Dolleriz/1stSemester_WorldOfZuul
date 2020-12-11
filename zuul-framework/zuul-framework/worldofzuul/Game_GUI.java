package worldofzuul;


//GUI version of our game code
public class Game_GUI {

    public static final Game_GUI INSTANCE = new Game_GUI();

    Room currentRoom;
    TrashCanRoom garbageArea;
    RegularRoom outside, entrance, livingRoom, kitchen, bedRoom, bathRoom, parentsRoom;
    PlayerScore playerScore = new PlayerScore(0);
    Inventory playerInventory = new Inventory();

    public Game_GUI() {
        createRooms();
    }
    //Creates our rooms and fills them with trash
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

        garbageArea = new TrashCanRoom();

        currentRoom = outside;
    }
}
