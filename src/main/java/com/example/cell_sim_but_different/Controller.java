package com.example.cell_sim_but_different;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller extends Application {
    public static Scene scene;
    boolean paneHide = false;
    public static int size = 200;
    int screenSize = 600;
    public static Pane particlePane = new Pane();

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Controller.class.getResource("ui.fxml"));
        Pane uiPane = new Pane();
        uiPane.getChildren().add(fxmlLoader.load());

        particlePane.setBackground(new Background(new BackgroundFill(Color.GRAY, null, null)));
        particlePane.setMinSize(screenSize, screenSize);

        Pane basePane = new Pane(particlePane, uiPane);
        scene = new Scene(basePane, screenSize, screenSize);

        uiPane.setVisible(paneHide);
        scene.setOnKeyPressed(Event ->{
            if (Event.getCode().equals(KeyCode.ESCAPE)) {
                paneHide = !paneHide;
                uiPane.setVisible(paneHide);
            }
        });
        ParticlePane.initialize(screenSize, size);

        AnimationTimer t = new Update();
        t.start();

        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}