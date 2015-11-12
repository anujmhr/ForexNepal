/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.forexnepal.service;

import com.forexnepal.dao.ExchangeRatesDAO;
import com.forexnepal.entity.ExchangeRates;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Anuz
 */
@Service
public class ExchangeRatesService {

    @Autowired
    private ExchangeRatesDAO exchangeRatesDAO;

    public List<ExchangeRates> getAll() {
        return exchangeRatesDAO.getAll();
    }

    public ExchangeRates getById(int id) {
        return exchangeRatesDAO.getById(id);
    }

    public int insertOrUpdate(ExchangeRates e) {
        return exchangeRatesDAO.insertOrUpdate(e);
    }

    public int delete(int id) {
        return exchangeRatesDAO.delete(id);
    }

}
