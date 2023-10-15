package com.game.tictactoegame;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
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
        launch(args);
    }

    @FXML
    private void initialize(){
        ticTacToe = new TicTacToe(gametable, new GridPane(), 3, 3);

        GridPane tictactoegrid = new GridPane();
        tictactoegrid.setGridLinesVisible(true);
        tictactoegrid.setCursor(Cursor.CROSSHAIR);
        tictactoegrid.setScaleX(3);
        tictactoegrid.setScaleY(3);
        tictactoegrid.setPadding(new Insets(100, 100, 100, 100));
        ticTacToe.displayGametable(tictactoegrid);
        gametable.getChildren().add(tictactoegrid);

        ticTacToe.displayWin();
    }
}