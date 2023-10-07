package com.game.tictactoegame;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
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
        init();
    }
    public TicTacToe(int x, int y) {
        gametable = new int[x][y];
        xlength = x;
        ylength = y;
        init();
    }
    private void init() {
        for (int x = 0; x < xlength; x++) {
            for (int y = 0; y < ylength; y++) {
                if (gametable[x][y] != PLAYER_O || gametable[x][y] != PLAYER_X) {
                    gametable[x][y] = NO_PLAYER;
                }
            }
        }
    }
    public int[][] getGametable() {
        return this.gametable;
    }

    public void setGametable(int[][] gametable) {
        this.gametable = gametable;
    }

    public void setGametable(int x, int y, int value) {
        gametable[x][y] = value;
    }

    public void displayGametable(GridPane gridPane) {
        for (int x = 0; x < xlength; x++) {
            for(int y = 0; y < ylength; y++) {
                Text t = new Text();
                String i;
                if (gametable[x][y] == TicTacToe.PLAYER_X) {
                    i = " X ";
                } else if (gametable[x][y] == TicTacToe.PLAYER_O) {
                    i = " O ";
                } else {
                    i = " -  ";
                }
                t.setText(i);
                t.setId(x + "," + y);
                t.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
                    EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent e) {
                            System.out.println("click");
                        }
                    };
                });
                gridPane.add(t, x, y);
            }
        }
    }

    public int isWin() {
        int returnvar = NO_PLAYER;
        int ix = 0;
        int io = 0;
        for (int x = 0; x < xlength; x++) {
            for (int y = 0; y < ylength; y++) {
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
        for (int y = 0; y < xlength; y++) {
            for (int x = 0; x < ylength; x++) {
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


        for (int x = 0; x < xlength; x++) {
            int i = x;
            for (int y = 0; y < ylength; y++) {
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
                i++;
                if (i >= xlength) {
                    i = 0;
                    ix = 0;
                    io = 0;
                }
            }
            ix = 0;
            io = 0;
        }
        for (int y = 0; y < xlength; y++) {
            int i = y;
            for (int x = 0; x < ylength; x++) {
                if (gametable[x][i] == PLAYER_X) {
                    ix++;
                    io = 0;
                } else if (gametable[x][i] == PLAYER_O) {
                    io++;
                    ix = 0;
                } else {
                    ix = 0;
                    io = 0;
                }
                if (ix == wincause) returnvar = PLAYER_X;
                if (io == wincause) returnvar = PLAYER_O;
                i--;
                if (i < 0) {
                    i = 0;
                    ix = 0;
                    io = 0;
                }
            }
            ix = 0;
            io = 0;
        }
        return returnvar;
    }
}
