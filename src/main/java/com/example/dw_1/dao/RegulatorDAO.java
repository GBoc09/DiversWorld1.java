package com.example.dw_1.dao;

import com.example.dw_1.db.MyConnectionSingleton;
import com.example.dw_1.entity.Equipment;
import com.example.dw_1.exception.AlreadyRegisteredEquipException;
import com.example.dw_1.query.EquipQuery;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

public class RegulatorDAO {
    private static final String TYPE = "regulator";
    MyConnectionSingleton connection = MyConnectionSingleton.getInstance();

    public void insertReg(Equipment reg) throws AlreadyRegisteredEquipException {
        Connection con =connection.getConnection();
        try(Statement stmt = con.createStatement();){
            EquipQuery.insertEquip(stmt, reg.getId(), reg.getDiving(), TYPE);
            EquipQuery.insertIntoReg(stmt, reg.getDescription(), reg.getPrice(), reg.getAvailability(), reg.getId());
        } catch (SQLIntegrityConstraintViolationException e){
            throw new AlreadyRegisteredEquipException(1);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }


}
