/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.forexnepal.controller;

import com.forexnepal.service.BankService;
import com.forexnepal.service.CurrencyService;
import com.forexnepal.service.ExchangeRatesService;
import java.sql.Date;
import java.sql.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
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
        mv.addObject("allCurrency", currencyService.getAll());
        mv.addObject("allBank", bankService.getAll());
        mv.addObject("allExchangeRates",exchangeRatesService.getAll());
        return mv;
    }
    
    @RequestMapping(value="/exchange_rates",method = RequestMethod.GET)
    public @ResponseBody ModelMap allExchangeRates() {
        ModelMap map=new ModelMap();

        map.addAttribute("allExchangeRates", exchangeRatesService.getAll());
        return map;
    }
    
    @RequestMapping(value="/exchange_rates/bank/{bankId}",method = RequestMethod.GET)
    public @ResponseBody ModelMap ExchangeRatesByBank(@PathVariable (value="bankId") int bankId) {
        ModelMap map=new ModelMap();
        map.addAttribute("exchangeRatesByBank", exchangeRatesService.getByBank(bankId));
        return map;
    }
    
    @RequestMapping(value="/exchange_rates/currency/{currencyId}",method = RequestMethod.GET)
    public @ResponseBody ModelMap ExchangeRatesByCurrency(@PathVariable (value="currencyId") int currencyId) {
        ModelMap map=new ModelMap();
        map.addAttribute("exchangeRatesByCurrency", exchangeRatesService.getByCurency(currencyId));
        return map;
    }
    
    @RequestMapping(value="/exchange_rates/date/{date}",method = RequestMethod.GET)
    public @ResponseBody ModelMap ExchangeRatesByDate(@PathVariable (value="date") Date date) {
        ModelMap map=new ModelMap();
        map.addAttribute("exchangeRatesByDate", exchangeRatesService.getByDate(date));
        return map;
    }
    
        @RequestMapping(value="/exchange_rates/time/{time}",method = RequestMethod.GET)
    public @ResponseBody ModelMap ExchangeRatesByTime(@PathVariable (value="time") Time time) {
        ModelMap map=new ModelMap();
        map.addAttribute("exchangeRatesByTime", exchangeRatesService.getByTime(time));
        return map;
    }
    
    
    
    

}
