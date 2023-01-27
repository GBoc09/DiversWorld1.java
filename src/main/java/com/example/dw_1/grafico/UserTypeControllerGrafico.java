package com.example.dw_1.grafico;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

import static com.example.dw_1.grafico.RegistrationControllerGrafico.SCUBA_TYPE;
import static com.example.dw_1.grafico.RegistrationControllerGrafico.FREE_TYPE;
import static com.example.dw_1.grafico.RegistrationControllerGrafico.MANAGER_TYPE;

public class UserTypeControllerGrafico {
 /*   public static final int SCUBA_TYPE = 0;
    public static final int FREE_TYPE = 1;
    public static final int MANAGER_TYPE = 2;*/

    public static final String SCUBA_HOME_SCREEN = "scuba_home.fxml";
    public static final String FREE_HOME_SCREEN = "free_home.fxml";
    public static final String MANAGER_HOME_SCREEN = "manager_home.fxml";

    public void enterAsUser(int userType, Scene mainScene) throws IOException {
        BorderPane container = (BorderPane) mainScene.getRoot();
        String mainScreen = null;
        if (userType == SCUBA_TYPE) {
            mainScreen = SCUBA_HOME_SCREEN;
        } else if (userType == FREE_TYPE) {
            mainScreen = FREE_HOME_SCREEN;
        } else if (userType == MANAGER_TYPE) {
            mainScreen = MANAGER_HOME_SCREEN;
        }
        if (container != null && mainScreen != null){
            FXMLLoader userHomeScreen = new FXMLLoader(getClass().getClassLoader().getResource(mainScreen));
            container.setCenter(userHomeScreen.load());
        }
    }
}
