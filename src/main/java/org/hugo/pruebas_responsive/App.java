package org.hugo.pruebas_responsive;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hugo.pruebas_responsive.ctrll.MenuCtrll;
import org.hugo.pruebas_responsive.util.R;
import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(R.getUI("menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        stage.setTitle("Prueba Responsive");
        stage.setScene(scene);
        stage.show();

        MenuCtrll menuCtrll = fxmlLoader.getController();
        menuCtrll.setMinHW(stage);
    }

    public static void main(String[] args) {
        launch();
    }
}