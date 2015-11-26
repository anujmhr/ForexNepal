/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.forexnepal.allbanks;

import com.forexnepal.entity.Bank;
import com.forexnepal.entity.Currency;
import com.forexnepal.entity.ExchangeRates;
import com.forexnepal.service.CurrencyService;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Anuz
 */
class MachhapuchchhreBank extends ScrapCommand {

    public MachhapuchchhreBank() {
    }

    @Override
    public void scrap(String args) throws IOException {
        Currency currency;
        Bank bank = bankService.getByName("Machhapuchre Bank Limited");
        System.out.println(bank.getBankName());

        String URL = "http://www.machbank.com/content/forex-detail.html";
        String contentPage1, contentPage2, fullLink, regex1, regex2, regex3;
        Pattern pattern1, pattern2, pattern3;
        Matcher matcher1, matcher2, matcher3;

        contentPage1 = readURL(URL);

        regex1 = "<tr class=\"(.*?)\">(.*?)<td style=\"text-align:left\">(.*?)</td>(.*?)<td align=\"center\">(.*?)</td>(.*?)<td align=\"center\">(.*?)</td>(.*?)<td align=\"center\">(.*?)</td>(.*?)<td align=\"center\">(.*?)</td>(.*?)</tr>";

        pattern1 = Pattern.compile(regex1);
        matcher1 = pattern1.matcher(contentPage1);
        
        while (matcher1.find()) {
            //System.out.println("in");
            System.out.println(matcher1.group(3).trim() + "\t" + matcher1.group(5) + "\t" + matcher1.group(7) + "\t" + matcher1.group(11));//Rastrabank
            //System.out.println(matcher1.group(4));
            try {
                ExchangeRates exchangeRates = new ExchangeRates();
                currency = currencyService.getByName(matcher1.group(3).trim());

                exchangeRates.setBank(bank);
                exchangeRates.setCurrency(currency);
                exchangeRates.setUnit(Integer.parseInt(matcher1.group(5).trim()));
                exchangeRates.setBuyingRate(Double.parseDouble(matcher1.group(7).trim()));
                exchangeRates.setSellingRate(Double.parseDouble(matcher1.group(11).trim()));
                exchangeRates.setForexDate(date);
                exchangeRates.setForexTime(time);
               // System.out.println(exchangeRates.getCurrency() + ":" + exchangeRates.getBuyingRate());
                exchangeRatesService.insertOrUpdate(exchangeRates);

            } catch (NullPointerException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

}
