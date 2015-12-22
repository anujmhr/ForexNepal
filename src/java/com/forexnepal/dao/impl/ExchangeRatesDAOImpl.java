/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.forexnepal.dao.impl;

import com.forexnepal.dao.ExchangeRatesDAO;
import com.forexnepal.entity.Currency;
import com.forexnepal.entity.ExchangeRates;
import java.sql.Date;
import java.sql.Time;
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
public class ExchangeRatesDAOImpl implements ExchangeRatesDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<ExchangeRates> getAll() {
        Session session = sessionFactory.openSession();
        return session.createQuery("SELECT e FROM ExchangeRates e").list();
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

    @Override
    public List<ExchangeRates> getByBank(int bankId) {

        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select e from ExchangeRates e where e.bank.bankId=:bankId");
//        System.out.println("currency"+currency);
        return query.setParameter("bankId", bankId).list();
    }

    @Override
    public List<ExchangeRates> getByCurrency(int currencyId) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select e from ExchangeRates e where e.currency.currencyId=:currencyId");
//        System.out.println("currency"+currency);
        return query.setParameter("currencyId", currencyId).list();
    }

    @Override
    public List<ExchangeRates> getByDate(Date date) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select e from ExchangeRates e where e.forexDate=:date");
//        System.out.println("currency"+currency);
        return query.setParameter("date", date).list();

    }

    @Override
    public List<ExchangeRates> getByTime(Time time) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select e from ExchangeRates e where e.forexTime=:time");
//        System.out.println("currency"+currency);
        return query.setParameter("time", time).list();
    }

    @Override
    public List<Date> getAllDate() {
        Session session = sessionFactory.openSession();
        return session.createQuery("select distinct e.forexDate from ExchangeRates e").list();

    }

    @Override
    public List<Time> getAllTime() {
        Session session = sessionFactory.openSession();
        return session.createQuery("select distinct e.forexTime from ExchangeRates e").list();

    }

    @Override
    public List<ExchangeRates> getByCurrencyDateTime(int currencyId, Date date, Time time) {
        Session session = sessionFactory.openSession();
        
        return session.createQuery("select e from ExchangeRates e where e.currency.currencyId=:currencyId and e.forexDate=:date and e.forexTime=:time")
                .setParameter("currencyId", currencyId)
                .setParameter("date", date)
                .setParameter("time", time)
                .list();
    }

    @Override
    public List<Time> getAllTimeByDate(Date date) {
        Session session = sessionFactory.openSession();
        
        return session.createQuery("select distinct e.forexTime from ExchangeRates e where e.forexDate=:date")
                .setParameter("date", date)
                .list();
    }

}
