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
        game.roll(0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0);
        assertEquals(game.getScore(), 0);
    }
    @Test
    void rollOnlyOnes(){
        game.roll(1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1);
        assertEquals(game.getScore(), 20);
    }
    @Test
    void rollASpareAndAOneAndRestZeros(){
        game.roll(7,3 , 1,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0);
        assertEquals(game.getScore(), 12);
    }

    @Test
    void rollAStrikeAndTwoThreesAndRestZeros(){
        game.roll(10, 3,3, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0);
        assertEquals(game.getScore(), 22);
    }
}