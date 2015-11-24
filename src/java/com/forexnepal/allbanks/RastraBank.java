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
class RastraBank extends ScrapCommand {
   
    public RastraBank() {
    }

    @Override
    public void scrap(String args) throws IOException {
        
        Currency currency;
        Bank bank=bankService.getByName("Nepal Rastra Bank");
        
         String URL="http://www.nrb.org.np/fxmexchangerate.php?YY=2015&MM=10&DD=08&B1=Go";
       // String URL="http://www.rbb.com.np/fxrates.php";
       // String link = "https://play.google.com/store/apps/details";
        String contentPage1, contentPage2, fullLink, regex1, regex2, regex3;
        Pattern pattern1, pattern2, pattern3;
        Matcher matcher1, matcher2, matcher3;

        
        
        contentPage1 = readURL(URL);

        regex1 = "<tr bordercolor=\"#FFFFFF\">(.*?)<td valign=\"center\" bordercolor=\"#999999\"><font size=\"2\""
                + " face=\"Verdana\">(.*?)<span class=\"(.*?)\"></span> &nbsp;(.*?)</font></td>(.*?)<td valign=\"center\" "
                + "bordercolor=\"#999999\"> <div align=\"center\"><font size=\"2\" face=\"Verdana\"> (.*?)</font></div>"
                + "</td>(.*?)<td align=\"right\" valign=\"center\" bordercolor=\"#999999\"> <div align=\"center\"><font size=\"2\""
                + " face=\"Verdana\">(.*?)</font></div></td>(.*?)<td align=\"right\" valign=\"center\" bordercolor=\"#999999\">"
                + " <div align=\"center\"><font size=\"2\" face=\"Verdana\">(.*?)</font></div></td>(.*?)</tr>";

       // regex1="&nbsp;&nbsp;(.*?)</b>";//currency name
        //<b>(\d)</b></font unit
        
        pattern1 = Pattern.compile(regex1);
        matcher1 = pattern1.matcher(contentPage1);
        System.out.println("out");
        while (matcher1.find()) {
            //System.out.println("in");
            
  
            
            //System.out.println(matcher1.group(4).trim()+"\t"+matcher1.group(6)+"\t"+matcher1.group(8)+"\t"+matcher1.group(10));//Rastrabank
  
            //System.out.println(matcher1.group(4).replaceAll("[^\\w/i]","").trim());
            try{
            ExchangeRates exchangeRates=new ExchangeRates();
            currency=currencyService.getByName(matcher1.group(4).replaceAll("[^\\w/\\s/i]","").trim());
                System.out.println(currency);
            exchangeRates.setBank(bank);
            exchangeRates.setCurrency(currency);
            exchangeRates.setUnit(Integer.parseInt(matcher1.group(6).replaceAll("-","0").trim()));
            exchangeRates.setSellingRate(Double.parseDouble(matcher1.group(10).replaceAll("-", "0").trim()));    
            exchangeRates.setBuyingRate(Double.parseDouble(matcher1.group(8).replaceAll("-", "0").trim()));
            exchangeRates.setForexDate(date);
            
            exchangeRates.setForexTime(time);
           
                System.out.println(exchangeRates.toString());
            
             
//                exchangeRatesService.insertOrUpdate(exchangeRates);
            
            }catch(NullPointerException | NumberFormatException ex){
                System.out.println(ex.getMessage());
            }
                
        }
        
    }
    
}
