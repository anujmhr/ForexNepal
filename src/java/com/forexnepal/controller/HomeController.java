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
        mv.addObject("allExchangeRates", exchangeRatesService.getAll());
        mv.addObject("allForexDate", exchangeRatesService.getAllDate());
        mv.addObject("allForexTime", exchangeRatesService.getAllTime());

        return mv;
    }

    @RequestMapping(value = "/exchange_rates/all_dates", method = RequestMethod.GET)
    public @ResponseBody
    ModelMap allForexDate() {
        ModelMap map = new ModelMap();

        map.addAttribute("forexDates", exchangeRatesService.getAllDate());
        return map;
    }
@RequestMapping(value = "/exchange_rates/time_by_date/{date}", method = RequestMethod.GET)
    public @ResponseBody
    ModelMap allTimeByDate(@PathVariable(value = "date") Date date) {
        ModelMap map = new ModelMap();

        map.addAttribute("timeByDate", exchangeRatesService.getAllTimeByDate(date));
        return map;
    }
    
    
    @RequestMapping(value = "/exchange_rates/all_time", method = RequestMethod.GET)
    public @ResponseBody
    ModelMap allForexTime() {
        ModelMap map = new ModelMap();

        map.addAttribute("forexTimes", exchangeRatesService.getAllTime());
        return map;
    }

    @RequestMapping(value = "/exchange_rates", method = RequestMethod.GET)
    public @ResponseBody
    ModelMap allExchangeRates() {
        ModelMap map = new ModelMap();

        map.addAttribute("allExchangeRates", exchangeRatesService.getAll());
        return map;
    }

    @RequestMapping(value = "/exchange_rates/bank/{bankId}", method = RequestMethod.GET)
    public @ResponseBody
    ModelMap ExchangeRatesByBank(@PathVariable(value = "bankId") int bankId) {
        ModelMap map = new ModelMap();
        map.addAttribute("exchangeRatesByBank", exchangeRatesService.getByBank(bankId));
        return map;
    }

    @RequestMapping(value = "/exchange_rates/currency/{currencyId}", method = RequestMethod.GET)
    public @ResponseBody
    ModelMap ExchangeRatesByCurrency(@PathVariable(value = "currencyId") int currencyId) {
        ModelMap map = new ModelMap();
        map.addAttribute("exchangeRatesByCurrency", exchangeRatesService.getByCurency(currencyId));
        return map;
    }

    @RequestMapping(value = "/exchange_rates/date/{date}", method = RequestMethod.GET)
    public @ResponseBody
    ModelMap ExchangeRatesByDate(@PathVariable(value = "date") Date date) {
        ModelMap map = new ModelMap();
        map.addAttribute("exchangeRatesByDate", exchangeRatesService.getByDate(date));
        return map;
    }

    @RequestMapping(value = "/exchange_rates/time/{time}", method = RequestMethod.GET)
    public @ResponseBody
    ModelMap ExchangeRatesByTime(@PathVariable(value = "time") Time time) {
        ModelMap map = new ModelMap();
        map.addAttribute("exchangeRatesByTime", exchangeRatesService.getByTime(time));
        return map;
    }

    @RequestMapping(value = "/exchange_rates/{byCurrencyId}/{byDate}/{byTime}", method = RequestMethod.GET)
    public @ResponseBody
    ModelMap ExchangeRatesByCurrencyDateTime(@PathVariable(value = "byCurrencyId") int byCurrencyId, @PathVariable(value = "byDate") Date byDate, @PathVariable(value = "byTime") Time byTime) {
        ModelMap map = new ModelMap();
        System.out.println(byCurrencyId + "" + byDate + "" + byTime);
        map.addAttribute("exchangeRatesByCurrencyDateTime", exchangeRatesService.getByCurrencyDateTime(byCurrencyId, byDate, byTime));
        return map;
    }
    
    
    @RequestMapping(value = "/exchange_rates/currency_list", method = RequestMethod.GET)
    public @ResponseBody
    ModelMap getCurrencyList() {
        ModelMap map = new ModelMap();
        map.addAttribute("currencyList", exchangeRatesService.getCurrencyList());
        return map;
    }
    
     @RequestMapping(value = "currency", method = RequestMethod.GET)
    public ModelAndView currency() {
        ModelAndView mv = new ModelAndView("home/views/currency");

        return mv;
    }
       @RequestMapping(value = "currency/buying_rate", method = RequestMethod.GET)
    public ModelAndView currencyBuyingRate() {
        ModelAndView mv = new ModelAndView("home/views/currencyBuyingRates");

        return mv;
    }
     @RequestMapping(value = "currency/selling_rate", method = RequestMethod.GET)
    public ModelAndView currencySellingRate() {
        ModelAndView mv = new ModelAndView("home/views/currencySellingRates");

        return mv;
    }
       @RequestMapping(value = "bank", method = RequestMethod.GET)
    public ModelAndView dashboard() {
        ModelAndView mv = new ModelAndView("home/views/banks");

        return mv;
    }
       @RequestMapping(value = "bank/buying_rate", method = RequestMethod.GET)
    public ModelAndView bankBuyingRate() {
        ModelAndView mv = new ModelAndView("home/views/bankBuyingRates");

        return mv;
    }
     @RequestMapping(value = "bank/selling_rate", method = RequestMethod.GET)
    public ModelAndView bankSellingRate() {
        ModelAndView mv = new ModelAndView("home/views/bankSellingRates");

        return mv;
    }
    
 

}

