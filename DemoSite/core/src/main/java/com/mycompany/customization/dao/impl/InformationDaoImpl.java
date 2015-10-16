package com.mycompany.customization.dao.impl;

import com.mycompany.customization.Information;
import com.mycompany.customization.dao.InformationDao;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ayushyadevmurari on 10/15/15.
 */
@Repository("informationDao")
public class InformationDaoImpl implements InformationDao {

    @PersistenceContext(unitName = "blPU")
    private EntityManager entityManager;


    @Override
    public void saveInformation(Information information) {
        entityManager.getTransaction().begin();
        entityManager.persist(information);
        entityManager.getTransaction().commit();
    }

    @Override
    public Information updateInformation(Information information) {
        entityManager.getTransaction().begin();
        Information info = entityManager.merge(information);
        entityManager.getTransaction().commit();
        return info;
    }

    @Override
    public void deleteInformation(Information information) {
        entityManager.getTransaction().begin();
        entityManager.remove(information);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Information> getAll() {
        Query query = entityManager.createQuery("SELECT I FROM InformationImpl I");
        return query.getResultList();
    }
}
