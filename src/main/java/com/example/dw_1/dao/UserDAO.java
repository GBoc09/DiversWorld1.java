package com.example.dw_1.dao;

import com.example.dw_1.db.MyConnectionSingleton;
import com.example.dw_1.exception.NotExistantException;
import com.example.dw_1.query.UserQuery;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;


public class UserDAO {
    private static final String SCUBA_ENUM_TYPE = "scuba";
    private static final String FREE_ENUM_TYPE = "free";
    private static final String MANAGER_ENUM_TYPE = "manager";
    private static final String USER_TYPE = "type";
    private static final Integer SCUBA_TYPE = 0;
    private static final Integer FREE_TYPE = 1;
    private static final Integer MANAGER_TYPE = 2;
    MyConnectionSingleton connection = MyConnectionSingleton.getInstance();

    public Integer selectUser(String userEmail, String userPass) throws NotExistantException {
        Connection con = connection.getConnection();
        Integer userType = -1;
        try (Statement stmt = con.createStatement();
             ResultSet rs = UserQuery.selectUserByCredentials(stmt, userEmail, userPass)) {
            if (rs.next()) {
                String userEnum = rs.getString(USER_TYPE);
                if (userEnum.compareTo(SCUBA_ENUM_TYPE) == 0) {
                    userType = SCUBA_TYPE;
                } else if (userEnum.compareTo(FREE_ENUM_TYPE) == 0) {
                    userType = FREE_TYPE;

                } else if (userEnum.compareTo(MANAGER_ENUM_TYPE) == 0) {
                    userType = MANAGER_TYPE;

                }
            } else {
                throw new NotExistantException("User does not exist");
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return userType;
    }

    public String selectUserEmail(String userEmail) throws NotExistantException {
        Connection con = connection.getConnection();
        String user = null;
        try (Statement stmt = con.createStatement();
             ResultSet rs = UserQuery.selectScubaByEmail(stmt, userEmail)) {
            if (rs.next()) {
                String diver = rs.getString("email");
                if (diver.equals(userEmail)) {
                    user = diver;
                }
            } else {
                throw new NotExistantException("email not found");
            }
        } catch (SQLException | NotExistantException sqlException) {
            sqlException.printStackTrace();
        }

        return user;
    }

    public String selectLicense(String manager) {
        Connection con = connection.getConnection();
        String manId = null;
        try (Statement stmt = con.createStatement();
             ResultSet rs = UserQuery.selectManager(stmt, manager);) {
            if (rs.next()) {
                String man = rs.getString("idDivingManager");
                if (man.equals(manager)) {
                    manId = man;
                }
            } else {
                throw new NotExistantException("Manager not found");
            }
        } catch (SQLException | NotExistantException sqlException) {
            sqlException.printStackTrace();
        }
        return manId;
    }

    /**
     * prova connessione al db per prendere dati
     * FUNZIONA
     */
    public List<String> datiUtenti() {
        Connection con = connection.getConnection();
        String email = null;
        String name = null;
        String lastname = null;
        String license = null;
        try (Statement stmt = con.createStatement();
             ResultSet rs = UserQuery.selectScubaByEmail(stmt)) {
            while (rs.next()) {
                email = rs.getString("email");
                name = rs.getString("name");
                lastname = rs.getString("surname");
                license = rs.getString("licenseNumber");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Arrays.asList(email, name, lastname, license);
    }
}