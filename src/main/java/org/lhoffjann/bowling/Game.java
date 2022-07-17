package org.lhoffjann.bowling;

import java.util.ArrayList;

public class Game {
    // Maybe replaces this with a linked list?
    public ArrayList<Frame> frames;

    public Game() {
        this.frames = new ArrayList<Frame>();
    }

    public void roll(int... PinsDown) {
        int numberOfFrames = 10;
        int cursor = 0;

        for(int i = 0; i < numberOfFrames; i++) {
           Frame frame = new Frame();
           frame.roll(PinsDown[cursor]);
           frame.roll(PinsDown[cursor+1]);
           frames.add(frame);
           cursor += 2;
        }
    }
    public int getScore() {
        int score = 0;
        for (int i = 0; i < frames.size(); i++) {
            ArrayList<Roll> rollsOfCurrentFrame = frames.get(i).rolls;
            ArrayList<Roll> rollsOfNextFrame = new ArrayList<Roll>();
            if (i != frames.size()-1){rollsOfNextFrame = frames.get(i+1).rolls;}
            int scoreOfCurrentFrame = frames.get(i).getScore();
            if (scoreOfCurrentFrame == 10){
                score += scoreOfCurrentFrame + rollsOfNextFrame.get(0).score;
            }else {
                score += scoreOfCurrentFrame;
            }
        }
        return score;
    }
}

