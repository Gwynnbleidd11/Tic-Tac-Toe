package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeTestSuite {

    @Nested
    @DisplayName("Checking winning conditions for player O")
    class checkingPlayerOWinningConditions {

        @Test
        void testCheckingPlayerOWinningInRows() {
            //Given
            GameMechanicsAndLogic gmal = new GameMechanicsAndLogic();
            char[][] row1 = new char[3][3];
            char[][] row2 = new char[3][3];
            char[][] row3 = new char[3][3];
            char[][] row4 = new char[3][3];
            char[][] row5 = new char[3][3];
            row1[0][0] = 'O'; row1[0][1] = 'O'; row1[0][2] = 'O';
            row2[0][0] = 'O'; row2[0][1] = 'O'; row2[0][2] = 'O';
            row3[0][0] = 'O'; row3[0][1] = 'O'; row3[0][2] = 'O';
            row4[0][0] = 'O'; row4[0][1] = 'X'; row4[0][2] = 'O';
            row5[0][0] = 'X'; row5[0][1] = 'O'; row5[0][2] = 'X';

            //When
            boolean check1 = gmal.isItWin(row1, 'O');
            boolean check2 = gmal.isItWin(row2, 'O');
            boolean check3 = gmal.isItWin(row3, 'O');
            boolean check4 = gmal.isItWin(row4, 'O');
            boolean check5 = gmal.isItWin(row5, 'O');

            //Then
            assertTrue(check1);
            assertTrue(check2);
            assertTrue(check3);
            assertFalse(check4);
            assertFalse(check5);
        }

        @Test
        void testCheckingPlayerOWinningInColumns() {
            //Given
            GameMechanicsAndLogic gmal = new GameMechanicsAndLogic();
            char[][] col1 = new char[3][3];
            char[][] col2 = new char[3][3];
            char[][] col3 = new char[3][3];
            char[][] col4 = new char[3][3];
            char[][] col5 = new char[3][3];
            col1[0][0] = 'O'; col1[1][0] = 'O'; col1[2][0] = 'O';
            col2[0][1] = 'O'; col2[1][1] = 'O'; col2[2][1] = 'O';
            col3[0][2] = 'O'; col3[1][2] = 'O'; col3[2][2] = 'O';
            col4[0][2] = 'X'; col4[1][2] = 'O'; col4[2][2] = 'O';
            col5[0][2] = 'O'; col5[1][2] = 'X'; col5[2][2] = 'X';

            //When
            boolean check1 = gmal.isItWin(col1, 'O');
            boolean check2 = gmal.isItWin(col2, 'O');
            boolean check3 = gmal.isItWin(col3, 'O');
            boolean check4 = gmal.isItWin(col4, 'O');
            boolean check5 = gmal.isItWin(col5, 'O');

            //Then
            assertTrue(check1);
            assertTrue(check2);
            assertTrue(check3);
            assertFalse(check4);
            assertFalse(check5);
        }

        @Test
        void testCheckingPlayerOWinningDiagonally() {
            //Given
            GameMechanicsAndLogic gmal = new GameMechanicsAndLogic();
            char[][] dial1 = new char[3][3];
            char[][] dial2 = new char[3][3];
            char[][] dial3 = new char[3][3];
            char[][] dial4 = new char[3][3];
            dial1[0][0] = 'O'; dial1[1][1] = 'O'; dial1[2][2] = 'O';
            dial2[0][2] = 'O'; dial2[1][1] = 'O'; dial2[2][0] = 'O';
            dial3[0][2] = 'X'; dial3[1][1] = 'O'; dial3[2][0] = 'O';
            dial4[0][2] = 'O'; dial4[1][1] = 'X'; dial4[2][0] = 'O';

            //When
            boolean check1 = gmal.isItWin(dial1, 'O');
            boolean check2 = gmal.isItWin(dial2, 'O');
            boolean check3 = gmal.isItWin(dial3, 'O');
            boolean check4 = gmal.isItWin(dial4, 'O');

            //Then
            assertTrue(check1);
            assertTrue(check2);
            assertFalse(check3);
            assertFalse(check4);
        }
    }

    @Nested
    @DisplayName("Checking winning conditions for player X")
    class checkingPlayerXWinningConditions {

        @Test
        void testCheckingPlayerXWinningInRows() {
            //Given
            GameMechanicsAndLogic gmal = new GameMechanicsAndLogic();
            char[][] row1 = new char[3][3];
            char[][] row2 = new char[3][3];
            char[][] row3 = new char[3][3];
            char[][] row4 = new char[3][3];
            char[][] row5 = new char[3][3];
            row1[0][0] = 'X'; row1[0][1] = 'X'; row1[0][2] = 'X';
            row2[0][0] = 'X'; row2[0][1] = 'X'; row2[0][2] = 'X';
            row3[0][0] = 'X'; row3[0][1] = 'X'; row3[0][2] = 'X';
            row4[0][0] = 'O'; row4[0][1] = 'O'; row4[0][2] = 'X';
            row5[0][0] = 'X'; row5[0][1] = 'O'; row5[0][2] = 'X';

            //When
            boolean check1 = gmal.isItWin(row1, 'X');
            boolean check2 = gmal.isItWin(row2, 'X');
            boolean check3 = gmal.isItWin(row3, 'X');
            boolean check4 = gmal.isItWin(row4, 'X');
            boolean check5 = gmal.isItWin(row5, 'X');

            //Then
            assertTrue(check1);
            assertTrue(check2);
            assertTrue(check3);
            assertFalse(check4);
            assertFalse(check5);
        }

        @Test
        void testCheckingPlayerXWinningInColumns() {
            //Given
            GameMechanicsAndLogic gmal = new GameMechanicsAndLogic();
            char[][] col1 = new char[3][3];
            char[][] col2 = new char[3][3];
            char[][] col3 = new char[3][3];
            char[][] col4 = new char[3][3];
            char[][] col5 = new char[3][3];
            col1[0][0] = 'X'; col1[1][0] = 'X'; col1[2][0] = 'X';
            col2[0][1] = 'X'; col2[1][1] = 'X'; col2[2][1] = 'X';
            col3[0][2] = 'X'; col3[1][2] = 'X'; col3[2][2] = 'X';
            col4[0][2] = 'X'; col4[1][2] = 'O'; col4[2][2] = 'O';
            col5[0][2] = 'O'; col5[1][2] = 'X'; col5[2][2] = 'O';

            //When
            boolean check1 = gmal.isItWin(col1, 'X');
            boolean check2 = gmal.isItWin(col2, 'X');
            boolean check3 = gmal.isItWin(col3, 'X');
            boolean check4 = gmal.isItWin(col4, 'X');
            boolean check5 = gmal.isItWin(col5, 'X');

            //Then
            assertTrue(check1);
            assertTrue(check2);
            assertTrue(check3);
            assertFalse(check4);
            assertFalse(check5);
        }

        @Test
        void testCheckingPlayerXWinningDiagonally() {
            //Given
            GameMechanicsAndLogic gmal = new GameMechanicsAndLogic();
            char[][] dial1 = new char[3][3];
            char[][] dial2 = new char[3][3];
            char[][] dial3 = new char[3][3];
            char[][] dial4 = new char[3][3];
            dial1[0][0] = 'X'; dial1[1][1] = 'X'; dial1[2][2] = 'X';
            dial2[0][2] = 'X'; dial2[1][1] = 'X'; dial2[2][0] = 'X';
            dial3[0][2] = 'X'; dial3[1][1] = 'O'; dial3[2][0] = 'X';
            dial4[0][2] = 'O'; dial4[1][1] = 'O'; dial4[2][0] = 'O';

            //When
            boolean check1 = gmal.isItWin(dial1, 'X');
            boolean check2 = gmal.isItWin(dial2, 'X');
            boolean check3 = gmal.isItWin(dial3, 'X');
            boolean check4 = gmal.isItWin(dial4, 'X');

            //Then
            assertTrue(check1);
            assertTrue(check2);
            assertFalse(check3);
            assertFalse(check4);
        }
    }

    @Test
    void testCheckingDrawMethod() {
        //Given
        GameMechanicsAndLogic gmal = new GameMechanicsAndLogic();
        char[][] draw1 = new char[3][3];                            // should return false
        draw1[0][0] = 'X'; draw1[1][0] = ' '; draw1[2][0] = 'O';
        draw1[0][1] = ' '; draw1[1][1] = 'X'; draw1[2][1] = ' ';
        draw1[0][2] = 'O'; draw1[1][2] = ' '; draw1[2][2] = 'X';

        char[][] draw2 = new char[3][3];                            //should return truth
        draw2[0][0] = 'x'; draw2[1][0] = 'X'; draw2[2][0] = 'O';
        draw2[0][1] = 'O'; draw2[1][1] = 'O'; draw2[2][1] = 'X';
        draw2[0][2] = 'X'; draw2[1][2] = 'O'; draw2[2][2] = 'X';

        char[][] draw3 = new char[3][3];                            //should return false
        draw3[0][0] = ' '; draw3[1][0] = ' '; draw3[2][0] = ' ';
        draw3[0][1] = ' '; draw3[1][1] = ' '; draw3[2][1] = ' ';
        draw3[0][2] = ' '; draw3[1][2] = ' '; draw3[2][2] = ' ';

        char[][] draw4 = new char[3][3];                            //should return truth
        draw4[0][0] = 'X'; draw4[1][0] = 'X'; draw4[2][0] = 'X';
        draw4[0][1] = 'X'; draw4[1][1] = 'X'; draw4[2][1] = 'X';
        draw4[0][2] = 'X'; draw4[1][2] = 'X'; draw4[2][2] = 'X';

        //When

        //Then
        assertFalse(gmal.isItDraw(draw1));
        assertTrue(gmal.isItDraw(draw2));
        assertFalse(gmal.isItDraw(draw3));
        assertTrue(gmal.isItDraw(draw4));
    }
}

