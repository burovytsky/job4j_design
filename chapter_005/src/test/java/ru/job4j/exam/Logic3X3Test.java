package ru.job4j.exam;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class Logic3X3Test {

    @Test
    public void getMark(){
        Logic logic = new Logic3X3(3);
        Point point = new Point(1, 1);
        logic.makeMove(point, Mark.X);
        assertThat(Mark.X, is(logic.getMark(point)));
    }

    @Test
    public void isMovePossibleTrue(){
        Logic logic = new Logic3X3(3);
        Point point = new Point(1, 1);
        assertTrue(logic.isMovePossible(point));
    }

    @Test
    public void isMovePossibleFalse(){
        Logic logic = new Logic3X3(3);
        Point point = new Point(1, 3);
        assertFalse(logic.isMovePossible(point));
    }

    @Test
    public void isWinnerCheck(){
        Logic logic = new Logic3X3(3);
        Point point1 = new Point(1, 0);
        Point point2 = new Point(1, 1);
        Point point3 = new Point(1, 2);
        logic.makeMove(point1, Mark.X);
        logic.makeMove(point2, Mark.X);
        logic.makeMove(point3, Mark.X);
        assertThat(Mark.X, is(logic.checkWinner()));
    }
}