package com.windsake.jfx_game_project.Controllers;

import com.windsake.jfx_game_project.Main;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.util.Timer;
import java.util.TimerTask;

public class Controller {
    @FXML
    AnchorPane pane;
    @FXML
    ImageView StartButton;
    @FXML
    ImageView OptionsButton;
    @FXML
    ImageView ExitButton;

    @FXML
    public void initialize() {
        StartButton.setLayoutX((Main.WIDTH - StartButton.getFitWidth()) / 2);
        StartButton.setLayoutY(Main.HEIGHT / 4.0f);
        OptionsButton.setLayoutX((Main.WIDTH - OptionsButton.getFitWidth()) / 2);
        OptionsButton.setLayoutY(StartButton.getLayoutY() + (OptionsButton.getFitHeight() * 2));
        ExitButton.setLayoutX((Main.WIDTH - ExitButton.getFitWidth()) / 2);
        ExitButton.setLayoutY(OptionsButton.getLayoutY() + (ExitButton.getFitHeight() * 2));
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
    public void on_start_button_click(MouseEvent event) {
        click_any_button(event);
        System.out.println("start");
    }

    @FXML
    public void on_options_button_click(MouseEvent event) {
        click_any_button(event);
        System.out.println("options");
    }

    @FXML
    public void on_exit_button_click() {
        System.exit(0);
    }
}
