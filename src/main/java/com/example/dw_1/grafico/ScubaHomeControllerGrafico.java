package com.example.dw_1.grafico;

import com.example.dw_1.DiversWorld;
import com.example.dw_1.applicativo.ProfiloUtenteControllerApplicativo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ScubaHomeControllerGrafico implements Initializable {
    @FXML
    private Button bookCourse;
    @FXML
    private Button logBook;
    @FXML
    private ImageView profilo;
    @FXML
    private Button rentEqip;
    @FXML
    private Label backHome;
    @FXML
    private Label userLabel;
    Logger logger = Logger.getLogger(ScubaHomeControllerGrafico.class.getName());
    ProfiloUtenteControllerApplicativo profiloController = new ProfiloUtenteControllerApplicativo();
    List<String> datiUtente;


    @FXML
    void backToScubaHome(MouseEvent event) {
        try{
            DiversWorld dw = new DiversWorld();
            dw.changeScene("scuba_home.fxml");
        }
        catch (Exception e){
            logger.log(Level.INFO, "Exception Error");
        }
    }
    @FXML
    void modificaProfilo(ActionEvent event) {
        // dummy
    }
    @FXML
    void visualizzaProfilo(MouseEvent event) throws IOException {
         DiversWorld dw = new DiversWorld();
         dw.changeScene("profiloScuba.fxml");
         datiUtente = provaStampa();
    }
    /**
     * a controller is called first, then any  @FXML fields are populated and then initialize() is called.  */
    public List<String> provaStampa ()  {
        List<String> dati = profiloController.visualizzaDati();
        System.out.println("contreller grafico");
        System.out.println(dati);

        return dati;
    }
    /**
     * FUNZIONE PER INIZIALIZZARE LE STAMPE A SCHERMO non scritta perchè non funzionante
     * cancellare i controller inutili */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String user = LoginControllerGrafico.getUserEmail();
        userLabel.setText(user);
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
