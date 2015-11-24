/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.forexnepal.dao;

import java.util.List;

/**
 *
 * @author Anuz
 * @param <T>
 */
public interface GenericDAO<T> {
    List<T> getAll();
    T getById(int id);
    T getByName(String string);
    int insertOrUpdate(T t);
    int delete(int id);

}
