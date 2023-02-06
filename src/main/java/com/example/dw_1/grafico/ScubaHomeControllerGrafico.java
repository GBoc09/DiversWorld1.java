package com.example.dw_1.grafico;

import com.example.dw_1.DiversWorld;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ScubaHomeControllerGrafico {
    @FXML
    private Button bookCourse;

    @FXML
    private Button logBook;

    @FXML
    private ImageView profilo;

    @FXML
    private Button rentEqip;

    @FXML
    private Label userLabel;
    Logger logger = Logger.getLogger(ScubaHomeControllerGrafico.class.getName());
     @FXML
    void visualizzaProfilo(MouseEvent event) throws IOException {
         DiversWorld dw = new DiversWorld();
         dw.changeScene("profiloScuba.fxml");
    }
    /* FUNZIONE PER STAMPARE A SCHERMO LE INFO */
    @FXML
    public void initialize(){
        userLabel.setText("ciao");
    }

    /* inizio use case */
    @FXML
    void rentEquip(ActionEvent event) {
        try{
            DiversWorld dw = new DiversWorld();
            dw.changeScene("searchDiving.fxml");
        }
        catch (Exception e){
            logger.log(Level.INFO, "Exception Error");
        }
    }

}
