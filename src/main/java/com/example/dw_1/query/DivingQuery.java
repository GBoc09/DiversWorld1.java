package com.example.dw_1.query;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DivingQuery {
    public static ResultSet loadAllDiving (Statement stmt, String divingManager) throws SQLException {
        String query = String.format("SELECT * FORM Diving WHERE divingManager = '%s';",divingManager );
        return stmt.executeQuery(query);
    }
}
