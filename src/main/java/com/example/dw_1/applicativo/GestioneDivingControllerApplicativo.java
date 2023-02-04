package com.example.dw_1.applicativo;

import com.example.dw_1.bean.DivingBean;
import com.example.dw_1.bean.LoginBean;
import com.example.dw_1.bean.UserBean;
import com.example.dw_1.dao.DivingDAO;
import com.example.dw_1.dao.UserDAO;
import com.example.dw_1.entity.Diving;
import com.example.dw_1.exception.NotExistantException;
import com.example.dw_1.other.DivingCatalogue;

import java.util.ArrayList;
import java.util.List;

public class GestioneDivingControllerApplicativo {
    private UserBean userBean;
    public void setUserBean(UserBean userBean){
        this.userBean = userBean;
    }
    public List<DivingBean>getAllDiving(){
        DivingDAO divingDAO = new DivingDAO();
        divingDAO.setManEmail(userBean.getUserEmail());

        DivingCatalogue divingCatalogue = divingDAO.loadAllDiving();
        List<Diving> divings = divingCatalogue.getDivingList();

        ArrayList<DivingBean> divingBeanArrayList = new ArrayList<>();

        for (Diving diving : divings){
            divingBeanArrayList.add(new DivingBean(diving.getDivingID(),diving.getName(),diving.getLocation(),diving.getTelephone()));
        }
        return divingBeanArrayList;
    }
    public DivingBean verifyDiving(DivingBean divingBean) throws NotExistantException {
        DivingDAO divingDAO = new DivingDAO();
        String diving = divingDAO.findDivingByName(divingBean.getDivingName());
        return new DivingBean(diving, divingBean.getLocation());
    }
}
