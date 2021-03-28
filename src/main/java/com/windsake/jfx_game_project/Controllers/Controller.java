package com.windsake.jfx_game_project.Controllers;

import com.windsake.jfx_game_project.Main;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Controller {
    @FXML
    AnchorPane pane;
    @FXML
    ImageView StartButton;
    @FXML
    ImageView ExitButton;

    @FXML
    public void initialize(){
            StartButton.setLayoutX((Main.WIDTH - StartButton.getFitWidth()) / 2);
            StartButton.setLayoutY(Main.HEIGHT / 4.0f);
            ExitButton.setLayoutX((Main.WIDTH- ExitButton.getFitWidth()) / 2);
            ExitButton.setLayoutY(StartButton.getLayoutY()+(ExitButton.getFitHeight()*2));
    }
    @FXML
    public void hover_any_button(MouseEvent event){
        if (event.getSource().equals(StartButton)){
            StartButton.setOpacity(StartButton.getOpacity()/2);
        }else if(event.getSource().equals(ExitButton)){
            ExitButton.setOpacity(ExitButton.getOpacity()/2);
        }
    }
    @FXML
    public void exit_any_button(MouseEvent event){
        if (event.getSource().equals(StartButton)){
            StartButton.setOpacity(1);
        }else if(event.getSource().equals(ExitButton)){
            ExitButton.setOpacity(1);
        }
    }
    @FXML
    public void on_exit_button_click(){
        System.exit(0);
    }
}
