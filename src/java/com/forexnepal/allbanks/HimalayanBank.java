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
import org.springframework.transaction.annotation.Transactional;
//import org.springframework.beans.factory.annotation.Autowired;


/**
 *
 * @author Anuz
 */
@Transactional
class HimalayanBank extends ScrapCommand { 

    
    
   


    public HimalayanBank() {
        
    }

    @Override
    public void scrap(String args) throws IOException {
        Currency currency;
        
        Bank bank=bankService.getByName("Himalayan Bank Limited");
        
        
        String URL="http://www.himalayanbank.com/forex";
        String contentPage1, contentPage2, fullLink, regex1, regex2, regex3;
        Pattern pattern1, pattern2, pattern3;
        Matcher matcher1, matcher2, matcher3;

        
        
        contentPage1 = readURL(URL);

        regex1 = "<td>(.*?)</td>(.*?)<td>(.*?)</td>(.*?)<td align=\"right\">(.*?)</td>(.*?)<td align=\"right\">(.*?)</td>(.*?)<td align=\"right\">(.*?)</td>";

       // regex1="&nbsp;&nbsp;(.*?)</b>";//currency name
        //<b>(\d)</b></font unit
        
        pattern1 = Pattern.compile(regex1);
        matcher1 = pattern1.matcher(contentPage1);
        System.out.println("out");
        while (matcher1.find()) {
            //System.out.println("in");
            
            System.out.println(matcher1.group(1).trim()+"\t"+matcher1.group(3)+"\t"+matcher1.group(5)+"\t"+matcher1.group(9));
            //System.out.println(matcher1.group(4));
            
           
           
            //System.out.println(currencyService.getByName("USD"));
            try{
                 ExchangeRates exchangeRates=new ExchangeRates();
            currency=currencyService.getByName(matcher1.group(1).trim());
            
            exchangeRates.setBank(bank);
            exchangeRates.setCurrency(currency);
            exchangeRates.setUnit(Integer.parseInt(matcher1.group(3).replaceAll("-","0").trim()));
            exchangeRates.setSellingRate(Double.parseDouble(matcher1.group(9).replaceAll("-", "0").trim()));    
            exchangeRates.setBuyingRate(Double.parseDouble(matcher1.group(5).replaceAll("-", "0").trim()));
            exchangeRates.setForexDate(date);
            
            exchangeRates.setForexTime(time);
           
                System.out.println(exchangeRates.getCurrency()+":"+exchangeRates.getBuyingRate());
            
             
                exchangeRatesService.insertOrUpdate(exchangeRates);
            
            }catch(NullPointerException | NumberFormatException ex){
                System.out.println(ex.getMessage());
            }
                
        }
    }
    
    
}
