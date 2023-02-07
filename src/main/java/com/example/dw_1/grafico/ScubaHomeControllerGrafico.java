package com.example.dw_1.grafico;

import com.example.dw_1.DiversWorld;
import com.example.dw_1.applicativo.ProfiloUtenteControllerApplicativo;
import com.example.dw_1.entity.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.List;
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
    private Button modificaProfilo;
    @FXML
    private TextField textLicense;

    @FXML
    private TextField textEmail;

    @FXML
    private TextField textLastname;

    @FXML
    private TextField textName;

    @FXML
    private PasswordField textPass;
    @FXML
    private Label backHome;

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
    private Label userLabel;
    Logger logger = Logger.getLogger(ScubaHomeControllerGrafico.class.getName());
    ProfiloUtenteControllerApplicativo profiloController = new ProfiloUtenteControllerApplicativo();
    List<String> datiUtente;
    @FXML
    List<String> visualizzaProfilo(MouseEvent event) throws IOException {
         DiversWorld dw = new DiversWorld();
         dw.changeScene("profiloScuba.fxml");
         datiUtente = provaStampa();
        return datiUtente;
    }
    /**
     * a controller is called first, then any  @FXML fields are populated and then initialize() is called.  */

    public List<String> provaStampa (){
        List<String> dati = profiloController.visualizzaDati();
         System.out.println("contreller grafico");
        System.out.println(dati);
        return dati;
    }
    //FUNZIONE PER STAMPARE A SCHERMO LE INFO
   @FXML
    public void initialize() {
        userLabel.setText("aaa");
        /*textEmail.setText("aaa");
        textName.setText(dati.get(1));
        textLastname.setText(dati.get(2));
        textLicense.setText(dati.get(3));*/
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
