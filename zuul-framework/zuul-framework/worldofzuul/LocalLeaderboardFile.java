package worldofzuul;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LocalLeaderboardFile {

    public LocalLeaderboardFile(Game game) {
    }

    public void createFile() throws IOException {
        File leaderboardFile = new File("Leaderboard.txt");

        try {
            if (!leaderboardFile.createNewFile()) {
                overwriteFile(leaderboardFile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void overwriteFile(File leaderboardFile) throws IOException {
        FileWriter leaderboardWriter = null;

        leaderboardWriter = new FileWriter("Leaderboard.txt");


    }
}

