package com.windsake.jfx_game_project.Controllers;

import com.windsake.jfx_game_project.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.SubScene;
import javafx.stage.Stage;

import java.io.IOException;

public class GameWindowController {
    Stage gameStage = Main.getPrimaryStage();

    @FXML
    SubScene SubScene;

    @FXML
    public void initialize() {
        set_minimap_scene();
    }

    private void set_minimap_scene() {
        Parent root = null;
        try {
            root = FXMLLoader.load(Main.class.getResource("./fxml/Minimap.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        SubScene.setRoot(root);
        SubScene.setLayoutX(Main.WIDTH - 210);
        SubScene.setLayoutY(10);
        SubScene.setVisible(false);
    }
}