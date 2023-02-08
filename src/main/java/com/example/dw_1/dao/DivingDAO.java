package com.example.dw_1.dao;

import com.example.dw_1.db.MyConnectionSingleton;
import com.example.dw_1.entity.Diving;
import com.example.dw_1.exception.AlreadyRegisteredDiving;
import com.example.dw_1.query.DivingQuery;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DivingDAO {
    MyConnectionSingleton connection = MyConnectionSingleton.getInstance();
    public void insertDiving(Diving diving) throws AlreadyRegisteredDiving {
        Connection con =connection.getConnection();
        try(Statement stmt = con.createStatement();){
            DivingQuery.insertDiving(stmt, diving.getDivingID(), diving.getName(), diving.getDivingMan(), diving.getLocation(), diving.getTelephone());
        } catch (SQLIntegrityConstraintViolationException e){
            throw new AlreadyRegisteredDiving(1);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    /* ritorna il codice */
    public String takeDvingCode (String divingName){
        Connection con = connection.getConnection();
        String code = null;
        try (Statement stmt = con.createStatement();
        ResultSet rs = DivingQuery.selectDivingCode(stmt, divingName)){
            while(rs.next()){
                code = rs.getString("idDiving");
            }
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        return code;
    }

    /** FUNZIONA serve per cercare il diving dalla parte del client */
    public String findDivingByName (String divingName){
        Connection con =connection.getConnection();
        String  nome = null;
        try (Statement stmt = con.createStatement();
             ResultSet rs = DivingQuery.selectDivingByName(stmt, divingName)){
            if(rs.next()){
                nome = rs.getString("name");
            }
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        return nome;
    }

    /** List<Diving> getInfo  FUNZIONA*/
    public List<Diving> getInfo(){
        Connection con = connection.getConnection();
        List<Diving> divs = new ArrayList<>();
        try(Statement stmt = con.createStatement();
            ResultSet rs = DivingQuery.selectDiving(stmt)){
            while (rs. next()){
                Diving newDiv = new Diving();
                newDiv.setDivingID(rs.getString(1));
                newDiv.setName(rs.getString(2)) ;
                newDiv.setDivingMan(rs.getString(3));
                newDiv.setLocation(rs.getString(4)) ;
                newDiv.setTelephone(rs.getString(5));
                divs.add(newDiv);
            }
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        return divs;
    }
}
