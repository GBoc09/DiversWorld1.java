package com.example.dw_1.dao;

import com.example.dw_1.db.MyConnectionSingleton;
import com.example.dw_1.entity.Equipment;
import com.example.dw_1.exception.AlreadyRegisteredEquipException;
import com.example.dw_1.query.EquipQuery;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

public class JacketDAO {
    private static final String TYPE = "jacket";
    MyConnectionSingleton connection = MyConnectionSingleton.getInstance();

    public void insertJack(Equipment jack) throws AlreadyRegisteredEquipException {
        Connection con =connection.getConnection();
        try(Statement stmt = con.createStatement();){
            EquipQuery.insertEquip(stmt, jack.getId(), jack.getDiving(), TYPE);
            EquipQuery.insertIntoJack(stmt, jack.getDescription(),jack.getSize(),jack.getAvailability(),jack.getPrice(), jack.getId());
        } catch (SQLIntegrityConstraintViolationException e){
            throw new AlreadyRegisteredEquipException(1);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
