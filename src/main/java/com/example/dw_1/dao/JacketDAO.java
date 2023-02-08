package com.example.dw_1.dao;

import com.example.dw_1.bean.EquipmentBean;
import com.example.dw_1.db.MyConnectionSingleton;
import com.example.dw_1.entity.Equipment;
import com.example.dw_1.entity.Jacket;
import com.example.dw_1.query.EquipQuery;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JacketDAO {
    public JacketDAO(){}
    MyConnectionSingleton connection = MyConnectionSingleton.getInstance();
    public List<Jacket> getJackInfo(EquipmentBean equipmentBean){
        Connection con = connection.getConnection();
        List<Jacket> equips = new ArrayList<>();
        try(Statement stmt = con.createStatement();
            ResultSet rs = EquipQuery.selectSomeData(stmt, equipmentBean.getEquipType())){
            while (rs. next()){
                Jacket newEquip = new Jacket();
                newEquip.setIdEquip(rs.getString(1));
                newEquip.setEquipType(rs.getString(2));
                newEquip.setPrice(rs.getDouble(3));
                equips.add(newEquip);
            }
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        return equips;
    }
}