package com.mycompany.customization.service.impl;

import com.mycompany.customization.Information;
import com.mycompany.customization.dao.InformationDao;
import com.mycompany.customization.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ayushyadevmurari on 10/15/15.
 */
@Service("informationService")
public class InformationServiceImpl implements InformationService {

    @Resource(name = "informationDao")
    private InformationDao informationDao;


    @Override
    public void saveInformation(Information information) {
        informationDao.saveInformation(information);
    }

    @Override
    public Information updateInformation(Information information) {
        return informationDao.updateInformation(information);
    }

    @Override
    public void deleteInformation(Information information) {
        informationDao.deleteInformation(information);
    }

    @Override
    public List<Information> getAll() {
        return informationDao.getAll();
    }


}
