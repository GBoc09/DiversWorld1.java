package com.example.dw_1.dao;

import com.example.dw_1.db.MyConnectionSingleton;
import com.example.dw_1.entity.Equipment;
import com.example.dw_1.exception.AlreadyRegisteredEquipException;
import com.example.dw_1.query.EquipQuery;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

public class SuitDAO {
    private static final String TYPE = "suit";
    MyConnectionSingleton connection = MyConnectionSingleton.getInstance();

    public void insertSuit(Equipment suit) throws AlreadyRegisteredEquipException {
        Connection con =connection.getConnection();
        try(Statement stmt = con.createStatement();){
            EquipQuery.insertEquip(stmt, suit.getId(), suit.getDiving(), TYPE);
            EquipQuery.insertIntoSuit(stmt, suit.getDescription(), suit.getSize(), suit.getAvailability(), suit.getPrice(), suit.getId());
        } catch (SQLIntegrityConstraintViolationException e){
            throw new AlreadyRegisteredEquipException(1);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
