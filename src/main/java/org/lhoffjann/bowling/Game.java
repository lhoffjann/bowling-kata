package org.lhoffjann.bowling;

import java.util.ArrayList;

public class Game {
    // Maybe replaces this with a linked list?
    public ArrayList<Roll> rolls;

    public Game() {
        this.rolls = new ArrayList<Roll>();
    }

    public void roll(int... PinsDown) {
        for (int x : PinsDown) {
            this.rolls.add(new Roll(x));
        }
    }
    public int getScore() {
        int score = 0;
        for (int i = 0; i < rolls.size(); i++)
            score += rolls.get(i).score;
        return score;
    }
}
