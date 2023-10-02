package com.game.tictactoegame;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
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
        ticTacToe.setGametable(0, 0, TicTacToe.PLAYER_X);
        ticTacToe.setGametable(0, 1, TicTacToe.PLAYER_X);
        ticTacToe.setGametable(0, 2, TicTacToe.PLAYER_X);

        GridPane tictactoegrid = new GridPane();
        tictactoegrid.setGridLinesVisible(true);
        tictactoegrid.setCursor(Cursor.CROSSHAIR);
        tictactoegrid.setScaleX(3);
        tictactoegrid.setScaleY(3);
        tictactoegrid.setPadding(new Insets(100, 100, 100, 100));
        ticTacToe.displayGametable(tictactoegrid);
        gametable.getChildren().add(tictactoegrid);

        Text t = new Text();
        GridPane label = new GridPane();

        if (ticTacToe.isWin() == TicTacToe.PLAYER_X) {
            t.setText("Player X");
        } else if (ticTacToe.isWin() == TicTacToe.PLAYER_O) {
            t.setText("Player O");
        } else {
            t.setText("No Player");
        }
        label.add(t, 0, 0);
        gametable.getChildren().add(label);
    }
}