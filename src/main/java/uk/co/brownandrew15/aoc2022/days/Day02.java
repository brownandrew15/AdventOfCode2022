package uk.co.brownandrew15.aoc2022.days;

import uk.co.brownandrew15.aoc2022.Day;

/**
 * Class for Day 2.
 */
public class Day02 extends Day {
    
    public int getDayNumber() {
        return 2;
    }

    public String solvePartOne() {
        int score = 0;
        for (int i=0; i < this.fileLines.length; i++) {
            String line = this.fileLines[i];
            score += this.getScore(line.charAt(0), line.charAt(2));
        }
        return Integer.toString(score);
    }

    public String solvePartTwo() {
        return "";
    }

    /**
     * Returns the score for one round.
     * 
     * @param opponent the character that the opponent used
     * @param player the characger that the player used
     * @return the score for the round
     */
    private int getScore(char opponent, char player) {
        // get the inital score based on the player shape
        int score = player - 'X' + 1;
        return score + this.getOutcomeScore(opponent, player);
    }

    /**
     * Returns the score for the outcome.
     * A win returns 6, a draw returns 3 and a loss returns 0.
     * 
     * @param opponent the character that the opponent played
     * @param player the character that the player played
     * @return the outcome score
     */
    private int getOutcomeScore(char opponent, char player) {
        // Rock  ==Beats==> Paper ==Beats==> Scissors ==Beats==> Rock
        // X/A   ==Beats==> Y/B   ==Beats==> Z/C      ==Beats==> X/A

        int opponentScore = this.unencrpyt(opponent);
        int playerScore = this.unencrpyt(player);

        if ((opponentScore - playerScore == -1) || 
                ((playerScore == 0) && (opponentScore == 2))) {
            // player win
            return 6;
        } else if ((opponentScore - playerScore == 1) ||
                ((playerScore == 2) && (opponentScore == 0))) {
            // player loss
            return 0;
        }

        // draw 
        return 3;
    }

    /**
     * A consecutive score based on what the character unencrypts to.
     * A rock returns 0, paper is 1 and scissors are 2.
     * 
     * @param encrypted the encrypted character
     * @return the integer value
     */
    private int unencrpyt(char encrypted) {
        if ((encrypted == 'A') || (encrypted == 'X')) {
            return 0;
        } else if ((encrypted == 'B') || (encrypted == 'Y')) {
            return 1;
        } else { // C or Z
            return 2;
        }
    }

}
