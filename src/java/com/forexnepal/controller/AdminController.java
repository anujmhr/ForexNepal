/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.forexnepal.controller;

import com.forexnepal.allbanks.ScrapListener;
import com.forexnepal.entity.Bank;
import com.forexnepal.service.BankService;
import com.forexnepal.service.CurrencyService;
import com.forexnepal.service.ExchangeRatesService;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import javafx.scene.media.Media;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Anuz
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private CurrencyService currencyService;
    @Autowired
    private BankService bankService;
    @Autowired
    private ExchangeRatesService exchangeRatesService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("admin/index");

        return mv;
    }

    @RequestMapping(value = "dashboard", method = RequestMethod.GET)
    public ModelAndView dashboard() {
        ModelAndView mv = new ModelAndView("admin/views/dashboard");

        return mv;
    }

    @RequestMapping(value = "banks", method = RequestMethod.GET)
    public ModelAndView banks() {
        ModelAndView mv = new ModelAndView("admin/views/banks");

        return mv;

    }

    @RequestMapping(value = "banks/save_bank", method = RequestMethod.POST)
    public @ResponseBody String addBank(Bank bank) {
        System.out.println(bank.getBankName());
//        System.out.println("here" + bank.getBankName());
       // Gson gson = new Gson();
//        String jsonBank = gson.toJson(bank);
//
//        System.out.println(jsonBank);
//        bankService.insertOrUpdate(bank);
        return "success";
    }

    @RequestMapping(value = "banks/all_banks", method = RequestMethod.GET)
    public @ResponseBody
    ModelMap allBanks() {
        ModelMap mv = new ModelMap();

        mv.addAttribute("allBanks", bankService.getAll());

        return mv;
    }

    @RequestMapping(value = "exchangeRates", method = RequestMethod.GET)
    public ModelAndView exchangeRates() {
        ModelAndView mv = new ModelAndView("admin/views/exchangeRates");

        return mv;
    }

    @RequestMapping(value = "currency", method = RequestMethod.GET)
    public ModelAndView currency() {
        ModelAndView mv = new ModelAndView("admin/views/currency");

        return mv;
    }

    @RequestMapping(value = "bank/scrap_all", method = RequestMethod.GET)
    public @ResponseBody
    // String scrapBank(@PathVariable("id") String id) throws IOException {
    ModelMap scrapBank() throws IOException {
        Date date = new java.sql.Date(new java.util.Date().getTime());
        Time time = new java.sql.Time(new java.util.Date().getTime());
        for (int i = 1; i <= 9; i++) {
            ScrapListener scrapListener = new ScrapListener(currencyService, bankService, exchangeRatesService, date, time, i + "");
            scrapListener.start();
        }
        
//           ScrapListener scrapListener = new ScrapListener(currencyService, bankService, exchangeRatesService, date, time, 9+"");
//           scrapListener.start();
        ModelMap map=new ModelMap();
        map.addAttribute("date", date);
        map.addAttribute("time", time);
        map.addAttribute("message", "Success");
       
        return map;
    }

    @RequestMapping(value = "all_currency", method = RequestMethod.GET)
    public @ResponseBody
    ModelMap allCurrency() {
        ModelMap mv = new ModelMap();

        mv.addAttribute("allCurrency", currencyService.getAll());

        return mv;
    }

    @RequestMapping(value = "currency/{code}", method = RequestMethod.GET)
    public @ResponseBody
    ModelMap currencyByCode(@PathVariable("code") String code) {
        ModelMap mv = new ModelMap();

        mv.addAttribute("currencyByCode", currencyService.getByName(code));

        return mv;

    }

}
