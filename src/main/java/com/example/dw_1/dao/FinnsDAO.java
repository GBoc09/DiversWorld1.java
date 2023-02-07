package com.example.dw_1.dao;

import com.example.dw_1.db.MyConnectionSingleton;
import com.example.dw_1.entity.Equipment;
import com.example.dw_1.exception.AlreadyRegisteredEquipException;
import com.example.dw_1.query.EquipQuery;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

public class FinnsDAO {
    private static final String TYPE = "finns";
    MyConnectionSingleton connection = MyConnectionSingleton.getInstance();

    public void insertFinns(Equipment finn) throws AlreadyRegisteredEquipException {
        Connection con =connection.getConnection();
        try(Statement stmt = con.createStatement();){
            EquipQuery.insertEquip(stmt, finn.getId(), finn.getDiving(), TYPE);
            EquipQuery.insertIntoFinns(stmt, finn.getDescription(), finn.getSize(),finn.getAvailability(), finn.getPrice(),finn.getId() );
        } catch (SQLIntegrityConstraintViolationException e){
            throw new AlreadyRegisteredEquipException(1);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
