package com.game.tictactoegame;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class TicTacToe {
    private int[][] gametable;
    private int wincause = 3;
    private int xlength;
    private int ylength;
    public static final int PLAYER_X = 1;
    public static final int PLAYER_O = 2;
    public static final int NO_PLAYER = 0;
    public static int onMove = PLAYER_X;
    public AnchorPane gametableap;
    public GridPane wingp;

    public TicTacToe(AnchorPane gametableap, GridPane wingp, int x, int y, int wincause) {
        gametable = new int[x][y];
        xlength = x;
        ylength = y;
        this.wincause = wincause;
        this.gametableap = gametableap;
        this.wingp = wingp;
        init();
    }
    public TicTacToe(AnchorPane gametableap, GridPane wingp, int x, int y) {
        gametable = new int[x][y];
        xlength = x;
        ylength = y;
        this.gametableap = gametableap;
        this.wingp = wingp;
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

    public int getField(int x, int y) {
        return gametable[x][y];
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
                    i = "   ";
                }
                t.setText(i);
                t.setId(x + "," + y);
                //t.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {MousClickEvent.onClick();});
                t.<MouseEvent>addEventFilter(MouseEvent.MOUSE_CLICKED, event -> {System.out.println("Clicked!"); MousClickEvent.onClick(t, this, wingp);});
                gridPane.add(t, x, y);
            }
        }
    }

    public void displayWin() {
        Text t = new Text();
        GridPane label = new GridPane();

        if (this.isWin() == TicTacToe.PLAYER_X) {
            t.setText("Player X");
        } else if (this.isWin() == TicTacToe.PLAYER_O) {
            t.setText("Player O");
        } else {
            t.setText("No Player");
        }
        label.add(t, 0, 0);
        gametableap.getChildren().add(label);
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

    public boolean isSomeoneWinning() {
        if (this.isWin() == PLAYER_O) {
            return true;
        } else if (this.isWin() == PLAYER_X) {
            return true;
        } else if (this.isWin() == NO_PLAYER) {
            return false;
        } else {
            return false;
        }
    }
}
