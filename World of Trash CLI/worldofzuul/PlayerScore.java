package worldofzuul;

/**
 * The type Player score.
 */
public class PlayerScore {
    /**
     * The Player score.
     */
    int playerScore;

    /**
     * Gets player score.
     *
     * @return the player score
     */
    public int getPlayerScore() {
        return playerScore;
    }

    /**
     * Instantiates a new Player score.
     *
     * @param score the score
     */
    public PlayerScore (int score){
            playerScore = score;
        }


    /**
     * Increase player score.
     *
     * @param increasePlayerScore the increase player score
     */
    public void increasePlayerScore(int increasePlayerScore){
            playerScore = playerScore+increasePlayerScore;
        }

    /**
     * Show player score.
     */
    public void showPlayerScore() {
        System.out.println("Du har nu " + playerScore + " point!");
    }

    /**
     * Decrease player score.
     *
     * @param decreasePlayerScore the decrease player score
     */
    public void decreasePlayerScore(int decreasePlayerScore){
            if (playerScore < 0) {
                playerScore = 0;
            }
            else {
                playerScore= playerScore-decreasePlayerScore;
            }


        }
    }
