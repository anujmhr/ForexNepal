/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.forexnepal.controller;

import com.forexnepal.allbanks.ScrapData;
import com.forexnepal.service.BankService;
import com.forexnepal.service.CurrencyService;
import com.forexnepal.service.ExchangeRatesService;
import java.io.IOException;
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
 * @author Anuz
 */
@Controller
@RequestMapping(value = "/")
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

    @RequestMapping(value = "/admin/bank/{id}", method = RequestMethod.GET)
    public @ResponseBody
    String scrapBank(@PathVariable("id") String id) throws IOException {
        ScrapData scrapData = new ScrapData(currencyService, bankService, exchangeRatesService);

        scrapData.scrapChoice(id);

        return "success";
    }

    @RequestMapping(value = "/admin/all_currency", method = RequestMethod.GET)
    public @ResponseBody
    ModelMap allCurrency() {
        ModelMap mv = new ModelMap();

        mv.addAttribute("allCurrency", currencyService.getAll());

        return mv;
    }

    @RequestMapping(value = "admin/currency/{code}", method = RequestMethod.GET)
    public @ResponseBody
    ModelMap currencyByCode(@PathVariable("code") String code) {
        ModelMap mv = new ModelMap();
        mv.addAttribute("currencyByCode", currencyService.getByName(code));

        return mv;

    }

}
