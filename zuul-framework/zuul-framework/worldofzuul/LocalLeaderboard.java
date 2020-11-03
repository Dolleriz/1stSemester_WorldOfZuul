package worldofzuul;

import java.io.File;
import java.io.PrintWriter;

public class LocalLeaderboard {
    PlayerScore playerscore = new PlayerScore(0);
    int[] leaderboard;

    public LocalLeaderboard() {
        leaderboard = new int[]{playerscore.getPlayerScore()};


    }

    public void createFile() {
        File leaderboardFile = new File("C:\\Users\\cyber\\Desktop\\Semesterprojekt World of Zuul\\SemesterProjekt-MoneyBankz\\zuul-framework\\leaderboard.txt");
        try {
            leaderboardFile.createNewFile();
        } catch (java.io.IOException e) {
            System.out.println("An error has occured");

        }

    }

    public void updateFile(String filename){
        try {
            File file = new File(filename);
            PrintWriter out = new PrintWriter(file);
            for (int i = 0; i <= leaderboard.length; i++) {
                if (leaderboard[i] < playerscore.getPlayerScore()) {
                    out.println(playerscore);
                }
            }
        }
        catch(java.io.FileNotFoundException e){
            System.out.println("File doesn't exist");
        }



}

    public static void main(String[] args) {
        LocalLeaderboard leaderboard = new LocalLeaderboard();
        leaderboard.createFile();
        leaderboard.updateFile(leaderboard);
    }
}
