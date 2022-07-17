package org.lhoffjann.bowling;
import java.util.ArrayList;
public class Frame {
    public ArrayList<Roll> rolls;

    public Frame() {
        this.rolls = new ArrayList<Roll>();
    }

    public int getScoreOfRoll(int roll){
        return rolls.get(roll).score;
    }
    public void roll(int PinsDown){
        this.rolls.add(new Roll(PinsDown));
    }
    public int getScore(){
        int scoreOfThisFrame = 0;
        for(int i = 0; i < this.rolls.size(); i ++){
            scoreOfThisFrame += this.rolls.get(i).score;
        }
        return scoreOfThisFrame;
    }

}
