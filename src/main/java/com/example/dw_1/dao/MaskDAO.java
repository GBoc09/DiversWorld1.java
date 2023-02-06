package com.example.dw_1.dao;

import com.example.dw_1.db.MyConnectionSingleton;
import com.example.dw_1.entity.Equipment;
import com.example.dw_1.exception.AlreadyRegisteredEquipException;
import com.example.dw_1.exception.AlreadyRegisteredUserException;
import com.example.dw_1.query.EquipQuery;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

public class MaskDAO {
    private static final String TYPE = "mask";
    MyConnectionSingleton connection = MyConnectionSingleton.getInstance();

    public void insertMask(Equipment mask) throws AlreadyRegisteredEquipException {
        Connection con =connection.getConnection();
        try(Statement stmt = con.createStatement();){
            EquipQuery.insertEquip(stmt, mask.getId(), mask.getDiving(), TYPE);
            EquipQuery.insertIntoMask(stmt, mask.getDescription(),  mask.getPrice(),mask.getAvailability(), mask.getId());
        } catch (SQLIntegrityConstraintViolationException e){
            throw new AlreadyRegisteredEquipException(1);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

}
