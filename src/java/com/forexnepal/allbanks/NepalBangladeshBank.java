/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.forexnepal.allbanks;

import com.forexnepal.entity.Bank;
import com.forexnepal.entity.Currency;
import com.forexnepal.entity.ExchangeRates;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Anuz
 */
class NepalBangladeshBank extends ScrapCommand {

    public NepalBangladeshBank() {
    }

    @Override
    public void scrap(String args) throws IOException {
        Currency currency;
        Bank bank=bankService.getByName("Nepal Bangladesh Bank Limited");
        
        String URL = "http://www.nbbl.com.np/foreign_exchange_rate";
       // String URL="http://www.rbb.com.np/fxrates.php";
        // String link = "https://play.google.com/store/apps/details";
        String contentPage1, contentPage2, fullLink, regex1, regex2, regex3;
        Pattern pattern1, pattern2, pattern3;
        Matcher matcher1, matcher2, matcher3;

        contentPage1 = readURL(URL);

        regex1 = "<tr class=\"row0\"><td align=\"center\">(.*?)</td><td align=\"center\">(.*?)</td><td align=\"center\">(.*?)</td><td align=\"center\">(.*?)</td><td align=\"center\">(.*?)</td></tr>";

       // regex1="&nbsp;&nbsp;(.*?)</b>";//currency name
        //<b>(\d)</b></font unit
        pattern1 = Pattern.compile(regex1);
        matcher1 = pattern1.matcher(contentPage1);
        System.out.println("out");
        while (matcher1.find()) {
            
            //System.out.println(matcher1.group(2).trim() + "\t1\t" + matcher1.group(3) + "\t" + matcher1.group(5));
            
            
            if (matcher1.group(2).trim().equalsIgnoreCase("")) {
            } else {

                try {
                    ExchangeRates exchangeRates = new ExchangeRates();

                    currency = currencyService.getByName(matcher1.group(2).trim());

                    exchangeRates.setBank(bank);
                    exchangeRates.setCurrency(currency);
                    exchangeRates.setUnit(1);
                    exchangeRates.setBuyingRate(Double.parseDouble(  ("".equals(matcher1.group(3).trim()))?"0" :matcher1.group(3).trim()));
                    exchangeRates.setSellingRate(Double.parseDouble( ("".equals(matcher1.group(5).trim()))?"0" :matcher1.group(5).trim()));
                    exchangeRates.setForexDate(date);
                    exchangeRates.setForexTime(time);

//                    System.out.println(exchangeRates.getCurrency() + ":" + exchangeRates.getBuyingRate());

                    exchangeRatesService.insertOrUpdate(exchangeRates);

                } catch (NullPointerException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }

}
