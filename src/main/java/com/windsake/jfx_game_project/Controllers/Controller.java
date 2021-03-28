package com.windsake.jfx_game_project.Controllers;

import com.windsake.jfx_game_project.Main;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import static com.windsake.jfx_game_project.Main.HEIGHT;
import static com.windsake.jfx_game_project.Main.WIDTH;

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
        StartButton.setLayoutX((WIDTH - StartButton.getFitWidth()) / 2);
        StartButton.setLayoutY(HEIGHT / 4.0f);
        OptionsButton.setLayoutX((WIDTH - OptionsButton.getFitWidth()) / 2);
        OptionsButton.setLayoutY(StartButton.getLayoutY() + (OptionsButton.getFitHeight() * 2));
        ExitButton.setLayoutX((WIDTH - ExitButton.getFitWidth()) / 2);
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

    private static void start_game() throws IOException {
        Stage gameStage = Main.getPrimaryStage();
        Parent root = FXMLLoader.load(Main.class.getResource("./fxml/GameWindow.fxml"));
        gameStage.setTitle("JFX game project");
        gameStage.setScene(new Scene(root, WIDTH  , HEIGHT));
        gameStage.show();
    }
    private static void open_settings() throws IOException{
        Stage gameStage = Main.getPrimaryStage();
        Parent root = FXMLLoader.load(Main.class.getResource("./fxml/SettingsWindow.fxml"));
        gameStage.setTitle("Settings");
        gameStage.setScene(new Scene(root, WIDTH  , HEIGHT));
        gameStage.show();
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
        try {
            start_game();
        }catch (Exception e){
            System.out.println(e);
        }

    }

    @FXML
    public void on_options_button_click(MouseEvent event) {
        click_any_button(event);
        try {
            open_settings();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @FXML
    public void on_exit_button_click() {
        System.exit(0);
    }
}
