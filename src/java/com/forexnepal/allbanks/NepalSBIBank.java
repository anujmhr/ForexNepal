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
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Anuz
 */
class NepalSBIBank extends ScrapCommand {

    public NepalSBIBank() {
    }

    @Override
    public void scrap(String args) throws IOException {
        
         Currency currency;
        Bank bank=bankService.getByName("Nepal SBI Bank Limited");
        
         DecimalFormat df=new DecimalFormat("#.####");

        String URL="http://nepalsbi.com.np/content/foreign-exchange-rates.cfm";
       // String URL="http://www.rbb.com.np/fxrates.php";
       // String link = "https://play.google.com/store/apps/details";
        String contentPage1, contentPage2, fullLink, regex1, regex2, regex3;
        Pattern pattern1, pattern2, pattern3;
        Matcher matcher1, matcher2, matcher3;

        
        
        contentPage1 = readURL(URL);

        regex1 = "<tr>(.*?)<td style=\"text-align:left\">(.*?)</td>(.*?)<td>(.*?)</td>(.*?)<td>(.*?)</td>(.*?)<td>(.*?)</td>(.*?)<td>(.*?)</td>(.*?)</tr>";

       // regex1="&nbsp;&nbsp;(.*?)</b>";//currency name
        //<b>(\d)</b></font unit
        
        pattern1 = Pattern.compile(regex1);
        matcher1 = pattern1.matcher(contentPage1);
      //  System.out.println("out");
        while (matcher1.find()) {
            //System.out.println("in");
            System.out.println(matcher1.group(2).trim()+"\t"+matcher1.group(4)+"\t"+matcher1.group(6)+"\t"+matcher1.group(10));
            //System.out.println(matcher1.group(4));
           try{
            ExchangeRates exchangeRates=new ExchangeRates();
            currency=currencyService.getByCurrency(matcher1.group(2).replaceAll("[^\\w/\\s/i]","").trim());
                //System.out.println(currency);
            
                if (currency != null) {
                    int unit = Integer.parseInt(matcher1.group(4).trim());
                    Double sellingRate =((Double.parseDouble(matcher1.group(10).replaceAll("-", "0").trim())) / unit);
                    Double buyingRate = ((Double.parseDouble(matcher1.group(6).replaceAll("-", "0").trim())) / unit);

                    exchangeRates.setBank(bank);
                    exchangeRates.setCurrency(currency);
                    exchangeRates.setUnit(1);
                    exchangeRates.setSellingRate(Double.parseDouble(df.format(sellingRate)));
                    exchangeRates.setBuyingRate(Double.parseDouble(df.format(buyingRate)));
                    exchangeRates.setForexDate(date);

                    exchangeRates.setForexTime(time);
                    
                   // System.out.println(Double.parseDouble(df.format(sellingRate))+"-- "+Double.parseDouble(df.format(buyingRate)));
                    exchangeRatesService.insertOrUpdate(exchangeRates);
                }
           
               // System.out.println(exchangeRates.toString());
            
             

            
            }catch(NullPointerException | NumberFormatException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
    
}
