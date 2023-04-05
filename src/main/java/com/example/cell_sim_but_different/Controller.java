package com.example.cell_sim_but_different;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller extends Application {
    public static Scene scene;
    boolean paneHide = true;
    int size = 100;
    int screenSize = 600;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Controller.class.getResource("ui.fxml"));
        Pane uiPane = new Pane();
        uiPane.getChildren().add(fxmlLoader.load());
        Pane basePane = new Pane(uiPane);
        scene = new Scene(basePane, screenSize, screenSize);


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