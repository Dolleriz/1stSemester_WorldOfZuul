package worldofzuul;

public class PlayerScore {
        int playerScore;

    public int getPlayerScore() {
        return playerScore;
    }

    public PlayerScore (int score){
            playerScore = score;
        }


        public void increasePlayerScore(int increasePlayerScore){
            playerScore = playerScore+increasePlayerScore;
        }

    public void showPlayerScore() {
        System.out.println("Du har nu " + playerScore + " point!");
    }

    public void decreasePlayerScore(int decreasePlayerScore){
            if (playerScore < 0) {
                playerScore = 0;
            }
            else {
                playerScore= playerScore-decreasePlayerScore;
            }


        }
    }
