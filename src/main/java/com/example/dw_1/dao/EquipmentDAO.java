package com.example.dw_1.dao;

import com.example.dw_1.db.MyConnectionSingleton;
import com.example.dw_1.entity.Diving;
import com.example.dw_1.entity.Equipment;
import com.example.dw_1.query.DivingQuery;
import com.example.dw_1.query.EquipQuery;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EquipmentDAO{
    MyConnectionSingleton connection = MyConnectionSingleton.getInstance();
    public List<Equipment> getEquipInfo(){
        Connection con = connection.getConnection();
        List<Equipment> equips = new ArrayList<>();
        try(Statement stmt = con.createStatement();
            ResultSet rs = EquipQuery.selectEqui(stmt)){
            while (rs. next()){
                Equipment newEquip = new Equipment();
                newEquip.setIdEquip(rs.getString(1));
                newEquip.setDivingID(rs.getString(2));
                newEquip.setEquipType(rs.getString(3));
                newEquip.setSize(rs.getString(4));
                newEquip.setAvail(rs.getString(5));
                newEquip.setPrice(rs.getDouble(6));
                equips.add(newEquip);
            }
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        return equips;
    }
}

