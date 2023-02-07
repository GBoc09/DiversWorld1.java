package com.example.dw_1;

import com.example.dw_1.db.MyConnectionSingleton;
import com.example.dw_1.query.UserQuery;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;

public class DiversWorld extends Application {
    private static Stage stg;

    public static void setStg(Stage stage) {
        stg = stage;
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
       try {
           setStg(primaryStage);
           Parent root = FXMLLoader.load(getClass().getResource("casa.fxml"));
           Scene scene1 = new Scene(root);
           primaryStage.setScene(scene1);
           primaryStage.setTitle("DiversWorld!");
           primaryStage.show();
       } catch (Exception e){
           e.printStackTrace();
       }
    }

    public void changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        stg.getScene().setRoot(pane);
    }
    public static void main(String[] args) {
        launch();
    }
}