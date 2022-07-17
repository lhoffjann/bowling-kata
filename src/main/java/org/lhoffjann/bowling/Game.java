package org.lhoffjann.bowling;

public class Game {
    public final int TOTAL_NUMBER_OF_FRAMES = 10;
    // Maybe replaces this with a linked list?
    public Frame[] framesOfGame;

    public Game(){
        framesOfGame = new Frame[TOTAL_NUMBER_OF_FRAMES];
        for(int i = 0; i <= TOTAL_NUMBER_OF_FRAMES-1; i++){
        if (i < TOTAL_NUMBER_OF_FRAMES){
            framesOfGame[i] = new Frame();
            setScoresOfFrame(framesOfGame[i],0, 9 );

        } else if (i == TOTAL_NUMBER_OF_FRAMES) {
            // needs to be a different frame because it is the final frame
            framesOfGame[i] = new FinalFrame();

        }
        }


    }
    public void setScoresOfFrame(Frame frame, int roll, int score){
        frame.rollsOfFrame[roll].setScore(score);
    }
}
