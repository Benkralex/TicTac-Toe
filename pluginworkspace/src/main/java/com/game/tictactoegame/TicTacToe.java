package com.game.tictactoegame;

import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.util.HashMap;

public class TicTacToe {
    private int[][] gametable;
    private int wincause = 3;
    private int xlength;
    private int ylength;
    public static final int PLAYER_X = 1;
    public static final int PLAYER_O = 2;
    public static final int NO_PLAYER = 0;

    public TicTacToe(int x, int y, int wincause) {
        gametable = new int[x][y];
        xlength = x;
        ylength = y;
        this.wincause = wincause;
    }
    public TicTacToe(int x, int y) {
        gametable = new int[x][y];
        xlength = x;
        ylength = y;
    }
    public int[][] getGametable() {
        return this.gametable;
    }

    public int getGametable(int x, int y) {
        return this.gametable[x][y];
    }
    public int[] getXGametable(int x) {
        return this.gametable[x];
    }
    public int[] getYGametable(int y) {
        int[] gametablerow = new int[this.gametable[0].length];
        for (int x = 0; x < gametable.length; x++) {
            gametablerow[x] = gametable[x][y];
        }
        return gametablerow;
    }

    public void setGametable(int x, int y, int value) {
        gametable[x][y] = value;
    }
    public int isWin() {
        int returnvar = NO_PLAYER;
        int ix = 0;
        int io = 0;
        //int[][] i = new int[gametable[1].length][gametable.length];
        for (int x = 0; x < gametable.length; x++) {
            for (int y = 0; y < gametable[x].length; y++) {
               if (gametable[x][y] == PLAYER_X) {
                   ix++;
                   io = 0;
               } else if (gametable[x][y] == PLAYER_O) {
                   io++;
                   ix = 0;
               } else {
                   ix = 0;
                   io = 0;
               }
            }
            if (ix == wincause) returnvar = PLAYER_X;
            if (io == wincause) returnvar = PLAYER_O;
            ix = 0;
            io = 0;
        }
        for (int y = 0; y < gametable.length; y++) {
            for (int x = 0; x < gametable[1].length; x++) {
                if (gametable[x][y] == PLAYER_X) {
                    ix++;
                    io = 0;
                } else if (gametable[x][y] == PLAYER_O) {
                    io++;
                    ix = 0;
                } else {
                    ix = 0;
                    io = 0;
                }
                if (ix == wincause) returnvar = PLAYER_X;
                if (io == wincause) returnvar = PLAYER_O;
            }
            ix = 0;
            io = 0;
        }
        for (int x = 0; x < gametable.length; x++) {
            for (int y = 0; y < gametable[1].length; y++) {
                int i = x++;
                if (gametable[i][y] == PLAYER_X) {
                    ix++;
                    io = 0;
                } else if (gametable[i][y] == PLAYER_O) {
                    io++;
                    ix = 0;
                } else {
                    ix = 0;
                    io = 0;
                }
                if (ix == wincause) returnvar = PLAYER_X;
                if (io == wincause) returnvar = PLAYER_O;
            }
            ix = 0;
            io = 0;
        }
        return returnvar;
    }
    public void displayGametable(GridPane gridPane) {
        for (int x = 0; x < xlength; x++) {
            for(int y = 0; y < ylength; y++) {
                Text t = new Text();
                gridPane.add(t, x, y);//eventuell x und y vertauschen
            }
        }
    }
}
