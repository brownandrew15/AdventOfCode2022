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
        int score = 0;
        for (int i=0; i < this.fileLines.length; i++) {
            String line = this.fileLines[i];
            char player = this.getShapeForOutcome(line.charAt(0), line.charAt(2));
            score += this.getScore(line.charAt(0), player);
        }
        return Integer.toString(score);
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



    /**
     * Returns the character A, B or C depending on what the player needs to play to get the outcome.
     * 
     * @param opponent the character the opponent played
     * @param outcome the outcome required
     * @return the character the player needs to get the outcome
     */
    private char getShapeForOutcome(char opponent, char outcome) {
        int opponentScore = this.unencrpyt(opponent);
        if (outcome == 'Z') {
            // player win
            return this.encryptForPlayer((opponentScore + 1) % 3);
        } else if (outcome == 'X') {
            // player loss
            return this.encryptForPlayer((opponentScore - 1) % 3);
        }

        // draw
        return this.encryptForPlayer(opponentScore); // need to play the same shape to draw
    }

    /**
     * Encrypts the player shape score into the corresponding character.
     * 
     * @param value the score (0 for rock, 1 for paper and 2 for scissors)
     * @return the character for the shape (X for rock, Y for paper and Z for scissors)
     */
    private char encryptForPlayer(int value) {
        if (value == 0) {
            return 'X';
        } else if (value == 1) {
            return 'Y';
        } else {
            return 'Z';
        }
    }

}
