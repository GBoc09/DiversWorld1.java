package com.example.dw_1.query;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EquipQuery extends Query {
    public static boolean insertEquip(Statement stmt,String idE, String diving, String typeE, String size, String avail, Double price) throws SQLException{
        String query = String.format("INSERT INTO Equipment values('%s', '%s', '%s', '%s', '%s', '%f');", idE, diving, typeE, size,avail,price);
        return stmt.execute(query);
    }
    public static ResultSet selectEqui(Statement stmt) throws SQLException {
        String query = String.format("SELECT * FROM  Equipment;");
        return stmt.executeQuery(query);
    }
    public static ResultSet selectEquipByDivingCode(Statement stmt, String divingCode) throws SQLException {
        String query = String.format("SELECT idEquipment, equipType, size, availability, price FROM  Equipment WHERE idDiving = '%s';", divingCode);
        return stmt.executeQuery(query);
    }



}
