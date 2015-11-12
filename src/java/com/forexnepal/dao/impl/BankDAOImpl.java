/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.forexnepal.dao.impl;

import com.forexnepal.dao.BankDAO;
import com.forexnepal.entity.Bank;
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
public class BankDAOImpl implements BankDAO{
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public List<Bank> getAll() {
        Session session = sessionFactory.openSession();
        return session.createQuery("select b from Bank b").list();

    }

    @Override
    public Bank getById(int id) {
     Session session=sessionFactory.openSession();
        return (Bank)session.get(Bank.class,id);
    }
    

    @Override
    public int insertOrUpdate(Bank b) {
       Session session=sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(b);
        transaction.commit();
        return 1;
    }

    @Override
    public int delete(int id) {
         Session session=sessionFactory.openSession();
                Transaction transaction=session.beginTransaction();
                session.delete((Bank)session.get(Bank.class,id));
                transaction.commit();
                return 1;

    }

     @Override
    public Bank getByName(String bankName) {

        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select b from Bank b where b.bankName=:bankName");
//        System.out.println("currency"+currency);
        return (Bank) query.setParameter("bankName", bankName).uniqueResult();
        
    }
}
