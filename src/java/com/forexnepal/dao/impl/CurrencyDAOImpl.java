/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.forexnepal.dao.impl;

import com.forexnepal.dao.CurrencyDAO;
import com.forexnepal.entity.Currency;
import java.util.List;
import org.hibernate.Query;
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
public class CurrencyDAOImpl implements CurrencyDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Currency> getAll() {
        Session session = sessionFactory.openSession();
        return session.createQuery("select c from Currency c").list();
    }

    @Override
    public Currency getById(int id) {
        Session session = sessionFactory.openSession();
        return (Currency) session.get(Currency.class, id);

    }

    @Override
    public Currency getByName(String currency) {

        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select c from Currency c where c.currencyCode=:currency");
//        System.out.println("currency"+currency);
        return (Currency) query.setParameter("currency", currency).uniqueResult();
        
    }

    @Override
    public int insertOrUpdate(Currency c) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(c);
        transaction.commit();
        return 1;
    }

    @Override
    public int delete(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete((Currency) session.get(Currency.class, id));
        transaction.commit();
        return 1;

    }

}
