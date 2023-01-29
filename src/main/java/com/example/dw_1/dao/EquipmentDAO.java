package com.example.dw_1.dao;

import com.example.dw_1.db.MyConnectionSingleton;
import com.example.dw_1.entity.Equipment;
import com.example.dw_1.other.EquipCatalogue;
import com.example.dw_1.query.EquipQuery;
import javafx.scene.Parent;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EquipmentDAO {
    private static final String ID_COLUMN = "id";
    private static final String SIZE_COLUM = "size";
    private static final String TYPE_COLUM = "type";
    private static final String AVAILABILITY_COLUM = "availability";
    private static final String DESCRIPTION_COLUM = "description";
    private static final String PRICE_COLUM = "price";

    MyConnectionSingleton connection = MyConnectionSingleton.getInstance();
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
    public boolean insertProduct( Equipment equipment){
        return true;
        // aaa
    }
    private Equipment createEquip(ResultSet rs) throws SQLException{
        Integer id = rs.getInt(ID_COLUMN);
        String type = rs.getString(TYPE_COLUM);
        String size = rs.getString(SIZE_COLUM);
        String avail = rs.getString(AVAILABILITY_COLUM);
        String desc = rs.getString(DESCRIPTION_COLUM);
        Double price = rs.getDouble(PRICE_COLUM);

        return new Equipment(id, type, size, avail, desc, price);
        }

}

