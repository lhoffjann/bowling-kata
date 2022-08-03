package org.lhoffjann.bowling;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameTest {
    Game game;
    @BeforeEach
    void setUp(){
        game = new Game();
    }
    @Test
    void rollOnlyZeros(){
        game.addRoll(0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0);
        assertEquals(game.getScore(), 0);
    }
    @Test
    void rollOnlyOnes(){
        game.addRoll(1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1);
        assertEquals(game.getScore(), 20);
    }
    @Test
    void rollASpareAndAOneAndRestZeros(){
        game.addRoll(7,3 , 1,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0);
        assertEquals(game.getScore(), 12);
    }

    @Test
    void rollAStrikeAndTwoThreesAndRestZeros(){
        game.addRoll(10, 3,3, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0);
        assertEquals(game.getScore(), 22);
    }
    @Test
    void perfectGame(){
        game.addRoll(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10);
        assertEquals(game.getScore(), 300);
    }
    @Test
    void rollASpareAndAOneAndRestZerosOnLastFrame(){
        game.addRoll(0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 3,7,1);
        assertEquals(game.getScore(), 11);
    }
    @Test
    void lastFrameAllStrikes(){
        game.addRoll(0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 10,10,10);
        assertEquals(game.getScore(), 30);
    }
    @Test
    void secondLastIsStrikeAndLastFrameAllStrikes(){
        game.addRoll(0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 10, 10,10,10);
        assertEquals(game.getScore(), 60);
    }
    @Test
    void tenPairsOfNineAndMiss() {
        game.addRoll(9, 0, 9, 0, 9, 0, 9, 0, 9, 0, 9, 0, 9, 0, 9, 0, 9, 0, 9, 0);
        assertEquals(game.getScore(), 90);
    }

    @Test
    void tenPairsOfFiveAndSpareWithFinalFive() {
        game.addRoll(5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5);
        assertEquals(game.getScore(), 150);
    }

}
