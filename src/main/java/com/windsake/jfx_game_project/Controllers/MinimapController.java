package com.windsake.jfx_game_project.Controllers;

import com.windsake.jfx_game_project.Main;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;

public class MinimapController {
    @FXML
    AnchorPane pane;

    @FXML
    public void initialize(){
        pane.setBackground(new Background(
                new BackgroundImage(
                        new Image(Main.class.getResource("./pictures/mage.jpg").toExternalForm(),250,250,false,true),
                        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                        BackgroundSize.DEFAULT
                )
        ));
    }
}
