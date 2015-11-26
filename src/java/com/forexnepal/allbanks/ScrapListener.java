/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.forexnepal.allbanks;

import com.forexnepal.service.BankService;
import com.forexnepal.service.CurrencyService;
import com.forexnepal.service.ExchangeRatesService;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author anuz
 */
public class ScrapListener extends Thread {

    private CurrencyService currencyService;
    private BankService bankService;
    private ExchangeRatesService exchangeRatesService;
    private Date date;
    private Time time;
    private String scrapChoice;

    public ScrapListener(CurrencyService currencyService, BankService bankService, ExchangeRatesService exchangeRatesService, Date date, Time time,String scrapChoice) {
        this.currencyService = currencyService;
        this.bankService = bankService;
        this.exchangeRatesService = exchangeRatesService;
        this.date = date;
        this.time = time;
        this.scrapChoice=scrapChoice;
    }
    
    
    @Override
    public void run() {
        
        try {
            ScrapData scrapData = new ScrapData(currencyService, bankService, exchangeRatesService,date, time);
            scrapData.scrapChoice(scrapChoice);
        } catch (IOException ex) {
            Logger.getLogger(ScrapListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
