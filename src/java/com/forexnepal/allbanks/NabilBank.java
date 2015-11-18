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
class NabilBank extends ScrapCommand {

    public NabilBank() {
    }

    @Override
    public void scrap(String args) throws IOException {
        Currency currency;

        Bank bank = bankService.getByName("Nabil Bank Limited");
        System.out.println(bank);

        String URL = "http://www.nabilbank.com/exchange/exchangerate.php";
        // String URL="http://www.rbb.com.np/fxrates.php";
        // String link = "https://play.google.com/store/apps/details";
        String contentPage1, contentPage2, fullLink, regex1, regex2, regex3;
        Pattern pattern1, pattern2, pattern3;
        Matcher matcher1, matcher2, matcher3;

        contentPage1 = readURL(URL);

        regex1 = "<tr class=\"row\" valign=\"top\">(.*?)<td align=\"left\">(.*?)</td>(.*?)<td>(.*?)</td>(.*?)<td>(.*?)</td>(.*?)<td> (.*?)</td>";

        // regex1="&nbsp;&nbsp;(.*?)</b>";//currency name
        //<b>(\d)</b></font unit
        pattern1 = Pattern.compile(regex1);
        matcher1 = pattern1.matcher(contentPage1);
        System.out.println("out");
        while (matcher1.find()) {

            //System.out.println("in");
            System.out.println(matcher1.group(2).trim() + "\t" + "1" + "\t" + matcher1.group(4) + "\t" + matcher1.group(8));
            //System.out.println(matcher1.group(4));
                if (matcher1.group(2).trim().equalsIgnoreCase("")) {
            } else {
                try {   
                    ExchangeRates exchangeRates = new ExchangeRates();

                    currency = currencyService.getByName(matcher1.group(2).trim());

                    exchangeRates.setBankId(bank);
                    exchangeRates.setCurrencyId(currency);
                    exchangeRates.setUnit(1);
                    exchangeRates.setSellingRate(Double.parseDouble(matcher1.group(8).replaceAll("-", "0").trim()));
                    exchangeRates.setBuyingRate(Double.parseDouble(matcher1.group(4).replaceAll("-", "0").trim()));
                    exchangeRates.setForexDate(date);
                    exchangeRates.setForexTime(time);

                    System.out.println(exchangeRates.getCurrencyId() + ":" + exchangeRates.getBuyingRate());

                    exchangeRatesService.insertOrUpdate(exchangeRates);

                } catch (NullPointerException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }

}
