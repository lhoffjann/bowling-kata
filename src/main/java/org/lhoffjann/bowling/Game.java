package org.lhoffjann.bowling;

public class Game {
    public final int TOTAL_NUMBER_OF_FRAMES = 10;
    public Frame[] framesOfGame;

    public Game(){
        framesOfGame = new Frame[TOTAL_NUMBER_OF_FRAMES];
        for(int i = 1; i <= TOTAL_NUMBER_OF_FRAMES; i++){
        if (i < TOTAL_NUMBER_OF_FRAMES){
            framesOfGame[i] = new Frame();

        } else if (i == TOTAL_NUMBER_OF_FRAMES) {
            // needs to be a different frame because it is the final frame
            framesOfGame[i] = new FinalFrame();

        }
        }


    }
}
