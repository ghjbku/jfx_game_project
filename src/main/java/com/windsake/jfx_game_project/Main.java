package com.windsake.jfx_game_project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    static Stage primarystage;
    public static final int WIDTH =800,HEIGHT=600;
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("./fxml/MainWindow.fxml"));
        primaryStage.setTitle("Title Window");
        primaryStage.setScene(new Scene(root, WIDTH  , HEIGHT));
        primaryStage.show();
        primarystage = primaryStage;
    }

    public static Stage getPrimaryStage(){
        return primarystage;
    }


    public static void main(String[] args) {
        launch(args);
    }
}

