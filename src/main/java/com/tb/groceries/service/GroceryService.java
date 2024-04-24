package com.tb.groceries.service;

import com.tb.groceries.entity.Grocery;

import java.util.List;

public interface GroceryService {

    List<Grocery> findAll();

    Grocery findById(int id);

    void save(Grocery grocery);

    void deleteById(int id);
}
