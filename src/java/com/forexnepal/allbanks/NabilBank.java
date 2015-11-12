/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.forexnepal.allbanks;

import com.forexnepal.service.CurrencyService;
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
       String URL="http://www.nabilbank.com/exchange/exchangerate.php";
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
            System.out.println(matcher1.group(2).trim()+"\t"+"1"+"\t"+matcher1.group(4)+"\t"+matcher1.group(8));//Rastrabank
            //System.out.println(matcher1.group(4));
            try{
            System.out.println(currencyService.getByName(matcher1.group(2).trim()).getCurrencyId());
                
            }catch(NullPointerException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
    
    
}
