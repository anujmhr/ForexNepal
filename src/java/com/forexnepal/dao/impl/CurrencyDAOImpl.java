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
        List<Currency> allCurrency = session.createQuery("select c from Currency c").list();
        session.close();
        return allCurrency;

    }

    @Override
    public Currency getById(int id) {
        Session session = sessionFactory.openSession();
        Currency currencyById = (Currency) session.get(Currency.class, id);
        session.close();
        return currencyById;

    }

    @Override
    public Currency getByName(String currency) {

        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select c from Currency c where c.currencyCode=:currency");
        Currency currencyByName = (Currency) query.setParameter("currency", currency).uniqueResult();
        session.close();
        return currencyByName;
    }

    @Override
    public Currency getByCurrency(String currency) {

        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select c from Currency c where lower(c.currencyName) like:currency");
        Currency currencyByCurrency= (Currency) query.setParameter("currency", currency.toLowerCase()).uniqueResult();
        session.close();
        return currencyByCurrency;
    }

    @Override
    public int insertOrUpdate(Currency c) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(c);
        transaction.commit();
        session.close();
        return 1;
    }

    @Override
    public int delete(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete((Currency) session.get(Currency.class, id));
        transaction.commit();
        session.close();
        return 1;

    }

}
