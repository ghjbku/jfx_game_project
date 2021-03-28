package com.windsake.jfx_game_project.Controllers;

import com.windsake.jfx_game_project.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import static com.windsake.jfx_game_project.Main.HEIGHT;
import static com.windsake.jfx_game_project.Main.WIDTH;

public class SettingsWindowController {

    private static void head_back_to_main_menu() throws IOException {
        Stage gameStage = Main.getPrimaryStage();
        Parent root = FXMLLoader.load(Main.class.getResource("./fxml/MainWindow.fxml"));
        gameStage.setScene(new Scene(root, WIDTH  , HEIGHT));
        gameStage.show();
    }
    private void click_any_button(MouseEvent event) {
        ImageView button= (ImageView) event.getSource();
        button.setFitHeight(button.getFitHeight()+10);
        button.setFitWidth(button.getFitWidth()+10);
        TimerTask task = new TimerTask() {
            public void run() {
                button.setFitHeight(button.getFitHeight()-10);
                button.setFitWidth(button.getFitWidth()-10);
                button.setOpacity(1);
            }
        };
        new Timer("clicked_button_animation_timer").schedule(task,100L);
    }
    @FXML
    public void hover_any_button(MouseEvent event) {
        ImageView hovered= (ImageView) event.getSource();
        hovered.setOpacity(hovered.getOpacity() / 2);
    }

    @FXML
    public void exit_any_button(MouseEvent event) {
        ImageView hovered= (ImageView) event.getSource();
        hovered.setOpacity(1);
    }
    @FXML
    public void on_back_button_click(MouseEvent event) {
        click_any_button(event);
        try {
            head_back_to_main_menu();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
