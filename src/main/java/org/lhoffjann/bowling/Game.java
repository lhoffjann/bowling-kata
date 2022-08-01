package org.lhoffjann.bowling;

import java.util.ArrayList;

public class Game {
    public ArrayList<Frame> frames;

    public Game() {
        this.frames = new ArrayList<Frame>();
    }

    public void roll(int... PinsDown) {
        int numberOfFrames = 10;
        int cursor = 0;
        for(int i = 0; i < numberOfFrames; i++) {
            Frame frame = new Frame();
            if (i == numberOfFrames-1 & cursor == PinsDown.length - 3) {
                // last frame with 3 rolls
                frame.addRoll(PinsDown[cursor]);
                frame.addRoll(PinsDown[cursor+ 1]);
                frame.addRoll(PinsDown[cursor+ 2]);
            } else if (PinsDown[cursor] == 10) {
                //strike
                frame.addRoll(PinsDown[cursor]);
                cursor += 1;
            } else {
                //regular two-roll frame
               frame.addRoll(PinsDown[cursor]);
               frame.addRoll(PinsDown[cursor+1]);
               cursor += 2;
           }
           frames.add(frame);

        }
    }
    public int getScore() {
        int score = 0;
        Frame currentFrame;
        Frame nextFrame = new Frame();
        Frame nextNextFrame = new Frame();

        for (int i = 0; i < frames.size(); i++) {
            currentFrame = frames.get(i);
            // setting nextFrame and making sure it isnt outofRange
            if (i < frames.size() - 1){
                nextFrame = frames.get(i + 1);
            }
            // setting nextnextFrame and making sure it isnt outofRange
            if(i < frames.size() - 2){

                nextNextFrame = frames.get(i + 2);
            }
            // adding last throw to the score
            if(i == frames.size() - 1) {

                score += currentFrame.getScore();

            // Edgecase of the frame before last frame is a strike
            }else if(i == frames.size() - 2 & currentFrame.isStrike()){

                score += currentFrame.getScore() + nextFrame.getScoreOfRoll(0) + nextFrame.getScoreOfRoll(1);
            } else if (currentFrame.isStrike() & nextFrame.isStrike()){

                score += currentFrame.getScore() + nextFrame.getScore() + nextNextFrame.getScoreOfRoll(0);

            } else if (currentFrame.isStrike()) {

                score += currentFrame.getScore() + nextFrame.getScore();

            } else if (currentFrame.isSpare()){
                score += currentFrame.getScore() + nextFrame.getScoreOfRoll(0);
            // normal frame
            }else {
                score += currentFrame.getScore();
            }
        }
        return score;
    }
}

