/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.forexnepal.service;

import com.forexnepal.dao.BankDAO;
import com.forexnepal.entity.Bank;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Anuz
 */
@Service
public class BankService {
    
    @Autowired
    private BankDAO bankDAO;
    
     public List<Bank> getAll() {
        return bankDAO.getAll();
    }

    public Bank getById(int id) {
        return bankDAO.getById(id);
    }

   public Bank getByName(String bankName){
   return bankDAO.getByName(bankName);
   }
    public int insertOrUpdate(Bank b) {
        return bankDAO.insertOrUpdate(b);
    }
    
   

    public int delete(int id) {
        return bankDAO.delete(id);
    }
    
}
