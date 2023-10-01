package com.game.tictactoegame;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @FXML
    private AnchorPane gametable;
    private TicTacToe ticTacToe;

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("gamedisplay.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        stage.setTitle("TicTac-Toe");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    @FXML
    private void initialize(){
        ticTacToe = new TicTacToe(3, 3);
        ticTacToe.setGametable(0,0,TicTacToe.PLAYER_X);
        ticTacToe.setGametable(1,1, TicTacToe.PLAYER_X);
        ticTacToe.setGametable(2, 2, TicTacToe.PLAYER_X);
        ticTacToe.setGametable(0, 1, TicTacToe.PLAYER_O);
        ticTacToe.setGametable(1, 0, TicTacToe.PLAYER_O);
        if (ticTacToe.isWin() == TicTacToe.PLAYER_X) {
            System.out.print("Player X");
        } else if (ticTacToe.isWin() == TicTacToe.PLAYER_O) {
            System.out.print("Player O");
        }

        GridPane tictactoegrid = new GridPane();
        ticTacToe.displayGametable(tictactoegrid);
        gametable.getChildren().add(tictactoegrid);
    }
}