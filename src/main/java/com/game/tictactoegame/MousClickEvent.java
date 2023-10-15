package com.game.tictactoegame;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.util.Timer;
import java.util.TimerTask;

public class MousClickEvent {
    public static void onClick(Text text, TicTacToe ttt, GridPane gp, GridPane gametablegp) {
        int textx = GridPane.getRowIndex(text);
        int texty = GridPane.getColumnIndex(text);
        boolean stop1 = (ttt.getField(textx, texty) == TicTacToe.PLAYER_X || ttt.getField(textx, texty) == TicTacToe.PLAYER_O);
        boolean stop2 = ttt.isSomeoneWinning();
        if (!stop1 && !stop2) {
            if (TicTacToe.onMove == TicTacToe.PLAYER_X) {
                text.setText(" X ");
                ttt.setGametable(textx, texty, TicTacToe.PLAYER_X);
                TicTacToe.onMove = TicTacToe.PLAYER_O;
            } else if (TicTacToe.onMove == TicTacToe.PLAYER_O) {
                text.setText(" O ");
                ttt.setGametable(textx, texty, TicTacToe.PLAYER_O);
                TicTacToe.onMove = TicTacToe.PLAYER_X;
            }
        }
        if (ttt.isSomeoneWinning()) {
            ttt.displayWin();
            //Timer timer = new Timer();
            //reset(gametablegp, ttt);
        }
    }

    private static void reset(GridPane gametablegp, TicTacToe ttt) {
        ttt.setGametable(new int[ttt.xlength][ttt.ylength]);
        ttt.displayGametable(gametablegp);
    }
}
