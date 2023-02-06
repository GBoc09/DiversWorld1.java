package com.example.dw_1.query;

import java.sql.SQLException;
import java.sql.Statement;

public class EquipQuery extends Query {
    public static boolean insertEquip(Statement stmt,String id, String diving, String type) throws SQLException{
        String query = String.format("INSERT INTO Equipment values('%s', '%s', '%s');", id, diving, type);
        return stmt.execute(query);
    }
    public static boolean insertIntoReg(Statement stmt, String desc, Double price,String avail, String equipID) throws SQLException{
        String query = String.format("INSERT INTO Regulator values('%s', '%f', '%s', '%s');", desc, price, avail, equipID);
        return stmt.execute(query);
    }
    public static boolean insertIntoMask(Statement stmt, String desc, Double price,String avail,String equipID) throws SQLException{
        String query = String.format("INSERT INTO Mask values('%s', '%f', '%s', '%s');", desc, price, avail, equipID);
        return stmt.execute(query);
    }
    public static boolean insertIntoJack(Statement stmt, String desc, String size, String avail,Double price, String equipID) throws SQLException{
        String query = String.format("INSERT INTO Jacket values('%s', '%s', '%s', '%f', '%s');", desc,size,avail, price, equipID);
        return stmt.execute(query);
    }
    public static boolean insertIntoSuit(Statement stmt, String desc,String size, String avail, Double price, String equipID) throws SQLException{
        String query = String.format("INSERT INTO Suit values('%s', '%s', '%s', '%f', '%s');", desc, size, avail, price, equipID);
        return stmt.execute(query);
    }
    public static boolean insertIntoFinns(Statement stmt, String desc, String size, String avail, Double price, String equipID) throws SQLException{
        String query = String.format("INSERT INTO Finns values('%s', '%s', '%s', '%f', '%s');", desc, size,avail, price, equipID);
        return stmt.execute(query);
    }

}
