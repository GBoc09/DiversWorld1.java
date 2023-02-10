package com.example.dw_1.grafico;

import com.example.dw_1.DiversWorld;
import com.example.dw_1.dao.CartDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CartContrellerGrafico implements Initializable {

    @FXML
    private Button addItems;
    @FXML
    private ListView<String> cartView;
    @FXML
    private Button completeRental;
    @FXML
    private Button deleteItems;

    @FXML
    private Label goHome;
    Logger logger = Logger.getLogger(CartContrellerGrafico.class.getName());
    @FXML
    void goHome(MouseEvent event) {
        try {
            DiversWorld dw = new DiversWorld();
            dw.changeScene("scuba_home.fxml");
        } catch (Exception e){
            logger.log(Level.INFO, "Exception Error");
        }
    }
    @FXML
    void onButtonClicked(ActionEvent event) throws IOException {
        Node source = (Node) event.getSource();
        if (source == addItems) {
            DiversWorld dw = new DiversWorld();
            dw.changeScene("equipList.fxml");
        } else if (source == completeRental) {
            DiversWorld dw = new DiversWorld();
            dw.changeScene("completeRental.fxml");
        } else if (source == deleteItems) {
            // todo
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        deleteItems.setDisable(true);
        CartDAO cartDAO = new CartDAO();
        try {
                int i = val;
                String stringa = cartDAO.readUsingFileReader(i);
                cartView.getItems().add(stringa);
                cartDAO.createFileCart(stringa);
                deleteItems.setDisable(false);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static int val;
    public int memoryIndex(int i){
        val = i;
        return val;
    }
}

