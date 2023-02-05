package com.example.dw_1.query;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EquipQuery extends Query {
    public static boolean insertEquip(Statement stmt, Integer id, String name, String size, String avail, String desc, Double price, String diving) throws SQLException{
        String query = String.format("INSERT INTO Equipment values('%d', '%s', '%s', '%s', '%s','%f', '%s');", id, name, size, avail,desc,price, diving);
        return stmt.execute(query);
    }
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
