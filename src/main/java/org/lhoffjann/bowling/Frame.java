package org.lhoffjann.bowling;

import java.util.ArrayList;

public class Frame {
    public final ArrayList<Roll> rolls;

    public Frame() {
        this.rolls = new ArrayList<>();
    }

    public int getScoreOfRoll(int roll) {
        return rolls.get(roll).score();
    }

    public void addRoll(int PinsDown){
        rolls.add(new Roll(PinsDown));
    }

    public int getScore() {
        int scoreOfThisFrame = 0;
        for(Roll roll : rolls){
            scoreOfThisFrame += roll.score();
        }
        return scoreOfThisFrame;
    }

    public boolean isStrike() {
        return !rolls.isEmpty() && rolls.get(0).score() == 10;
    }

    public boolean isSpare() {
        return this.getScore() == 10 && !this.isStrike();
    }
}