package org.lhoffjann.bowling;

public class Frame {
    public Roll[] rollsOfFrame;
    public int score;
    public boolean isDuplicated;

    public Frame(){
        rollsOfFrame = new Roll[2];
        rollsOfFrame[0] = new Roll();
        rollsOfFrame[1] = new Roll();
    }

}
