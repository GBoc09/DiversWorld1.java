package com.example.dw_1.dao;

import com.example.dw_1.db.MyConnectionSingleton;
import com.example.dw_1.entity.Diving;
import com.example.dw_1.exception.NotFoundDivingException;
import com.example.dw_1.other.DivingCatalogue;
import com.example.dw_1.query.DivingQuery;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DivingDAO {
    private static final String DIVING_ID = "id";
    private static final String DIVING_NAME = "name";
    private static final  String DIVING_MANAGER = "divingManager";
    private static final String DIVING_LOCATION = "location";
    private static final String DIVING_TELEPHONE  =  "telephone";

    private String mangerLicense;
    public DivingCatalogue loadAllDiving(){
        DivingCatalogue divingCatalogue = new DivingCatalogue();
        divingCatalogue.addDiving(new Diving(01, "CrazyHorse","IsolaGiglio", "3478965412"));
        divingCatalogue.addDiving(new Diving(02, "HappyBubbles","IsolaGiannutri", "3462156332"));
        return divingCatalogue;
    }
    MyConnectionSingleton connection = MyConnectionSingleton.getInstance();
    public DivingCatalogue loadAllDivingByManager(String idManager){
        Connection con =connection.getConnection();
        DivingCatalogue divingCatalogue = new DivingCatalogue();
        ArrayList<Diving> divings = new ArrayList<>();
        Diving diving = null;
        try (Statement stmt = con.createStatement();
             ResultSet rs = DivingQuery.loadAllDivingByManager(stmt, idManager)){
            while (rs.next()){
                diving = createDiving(rs);
                divings.add(diving);
            }
        } catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        divingCatalogue.setDivingList(divings);
        return divingCatalogue;
    }

    public  Diving loadDivingByManager(String idManager){
        Connection con =connection.getConnection();
        Diving diving = null;
        try (Statement stmt = con.createStatement();
             ResultSet rs = DivingQuery.loadAllDivingByManager(stmt, idManager)){
            if(rs.isFirst()){
                diving = createDiving(rs);
            }
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        return diving;
    }
    public List<Diving> findDivingByLocation(String location) throws NotFoundDivingException {
        Connection con =connection.getConnection();
        ArrayList<Diving> divings = new ArrayList<>();

        try (Statement stmt = con.createStatement();
             ResultSet rs = DivingQuery.loadDivingByName(stmt, location)){
            if(!rs.first()){
                String message = "Diving not found";
                throw new NotFoundDivingException(message);
            }
            rs.beforeFirst();
            while (rs.next()){
                Diving diving = createDiving(rs);
                divings.add(diving);
            }
        } catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        return divings;
    }

    public Diving findDivingByName (String divingName){
        Connection con =connection.getConnection();
        Diving diving = null;
        try (Statement stmt = con.createStatement();
             ResultSet rs = DivingQuery.selectDivingByName(stmt, divingName)){
            if(rs.first()){
                diving = createDiving(rs);
            }
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        return diving;
    }

    public Diving createDiving(ResultSet rs) throws SQLException {
        Integer id = rs.getInt(DIVING_ID);
        String name = rs.getString(DIVING_NAME);
        String location = rs.getString(DIVING_LOCATION);
        String telephone = rs.getString(DIVING_TELEPHONE);
        return new Diving(id, name, location, telephone);

    }


    public String getMangerLicense() {
        return mangerLicense;
    }

    public void setMangerLicense(String mangerLicense) {
        this.mangerLicense = mangerLicense;
    }
}
