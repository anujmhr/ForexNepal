/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.forexnepal.allbanks;

import com.forexnepal.service.CurrencyService;
import com.forexnepal.service.ExchangeRatesService;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Anuz
 */
class RastraBank extends ScrapCommand {
    @Autowired
    private ExchangeRatesService exchangeRateService;
    @Autowired
    private CurrencyService currencyService;

    public RastraBank() {
    }

    @Override
    public void scrap(String args) throws IOException {
        String currency;
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
            
            currency=matcher1.group(4).trim();
            
            System.out.println(matcher1.group(4).trim()+"\t"+matcher1.group(6)+"\t"+matcher1.group(8)+"\t"+matcher1.group(10));//Rastrabank
            //System.out.println(matcher1.group(4));
            
            //System.out.println(currency);
            
            System.out.println(currencyService.getByName(currency).toString());
           
            System.out.println("------------------");
            
        }
        
    }
    
}
