package com.mycompany.customization.dao;

import com.mycompany.customization.Information;

import java.util.List;

/**
 * Created by ayushyadevmurari on 10/15/15.
 */
public interface InformationDao {

    void saveInformation(Information information);

    Information updateInformation(Information information);

    void deleteInformation(Information information);

    List<Information> getAll();
}
