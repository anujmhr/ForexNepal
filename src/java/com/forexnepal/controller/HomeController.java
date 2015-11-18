/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.forexnepal.controller;

import com.forexnepal.service.BankService;
import com.forexnepal.service.CurrencyService;
import com.forexnepal.service.ExchangeRatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author anuz
 */

@Controller
@RequestMapping(value = "/")
public class HomeController {
    
    @Autowired
    private CurrencyService currencyService;
    @Autowired
    private BankService bankService;
    @Autowired
    private ExchangeRatesService exchangeRatesService;
 
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("home/index");

        return mv;
    }
    
    @RequestMapping(value="/exchange_rates",method = RequestMethod.GET)
    public @ResponseBody ModelMap allExchangeRates() {
        ModelMap map=new ModelMap();

        map.addAttribute("allExchangeRates", exchangeRatesService.getAll());
        return map;
    }
    
    

}
