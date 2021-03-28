package com.windsake.jfx_game_project.Controllers;

import com.windsake.jfx_game_project.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.IOException;

public class GameWindowController {
    Stage gameStage = Main.getPrimaryStage();

    @FXML
    SubScene SubScene;
    @FXML
    GridPane game_field;

    private final int[][] game_field_table = new int[5][5];
    public int last_posx = 0, last_posy = 0;

    @FXML
    public void initialize() {
        init_minimap_scene();
        init_game_field();
    }

    //returns the specific cell of the grid
    private ImageView get_specific_cell(int row, int col) {
        return (ImageView) game_field.getChildren().get(col * 5 + row);
    }

    @FXML
    public void on_grid_click(MouseEvent event) {
        ImageView clicked_grid = (ImageView) event.getSource();
        setGame_field_table(clicked_grid);
    }

    //the player movement
    private void setGame_field_table(ImageView clicked_grid) {
        char[] ids = clicked_grid.getId().toCharArray();
        //removing old position
        game_field_table[last_posx][last_posy] = 0;
        get_specific_cell(last_posx, last_posy).setImage(null);
        last_posx = Character.getNumericValue(ids[1]);
        last_posy = Character.getNumericValue(ids[2]);
        //assigning new position
        game_field_table[last_posx][last_posy] = 1;
        clicked_grid.setImage(new Image(Main.class.getResource("./pictures/player_icon.png").toExternalForm()));
    }

    private void init_game_field() {
        game_field.setLayoutX(0);
        game_field.setLayoutY(0);
        game_field.setBackground(new Background(new BackgroundFill(Paint.valueOf("green"), CornerRadii.EMPTY, Insets.EMPTY)));
        game_field_table[0][0] = 1;
        game_field.setGridLinesVisible(true);
    }

    private void init_minimap_scene() {
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