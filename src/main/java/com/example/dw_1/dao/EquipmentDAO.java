package com.example.dw_1.dao;

import com.example.dw_1.db.MyConnectionSingleton;
import com.example.dw_1.entity.Diving;
import com.example.dw_1.entity.Equipment;
import com.example.dw_1.exception.AlreadyRegisteredEquipException;
import com.example.dw_1.exception.EquipNotFoundException;
import com.example.dw_1.other.EquipCatalogue;
import com.example.dw_1.query.EquipQuery;

import java.sql.*;
import java.util.ArrayList;

public class EquipmentDAO {
    private static final String ID_COLUMN = "id";
    private static final String NAME_COLUMN = "name";
    private static final String SIZE_COLUMN = "size";
    private static final String AVAILABILITY_COLUMN = "availability";
    private static final String DESCRIPTION_COLUMN = "description";
    private static final String PRICE_COLUMN = "price";
    private static final String DIVING_ID_COLUMN = "divingID";

    MyConnectionSingleton connection = MyConnectionSingleton.getInstance();
    /*public List<Equipment> getEquipList(){
        ArrayList<Equipment> equipmentList = new ArrayList<>();
        Factory factory = new Factory();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Connection con = connection.getConnection();
            stmt = con.createStatement();
            rs = EquipQuery.loadALLEquips(stmt);
            while (rs.next()){
                String data = rs.getString(1)
            }
        }
    }*/

    public EquipCatalogue loadAllProduct(){
        ArrayList<Equipment> equips = new ArrayList<>();
        Connection con =connection.getConnection();
        try(Statement stmt = con.createStatement();
            ResultSet rs = EquipQuery.loadALLEquips(stmt);){
            while (rs.next()){
                Equipment equipment = createEquip(rs);
                equips.add(equipment);
            }
        } catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        return new EquipCatalogue(equips);
    }
    /* prepared statement: same SQL command can be used multiple times */
    public void insertProduct( Equipment equipment) throws AlreadyRegisteredEquipException {
        Connection con =connection.getConnection();
        try(Statement stmt = con.createStatement();){
            EquipQuery.insertEquip(stmt, equipment.getId(), equipment.getName(),equipment.getSize(), equipment.getAvailability(), equipment.getDescription(),equipment.getPrice(), equipment.getDiving());
        } catch (SQLIntegrityConstraintViolationException e){
            throw new AlreadyRegisteredEquipException(1);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public Equipment loadAllEquipsByName(String name, Integer divingID) throws EquipNotFoundException {
        Equipment equipment = null;
        Connection con =connection.getConnection();
        try (Statement stmt = con.createStatement();
        ResultSet rs = EquipQuery.loadEquipByName(stmt, name, divingID)){
            if (rs.next()){
                equipment = createEquip(rs);
            } else {
                throw new EquipNotFoundException("Article not found");
            }
        } catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        return equipment;
    }

    public EquipCatalogue loadEquipByID (int equipCode)  {
        ArrayList<Equipment> equipments = new ArrayList<>();
        Connection con =connection.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = EquipQuery.loadEquipByID(stmt, equipCode)){
            while(rs.next()){
               Equipment locEquip = createEquip(rs);
               equipments.add(locEquip);
            }
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        return new EquipCatalogue(equipments);
    }
    private Equipment createEquip(ResultSet rs) throws SQLException{
        Integer id = rs.getInt(ID_COLUMN);
        String name = rs.getString(NAME_COLUMN);
        String size = rs.getString(SIZE_COLUMN);
        String avail = rs.getString(AVAILABILITY_COLUMN);
        String desc = rs.getString(DESCRIPTION_COLUMN);
        Double price = rs.getDouble(PRICE_COLUMN);
        String divingID = rs.getString(DIVING_ID_COLUMN);
        DivingDAO divingDAO = new DivingDAO();
        Diving diving = divingDAO.loadDivingByManager (divingID);

        return new Equipment(id, name, size, avail, desc, price, divingID);
        }

}

