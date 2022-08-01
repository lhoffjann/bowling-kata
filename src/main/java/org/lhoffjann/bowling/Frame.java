package org.lhoffjann.bowling;

import java.util.ArrayList;

public class Frame {
    public ArrayList<Roll> rolls;

    public Frame() {
        this.rolls = new ArrayList<>();
    }

    public int getScoreOfRoll(int roll) { return rolls.get(roll).score(); }

    public void roll(int PinsDown){
        this.rolls.add(new Roll(PinsDown));
    }

    public int getScore() {
        int scoreOfThisFrame = 0;
        for(Roll roll : this.rolls){
            scoreOfThisFrame += roll.score();
        }
        return scoreOfThisFrame;
    }

    public boolean isStrike() { return rolls.get(0).score() == 10; }
    public boolean isSpare() { return this.getScore() == 10 && !this.isStrike(); }
    }