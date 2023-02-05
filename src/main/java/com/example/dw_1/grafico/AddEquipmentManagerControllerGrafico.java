package com.example.dw_1.grafico;

import com.example.dw_1.DiversWorld;
import com.example.dw_1.applicativo.GestioneEquipControllerApplicativo;
import com.example.dw_1.bean.DivingBean;
import com.example.dw_1.bean.EquipmentBean;
import com.example.dw_1.bean.ValidationBean;
import com.example.dw_1.exception.AlreadyRegisteredEquipException;
import com.example.dw_1.exception.InvalidCredentialException;
import com.example.dw_1.exception.NotFoundDivingException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.util.logging.Level;
import java.util.logging.Logger;

public class AddEquipmentManagerControllerGrafico {
    ObservableList<String> equipList = FXCollections.observableArrayList("Jacket", "Regulator", "Mask", "Finns", "Weight", "Suit");
    ObservableList<String> sizeList = FXCollections.observableArrayList("none","XS", "S", "M", "L", "XL");
    @FXML
    private Button addProduct;

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
    private ChoiceBox<String> type;
    @FXML
    private Label errorLabel;
    @FXML
    private TextField divingCode;

    @FXML
    private void initialize() {
        size.setItems(sizeList);
        size.setValue("select size");
        type.setItems(equipList);
        type.setValue("select type");
    }
    @FXML
    void addNewProduct(ActionEvent event) throws AlreadyRegisteredEquipException { /* aggiungere al catalogo delle attrzzature */
        if (divingCode.getText().isEmpty()|| id.getText().isEmpty()|| availability.getText().isEmpty()||description.getText().isEmpty()||price.getText().isEmpty()||size.getValue().isEmpty()|| type.getValue().isEmpty()){
            errorLabel.setText("Fill all fields");
        }
        EquipmentBean equipmentBean = insertInfo();
        GestioneEquipControllerApplicativo equipManage = new GestioneEquipControllerApplicativo();
        equipManage.addEquip(equipmentBean);
    }
    private EquipmentBean insertInfo() {
        EquipmentBean equipmentBean = new EquipmentBean();
        equipmentBean.setIdBean(Integer.valueOf(id.getText()));
        equipmentBean.setNameBean(type.getValue());
        equipmentBean.setSizeBean(size.getValue());
        equipmentBean.setAvailBean(availability.getText());
        equipmentBean.setDescrBean(description.getText());
        equipmentBean.setPriceBean(Double.valueOf(price.getText()));
        equipmentBean.setDivingID(divingCode.getText());
        return equipmentBean;
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