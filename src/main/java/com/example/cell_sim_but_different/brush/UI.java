package com.example.cell_sim_but_different.brush;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class UI {
    BrushStates brushState = BrushStates.FILL;

    @FXML
    private Label welcomeText;
    @FXML
    public StackPane ControlPanel;
    @FXML
    private StackPane fill, replace, erase;
    @FXML
    private Slider brushSizeSlider;
    @FXML
    private VBox ParticleBox, BrushBox, sidePane;
    @FXML
    private AnchorPane particleScroll;
    @FXML
    private Pane basePane;

    public void fillClicked() {
        brushState = BrushStates.FILL;
        System.out.println("Fill Mode");
    }

    public void replaceClicked() {
        brushState = BrushStates.REPLACE;
        System.out.println("Replace Mode");
    }

    public void eraseClicked() {
        brushState = BrushStates.ERASE;
        System.out.println("Erase Mode");
    }

    public void brushSlider() {

    }
}