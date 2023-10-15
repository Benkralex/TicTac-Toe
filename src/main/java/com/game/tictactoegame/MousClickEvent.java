package com.game.tictactoegame;

import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class MousClickEvent {
    public static void onClick(Text text, TicTacToe ttt, GridPane gp) {
        int textx = (int) text.getX();
        int texty = (int) text.getY();
        boolean stop1 = (ttt.getField(textx, texty) == TicTacToe.PLAYER_X || ttt.getField(textx, texty) == TicTacToe.PLAYER_O);
        boolean stop2 = ttt.isSomeoneWinning();
        System.out.println(ttt.isSomeoneWinning());
        if (!stop1 && !stop2) {
            if (TicTacToe.onMove == TicTacToe.PLAYER_X) {
                text.setText(" X ");
                TicTacToe.onMove = TicTacToe.PLAYER_O;
            } else if (TicTacToe.onMove == TicTacToe.PLAYER_O) {
                text.setText(" O ");
                TicTacToe.onMove = TicTacToe.PLAYER_X;
            }
        }


        Text t = new Text();
        GridPane label = gp;

        if (ttt.isWin() == TicTacToe.PLAYER_X) {
            t.setText("Player X");
        } else if (ttt.isWin() == TicTacToe.PLAYER_O) {
            t.setText("Player O");
        } else {
            t.setText("No Player");
        }
        label.add(t, 0, 0);
    }
}
