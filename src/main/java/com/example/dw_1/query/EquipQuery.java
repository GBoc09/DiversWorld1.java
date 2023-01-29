package com.example.dw_1.query;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EquipQuery extends Query {
    public static ResultSet loadALLEquips (Statement stmt) throws SQLException{
        String query = "SELECT * FROM Equipment";
        return stmt.executeQuery(query);
    }
}
