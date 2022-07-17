package org.lhoffjann.bowling;
import java.util.ArrayList;
public class Frame {
    public ArrayList<Roll> rollsOfFrame;
    public int score;
    public boolean isDuplicated;

    public Frame(){
        this.rollsOfFrame = new ArrayList<Roll>();
    }
    public void makeARoll(int score){
     if (this.rollsOfFrame.isEmpty()){
         rollsOfFrame.add(new Roll(score));
     } else if (!this.rollsOfFrame.isEmpty()) {
         if(this.rollsOfFrame.size() == 1){
             rollsOfFrame.add(new Roll(1));
         }
     }
    }

}
