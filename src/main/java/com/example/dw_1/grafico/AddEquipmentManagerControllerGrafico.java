package com.example.dw_1.grafico;

import com.example.dw_1.DiversWorld;
import com.example.dw_1.applicativo.GestioneEquipControllerApplicativo;
import com.example.dw_1.bean.EquipmentBean;
import com.example.dw_1.exception.AlreadyRegisteredEquipException;
import com.example.dw_1.exception.AlreadyRegisteredUserException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.util.logging.Level;
import java.util.logging.Logger;

public class AddEquipmentManagerControllerGrafico {
    /** valutare come prenderee il tipo di equipment e se lasciare i radio button
     * valutare se levare le classi che riguardano le specifiche componenti
     * continuare le modifche nella parte dell'equip
     *  +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
     *  creazione delle query per inserimento e selezione completa FATTO
     *  model el DAO creati
     */
    ObservableList<String> sizeList = FXCollections.observableArrayList("none","XS", "S", "M", "L", "XL");
    @FXML
    private Button addProduct;
    @FXML
    private RadioButton finn;
    @FXML
    private RadioButton jack;
    @FXML
    private RadioButton mask;
    @FXML
    private RadioButton reg;
    @FXML
    private RadioButton suit;

    @FXML
    private TextField availability;

    @FXML
    private TextField description;

    @FXML
    private TextField id;
    @FXML
    private Label goHome;

    @FXML
    private TextField price;

    @FXML
    private ChoiceBox<String> size;

    @FXML
    private Label errorLabel;
    @FXML
    private TextField divingCode;
    /* ---------- DICHIARAZIONE CHECK BOX ----------- */
    private static final int J = 0;
    private static final int R = 1;
    private static final int F = 2;
    private static final int M = 3;
    private static final int S = 4;

    private Integer equipChoice;
    EquipmentBean equipmentBean;
    @FXML
    private void initialize() {
        size.setItems(sizeList);
        size.setValue("select size");
    }
    @FXML
    void addNewProduct(ActionEvent event) throws AlreadyRegisteredEquipException { /* aggiungere al catalogo delle attrzzature */
        if (divingCode.getText().isEmpty()|| id.getText().isEmpty()|| availability.getText().isEmpty()||description.getText().isEmpty()||price.getText().isEmpty()||size.getValue().isEmpty()){
            errorLabel.setText("Fill all fields");
        }
        equipmentBean = insertInfo();
        GestioneEquipControllerApplicativo equipManage = new GestioneEquipControllerApplicativo();
        equipManage.addEquip(equipmentBean);
    }
    private EquipmentBean insertInfo() {
        EquipmentBean equipment = new EquipmentBean();

        equipment.setIdDiving(divingCode.getText());

        equipment.setIdEquip(id.getText());

        equipment.setSize(size.getValue());

        equipment.setAvail(availability.getText());

        equipment.setEquipType(description.getText());

        equipment.setPrice(Double.valueOf(price.getText()));

        if (jack.isSelected()){
            equipChoice = J;
        } else if (reg.isSelected()) {
            equipChoice = R;
        } else if (mask.isSelected()) {
            equipChoice = M;
        } else if (finn.isSelected()) {
            equipChoice = F;
        } else if (suit.isSelected()) {
            equipChoice = S;
        }
        return equipment;
    }
    Logger log;

    @FXML
    void goHome(MouseEvent event) {
        try{
            DiversWorld dw = new DiversWorld();
            dw.changeScene("manager_home.fxml");
        }
        catch (Exception e){
            log.log(Level.INFO, "Exception Error");
        }

    }



}