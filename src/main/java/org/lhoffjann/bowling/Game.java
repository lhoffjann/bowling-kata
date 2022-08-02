package org.lhoffjann.bowling;

import java.util.ArrayList;

public class Game {
    public ArrayList<Frame> frames;
    public final int numberOfFrames;
    public Game() {
        this.frames = new ArrayList<>();
        this.numberOfFrames = 10;
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
            if (i < numberOfFrames - 1){
                nextFrame = frames.get(i + 1);
            }
            // setting nextnextFrame and making sure it isnt outofRange
            if(i < numberOfFrames - 2){
                nextNextFrame = frames.get(i + 2);
            }

            score += calculateScoreOfSingleFrame(i, currentFrame,nextFrame,nextNextFrame);
        }
        return score;

}
    public int calculateScoreOfSingleFrame(int postionOfFrame, Frame currentFrame, Frame nextFrame, Frame nextNextFrame){

        if(postionOfFrame == numberOfFrames - 1) {
            return currentFrame.getScore();

            // Edgecase of the frame before last frame is a strike
        }else if(postionOfFrame == numberOfFrames- 2 & currentFrame.isStrike()){
            return currentFrame.getScore() + nextFrame.getScoreOfRoll(0) + nextFrame.getScoreOfRoll(1);

        } else if (currentFrame.isStrike() & nextFrame.isStrike()){
            return currentFrame.getScore() + nextFrame.getScore() + nextNextFrame.getScoreOfRoll(0);

        } else if (currentFrame.isStrike()) {
            return currentFrame.getScore() + nextFrame.getScore();

        } else if (currentFrame.isSpare()){
            return currentFrame.getScore() + nextFrame.getScoreOfRoll(0);

            // normal frame
        }else {
            return currentFrame.getScore();
        }
    }
}


