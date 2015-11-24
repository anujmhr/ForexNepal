/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.forexnepal.dao;

import com.forexnepal.entity.ExchangeRates;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

/**
 *
 * @author Anuz
 */
public interface ExchangeRatesDAO extends GenericDAO<ExchangeRates>{
 
     List<ExchangeRates> getByBank(int bankId);
     List<ExchangeRates> getByCurrency(int currencyId);
     List<ExchangeRates> getByDate(Date date);
     List<ExchangeRates> getByTime(Time time);
     
     
     
     
}
