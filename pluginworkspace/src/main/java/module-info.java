module com.example.tictactoegame {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.game.tictactoegame to javafx.fxml;
    exports com.game.tictactoegame;
}