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
           if (PinsDown[cursor] == 10){
               frame.roll(PinsDown[cursor]);
               cursor += 1;
           } else {
               frame.roll(PinsDown[cursor]);
               frame.roll(PinsDown[cursor+1]);
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

            if (i < frames.size()-1){
                nextFrame = frames.get(i+1);
            }
            if(i < frames.size() - 2){
                nextNextFrame = frames.get(i+2);
            }

            if (currentFrame.isStrike() & nextFrame.isStrike()){
                score += currentFrame.getScore() + nextFrame.getScore() + nextNextFrame.getScoreOfRoll(0);
            } else if (currentFrame.isStrike()) {
                score += currentFrame.getScore() + nextFrame.getScore();
            } else if (currentFrame.isSpare()){
                score += currentFrame.getScore() + nextFrame.getScoreOfRoll(0);
            }else {
                score += currentFrame.getScore();
            }
        }
        return score;
    }
}

