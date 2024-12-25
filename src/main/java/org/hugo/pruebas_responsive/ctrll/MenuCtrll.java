package org.hugo.pruebas_responsive.ctrll;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.hugo.pruebas_responsive.util.R;
import java.io.IOException;


public class MenuCtrll {

    @FXML
    public HBox hbContenido;

    public void setMinHW(Stage stage) {
        // Espera a que se genere la ventana para añadir los marcos dentro del tamaño mínimo y sea consistente entre SO
        ChangeListener<Number> changeListener = new ChangeListener<>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                stage.setMinHeight(400);
                stage.setMinWidth(600);

                stage.heightProperty().removeListener(this);
            }
        };

        stage.heightProperty().addListener(changeListener);
    }

    public void onNada(ActionEvent actionEvent) {
        hbContenido.getChildren().clear();
    }

    public void onFormulario(ActionEvent actionEvent) {
        try {
            cambiarEscena("formulario.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void onTabla(ActionEvent actionEvent) {
        try {
            cambiarEscena("tabla.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void cambiarEscena(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(R.getUI(fxml));
        VBox vBox = fxmlLoader.load();

        hbContenido.getChildren().clear();
        hbContenido.getChildren().add(vBox);
    }
}