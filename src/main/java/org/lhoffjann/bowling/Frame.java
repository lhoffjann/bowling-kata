package org.lhoffjann.bowling;

import java.util.ArrayList;
public class Frame {
    public ArrayList<Roll> rolls;

    public Frame() {
        this.rolls = new ArrayList<Roll>();
    }

    public int getScoreOfRoll(int roll){
        return rolls.get(roll).getScore();
    }
    public void roll(int PinsDown){
        this.rolls.add(new Roll(PinsDown));
    }
    public int getScore(){
        int scoreOfThisFrame = 0;
        for(int i = 0; i < this.rolls.size(); i ++){
            scoreOfThisFrame += this.rolls.get(i).getScore();
        }
        return scoreOfThisFrame;
    }

    public boolean isStrike(){
        if (rolls.get(0).getScore() == 10) {
            return true;

        }else {
            return false;
        }
    }
    public boolean isSpare(){
        if (this.getScore() == 10 & !this.isStrike()){
            return true;
        }else {
            return false;
        }
    }
}
