/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.forexnepal.dao.impl;

import com.forexnepal.dao.ExchangeRatesDAO;
import com.forexnepal.entity.Bank;
import com.forexnepal.entity.Currency;
import com.forexnepal.entity.ExchangeRates;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
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
        List<ExchangeRates> getAllExchangeRate = session.createQuery("SELECT e FROM ExchangeRates e").list();
        session.close();
        return getAllExchangeRate;
    }

    @Override
    public ExchangeRates getById(int id) {
        Session session = sessionFactory.openSession();
        ExchangeRates exchangeRateById = (ExchangeRates) session.get(ExchangeRates.class, id);
        session.close();
        return exchangeRateById;
    }

    @Override
    public int insertOrUpdate(ExchangeRates e) {
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        session.saveOrUpdate(e);
        //session.save(e);
        transaction.commit();
        session.close();
        return 1;
    }

    @Override
    public int delete(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete((ExchangeRates) session.get(ExchangeRates.class, id));
        transaction.commit();
        session.close();
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
        List<ExchangeRates> exchangeRateByBank = query.setParameter("bankId", bankId).list();
//        System.out.println("currency"+currency);
        return exchangeRateByBank;
    }

    @Override
    public List<ExchangeRates> getByCurrency(int currencyId) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select e from ExchangeRates e where e.currency.currencyId=:currencyId");
        List<ExchangeRates> exchangeRateByCurrency = query.setParameter("currencyId", currencyId).list();
        session.close();
        return exchangeRateByCurrency;
    }

    @Override
    public List<ExchangeRates> getByDate(Date date) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select e from ExchangeRates e where e.forexDate=:date");
        List<ExchangeRates> exchangeRateByDate = query.setParameter("date", date).list();
        session.close();
        return exchangeRateByDate;

    }

    @Override
    public List<ExchangeRates> getByTime(Time time) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select e from ExchangeRates e where e.forexTime=:time");
        List<ExchangeRates> exchangeRateByTime = query.setParameter("time", time).list();
        session.close();
        return exchangeRateByTime;
    }

    @Override
    public List<Date> getAllDate() {
        Session session = sessionFactory.openSession();
        List<Date> allDate = session.createQuery("select distinct e.forexDate from ExchangeRates e").list();
        session.close();
        return allDate;
    }

    @Override
    public List<Time> getAllTime() {
        Session session = sessionFactory.openSession();
        List<Time> allTime
                = session.createQuery("select distinct e.forexTime from ExchangeRates e").list();
        session.close();
        return allTime;
    }

    @Override
    public List<ExchangeRates> getByCurrencyDateTime(int currencyId, Date date, Time time) {
        Session session = sessionFactory.openSession();

        List<ExchangeRates> byCurrencyDateTime = session.createQuery("select e from ExchangeRates e where e.currency.currencyId=:currencyId and e.forexDate=:date and e.forexTime=:time")
                .setParameter("currencyId", currencyId)
                .setParameter("date", date)
                .setParameter("time", time)
                .list();
        session.close();
        return byCurrencyDateTime;
    }

    @Override
    public List<ExchangeRates> getByBankDateTime(int bankId, Date date, Time time) {
        Session session = sessionFactory.openSession();

        List<ExchangeRates> byBankDateTime = session.createQuery("select e from ExchangeRates e where e.bank.bankId=:bankId and e.forexDate=:date and e.forexTime=:time")
                .setParameter("bankId", bankId)
                .setParameter("date", date)
                .setParameter("time", time)
                .list();
        session.close();
        return byBankDateTime;

    }

    @Override
    public List<Time> getAllTimeByDate(Date date) {
        Session session = sessionFactory.openSession();

        List<Time> timeByDate = session.createQuery("select distinct e.forexTime from ExchangeRates e where e.forexDate=:date")
                .setParameter("date", date)
                .list();
        session.close();
        return timeByDate;
    }

    @Override
    public List<Currency> getCurrencyList() {
        Session session = sessionFactory.openSession();
        List<Currency> currencyList
                = session.createQuery("select distinct e.currency from ExchangeRates e").list();
        session.close();
        return currencyList;

    }

    @Override
    public List<Bank> getBankList() {
        Session session = sessionFactory.openSession();

        List<Bank> bankList = session.createQuery("select distinct e.bank from ExchangeRates e").list();
        session.close();
        return bankList;
    }

    @Override
    public Date getLatestDate() {
        Session session = sessionFactory.openSession();

        Date latestDate = (Date) session.createQuery("select distinct e.forexDate from ExchangeRates e order by e.forexDate desc").setMaxResults(1).uniqueResult();
        session.close();
        return latestDate;
    }

    @Override
    public Time getLatestTime(Date date) {
        Session session = sessionFactory.openSession();

        Time latestTime = (Time) session.createQuery("select distinct e.forexTime from ExchangeRates e where e.forexDate=:date order by e.forexTime desc")
                .setParameter("date", date)
                .setMaxResults(1).uniqueResult();
        session.close();
        return latestTime;

    }
    
    @Override
    public List<ExchangeRates> getExchangeRatesByDateTime(Date date,Time time) {
        Session session = sessionFactory.openSession();

         List<ExchangeRates>  exchangeRateByDateTime = session.createQuery("select e from ExchangeRates e where e.forexDate=:date and e.forexTime=:time")
                .setParameter("date", date)
                .setParameter("time",time)
                .list();
        session.close();
        return exchangeRateByDateTime;

    }

    @Override
    public List<ExchangeRates> getExchangeRatesByCurrencyBank(int currencyId, int bankId) {
      Session session = sessionFactory.openSession();

        List<ExchangeRates> byCurrencyBank = (List<ExchangeRates>) (ExchangeRates) session.createQuery("select e from ExchangeRates e where e.currency.currencyId=:currencyId and e.bank.bankId=:bankId order by e.forexDate desc")
                .setParameter("currencyId",currencyId)
                .setParameter("bankId",bankId)
                .setMaxResults(10).list();
        session.close();
        return byCurrencyBank;

    }

}
