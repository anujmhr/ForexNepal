/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.forexnepal.dao.impl;

import com.forexnepal.dao.ExchangeRatesDAO;
import com.forexnepal.entity.ExchangeRates;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Anuz
 */
@Repository
public class ExchangeRatesDAOImpl implements ExchangeRatesDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<ExchangeRates> getAll() {
        Session session = sessionFactory.openSession();
        return session.createQuery("select e from ExchangeRates e").list();
    }

    @Override
    public ExchangeRates getById(int id) {
        Session session = sessionFactory.openSession();
        return (ExchangeRates) session.get(ExchangeRates.class, id);
    }

    @Override
    public int insertOrUpdate(ExchangeRates e) {
        Session session = sessionFactory.openSession();
        
        Transaction transaction = session.beginTransaction();
        
        session.saveOrUpdate(e);
        //session.save(e);
        transaction.commit();
        return 1;
    }

    @Override
    public int delete(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete((ExchangeRates) session.get(ExchangeRates.class, id));
        transaction.commit();
        return 1;
    }

    @Override
    public ExchangeRates getByName(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
