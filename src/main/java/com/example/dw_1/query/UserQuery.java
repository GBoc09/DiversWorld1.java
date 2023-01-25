package com.example.dw_1.query;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserQuery extends Query {
    public String selectUser(String email){
        email = quote(email);
        String query = "SELECT * FROM Diver WHERE email = %s;";
        return String.format(query, email);
    }
    public String insertUser(String email, String password){
        DateFormat format = new SimpleDateFormat(dateFormat);
        //String birthDateString = format.format(birthDate);

        email = quote(email);
        password = quote(password);

        String query = "INSERT INTO user (email, password)" + "VALUES (%s, %s);";
        return String.format(query, email,  password);
    }

   /* public String updateUser(String email, String name, String lastname, String password, Integer license, Date birthDate) {
        DateFormat format = new SimpleDateFormat(dateFormat);
        String birthDateString = "NULL";
        email = quote(email);
        password = quote(password);
        name = quote(name);
        lastname = quote(lastname);

        if (birthDate != null){
            birthDateString = format.format(birthDate);
            birthDateString = quote(birthDateString);
        }
        String query = "update Diver SET" + "password = %s,"+"name = %s," + "lastname = %s,"+ "license = %d,"+ "lastname = %s,"+
                "WHERE email = %s";
        return String.format(query, password, name, lastname, email, birthDateString, license);
    }*/
    public String deleteUser(String email) {
        email = quote (email);
        String query = "DELETE FROM user WHERE email = %s;";
        return String.format(query, email);
    }
}
