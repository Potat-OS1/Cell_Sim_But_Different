module com.example.cell_sim_but_different {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.cell_sim_but_different to javafx.fxml;
    exports com.example.cell_sim_but_different;
    exports com.example.cell_sim_but_different.brush;
    opens com.example.cell_sim_but_different.brush to javafx.fxml;
}