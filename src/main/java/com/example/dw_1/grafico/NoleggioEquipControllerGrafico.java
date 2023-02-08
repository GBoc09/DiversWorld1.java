package com.example.dw_1.grafico;

import com.example.dw_1.DiversWorld;
import com.example.dw_1.applicativo.GestioneEquipControllerApplicativo;
import com.example.dw_1.bean.EquipmentBean;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NoleggioEquipControllerGrafico {

    @FXML
    private Button finn;

    @FXML
    private Label goHome;

    @FXML
    private Button jacket;

    @FXML
    private Button mask;

    @FXML
    private Button regulator;

    @FXML
    private Button suit;
    Logger logger = Logger.getLogger(LoginControllerGrafico.class.getName());
    @FXML
    void goHome(MouseEvent event) {
        try{
            DiversWorld dw = new DiversWorld();
            dw.changeScene("scuba_home.fxml");
        }
        catch (Exception e){
            logger.log(Level.INFO, "Exception Error");
        }
    }
    public String type;
    EquipmentBean equipmentBean;
    @FXML
    void show(ActionEvent event) throws IOException {
        Node source = (Node) event.getSource();
        if (source == mask) {
            type = "mask";
            System.out.println("noleggio controller grafico --- "+type);
            equipmentBean = takeInfo(type);
            DiversWorld dw = new DiversWorld();
            dw.changeScene("maskPage.fxml");
        } else if (source == finn) {
            type = "finn";
            DiversWorld dw = new DiversWorld();
            dw.changeScene("finnsPage.fxml");
        } else if (source == jacket) {
            type = "jacket";
            DiversWorld dw = new DiversWorld();
            dw.changeScene("jacketPage.fxml");
        } else if (source == suit) {
            type = "suit";
            DiversWorld dw = new DiversWorld();
            dw.changeScene("suitPage.fxml");
        } else if (source == regulator) {
            type = "regualtor";
            DiversWorld dw = new DiversWorld();
            dw.changeScene("regulatorPage.fxml");
        }
    }
    private EquipmentBean takeInfo(String tipo){
        EquipmentBean equipmentBean1 = new EquipmentBean();
        equipmentBean1.setEquipType(tipo);
        String str = equipmentBean1.getEquipType();
        System.out.println("take info controller grafico, salavtaggio in bean1 --- "+str);
        GestioneEquipControllerApplicativo gestione = new GestioneEquipControllerApplicativo();
        EquipmentBean d;
        d = gestione.getSomeEquip(equipmentBean1);
        String prova = d.getIdEquip();
        System.out.println("noleggio equip controller grafico --- prova dopo db "+prova);
        return d;
    }
}
