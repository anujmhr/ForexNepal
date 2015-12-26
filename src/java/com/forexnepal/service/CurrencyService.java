/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.forexnepal.service;

import com.forexnepal.dao.CurrencyDAO;
import com.forexnepal.entity.Currency;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Anuz
 */
@Service
public class CurrencyService {
 @Autowired
    private CurrencyDAO currencyDAO;
    
     public List<Currency> getAll() {
        return currencyDAO.getAll();
    }

    public Currency getById(int id) {
        return currencyDAO.getById(id);
    }
    public Currency getByName(String currency){ //by currency code
        return currencyDAO.getByName(currency);
    }
    public Currency getByCurrency(String currency){ //by currency name
        return currencyDAO.getByCurrency(currency);
    }

    public int insertOrUpdate(Currency c) {
        return currencyDAO.insertOrUpdate(c);
    }

    public int delete(int id) {
        return currencyDAO.delete(id);
    }
        
}
