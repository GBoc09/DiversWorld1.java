package com.example.dw_1.applicativo;

import com.example.dw_1.bean.DivingBean;
import com.example.dw_1.bean.UserBean;
import com.example.dw_1.dao.DivingDAO;
import com.example.dw_1.entity.Diving;
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
        divingDAO.setMangerLicense(userBean.getLicense());
        DivingCatalogue divingCatalogue = divingDAO.loadAllDiving();
        List<Diving> divings = divingCatalogue.getDivingList();
        ArrayList<DivingBean> divingBeanArrayList = new ArrayList<>();
        for (Diving diving : divings){
            divingBeanArrayList.add(new DivingBean(diving.getDivingID(),diving.getName(),diving.getLocation(),diving.getTelephone()));
        }
        return divingBeanArrayList;
    }
}
