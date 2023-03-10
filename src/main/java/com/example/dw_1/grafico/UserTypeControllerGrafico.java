package com.example.dw_1.grafico;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class UserTypeControllerGrafico {
    public static final String SCUBA_HOME_SCREEN = "scuba_home.fxml";
    public static final String FREE_HOME_SCREEN = "free_home.fxml";
    public static final String MANAGER_HOME_SCREEN = "manager_home.fxml";

    public void enterAsUser(int userType, Scene mainScene) throws IOException {
        BorderPane container = (BorderPane) mainScene.getRoot();
        String mainScreen = null;
        if (userType == RegistrationControllerGrafico.SCUBA_TYPE) {
            mainScreen = SCUBA_HOME_SCREEN;
        } else if (userType == RegistrationControllerGrafico.FREE_TYPE) {
            mainScreen = FREE_HOME_SCREEN;
        } else if (userType == RegistrationControllerGrafico.MANAGER_TYPE) {
            mainScreen = MANAGER_HOME_SCREEN;
        }
        if (container != null && mainScreen != null){
            FXMLLoader userHomeScreen = new FXMLLoader(getClass().getClassLoader().getResource(mainScreen));
            container.setCenter(userHomeScreen.load());
        }
    }
}
