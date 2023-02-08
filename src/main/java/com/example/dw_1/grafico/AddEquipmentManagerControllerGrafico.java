package com.example.dw_1.grafico;

import com.example.dw_1.DiversWorld;
import com.example.dw_1.applicativo.GestioneEquipControllerApplicativo;
import com.example.dw_1.bean.EquipmentBean;
import com.example.dw_1.exception.AlreadyRegisteredEquipException;
import com.example.dw_1.exception.AlreadyRegisteredUserException;
import com.example.dw_1.exception.InvalidCredentialException;
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
    private TextField EquipType;
    @FXML
    private Button addProduct;

    @FXML
    private TextField availability;

    @FXML
    private TextField divingCode;

    @FXML
    private TextField equipID;

    @FXML
    private Label errorLabel;

    @FXML
    private RadioButton finn;

    @FXML
    private Label goHome;

    @FXML
    private RadioButton jack;

    @FXML
    private RadioButton mask;

    @FXML
    private TextField price;

    @FXML
    private RadioButton reg;

    @FXML
    private ChoiceBox<String> size;

    @FXML
    private RadioButton suit;

    @FXML
    private ToggleGroup type;

    EquipmentBean equipmentBean;
    Logger log = Logger.getLogger(AddEquipmentManagerControllerGrafico.class.getName());

    @FXML
    private void initialize() {
        size.setItems(sizeList);
        size.setValue("select size");
    }
    /* inserire verifica di campi riempiti */
    @FXML
    void addNewProduct(ActionEvent event) throws AlreadyRegisteredEquipException { /* aggiungere al catalogo delle attrzzature */
       if (equipID.getText().isEmpty() || divingCode.getText().isEmpty() || EquipType.getText().isEmpty() || size.getValue().isEmpty() || availability.getText().isEmpty() || price.getText().isEmpty()){
           Alert alert = new Alert(Alert.AlertType.ERROR);
           alert.setHeaderText(null);
           alert.setContentText("Fill all required fields");
           alert.showAndWait();
           errorLabel.setText("Fill all fields");
       }
        equipmentBean = insertInfo();
        GestioneEquipControllerApplicativo equipManage = new GestioneEquipControllerApplicativo();
        equipManage.addEquip(equipmentBean);
    }
    private EquipmentBean insertInfo() {
        EquipmentBean equipment = new EquipmentBean();
        equipment.setIdEquip(equipID.getText());
        equipment.setIdDiving(divingCode.getText());
        equipment.setEquipType(EquipType.getText());
        equipment.setSize(size.getValue());
        equipment.setAvail(availability.getText());
        equipment.setPrice(Double.valueOf(price.getText()));
        return equipment;
    }
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