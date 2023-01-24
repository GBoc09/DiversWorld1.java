package com.example.dw_1.dao;

import com.example.dw_1.db.MyConnectionSingleton;
import com.example.dw_1.entity.User;
import com.example.dw_1.exception.AlreadyRegisteredUserException;
import com.example.dw_1.exception.WrongLoginCredentialException;
import com.example.dw_1.query.UserQuery;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class UserDAO {

    MyConnectionSingleton connection = MyConnectionSingleton.getInstance();
    UserQuery userQ = new UserQuery();
    public User selectUser(String email){
        User user = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Connection con = connection.getConnection();
            stmt = con.createStatement();
            String query = userQ.selectUser(email);
            rs = stmt.executeQuery(query);

            if (!rs.next()){
                return null;
            }
            user = new User(rs.getString("email"), rs.getString("name"), rs.getString("lastname"), rs.getString("password"),rs.getInt("license"));
            user.setBirthDate(rs.getDate("birthDate"));

            rs.close();
        } catch (SQLException e ){
            e.printStackTrace();
        } finally {
            try {
                if(stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
    }
    public User selectLoginUser(String email) throws WrongLoginCredentialException {
        User user = selectUser(email);
        if (user == null) {
            throw new WrongLoginCredentialException(1);
        } else {
            return user;
        }
    }

    public void insertUser(User user) throws AlreadyRegisteredUserException {
        String query = selectQuery(user, "insert");
        if (selectUser(user.getEmail())!= null) {
            throw new AlreadyRegisteredUserException(1);
        }
        try {
            writeOnUser(query);
        }catch (SQLException e){}
    }
    public void updateUser(User user){
        String query = selectQuery(user, "update");
        try {
            writeOnUser(query);
        }catch (SQLException e){
        }

    }

    private void writeOnUser(String query) throws SQLException{
        Statement stmt = null;
        try {
            Connection con = connection.getConnection();
            stmt = con.createStatement();
            stmt.executeUpdate(query);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public String selectQuery (User user, String queryType) {
        String email = user.getEmail();
        String password = user.getPassword();
        String name = user.getName();
        String lastname = user.getLastname();
        Integer license = user.getLicense();
        Date birthDate = user.getBirthDate();

        String query = null;
        if (queryType.equals("insert")) {
            query = userQ.insertUser(email, password, name, lastname, license, birthDate);
        }
        return query;
    }

    public void deleteUser(String email){
        Statement stmt = null;
        try {
            Connection con = connection.getConnection();
            stmt = con.createStatement();
            String query = userQ.deleteUser(email);
            stmt.executeUpdate(query);
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null){
                    stmt.close();
                }
            }catch (SQLException e){
                e.printStackTrace();;
            }
        }
    }
}
