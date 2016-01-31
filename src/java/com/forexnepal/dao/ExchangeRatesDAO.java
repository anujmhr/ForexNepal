/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.forexnepal.dao;

import com.forexnepal.entity.Bank;
import com.forexnepal.entity.Currency;
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
     List<Date> getAllDate();
     List<Time> getAllTime();
     List<ExchangeRates> getByCurrencyDateTime(int currencyId,Date date, Time time);
      List<ExchangeRates> getByBankDateTime(int bankId,Date date, Time time);
     List<Time> getAllTimeByDate(Date date);
     List<Currency> getCurrencyList();
     List<Bank> getBankList();
     Date getLatestDate();
      Time getLatestTime(Date date);
      List<ExchangeRates> getExchangeRatesByDateTime(Date date,Time time);
      List<ExchangeRates> getExchangeRatesByCurrencyBank(int currencyId, int bankId);
}
