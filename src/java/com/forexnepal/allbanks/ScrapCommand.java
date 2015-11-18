/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.forexnepal.allbanks;

import com.forexnepal.service.BankService;
import com.forexnepal.service.CurrencyService;
import com.forexnepal.service.ExchangeRatesService;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Anuz
 */
public abstract class ScrapCommand {

    protected CurrencyService currencyService;
    protected BankService bankService;
    protected ExchangeRatesService exchangeRatesService;
    protected Date date;
    protected Time time;

    public String readURL(String link) throws MalformedURLException, IOException {
        try{
        URL url = new URL(link);

        StringBuilder builder;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
            String line = "";
            builder = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
        }
        return builder.toString();
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public abstract void scrap(String args) throws IOException;

    public void setService(CurrencyService currencyService, BankService bankService, ExchangeRatesService exchangeRatesService, Date date, Time time) {
        this.currencyService = currencyService;
        this.bankService = bankService;
        this.exchangeRatesService = exchangeRatesService;
        this.date = date;
        this.time = time;

    }

}
