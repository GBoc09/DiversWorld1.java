package com.example.dw_1.query;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EquipQuery extends Query {
    public static ResultSet loadALLEquips (Statement stmt) throws SQLException{
        String query = String.format("SELECT * FROM Equipment");
        return stmt.executeQuery(query);
    }
    public static ResultSet loadEquipByName (Statement stmt, String name, Integer divingID) throws SQLException{
        String query = String.format("SELECT * FROM Equipment WHERE name = '%s' AND diving '%d';", name, divingID);
        return stmt.executeQuery(query);
    }
    public static ResultSet loadEquipByID (Statement stmt, int equipID) throws SQLException{
        String query = String.format("SELECT * FROM Equipment WHERE idEquipment = '%d';", equipID);
        return stmt.executeQuery(query);
    }


}
