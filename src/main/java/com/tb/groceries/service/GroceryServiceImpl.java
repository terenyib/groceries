package com.tb.groceries.service;

import com.tb.groceries.dao.GroceryRepository;
import com.tb.groceries.entity.Grocery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroceryServiceImpl implements GroceryService {

    private final GroceryRepository groceryRepository;

    @Autowired
    public GroceryServiceImpl(final GroceryRepository groceryRepository) {
        this.groceryRepository = groceryRepository;
    }

    @Override
    public List<Grocery> findAll() {
        return groceryRepository.findAllByOrderByNameAsc();
    }

    @Override
    public Grocery findById(final int id) {
        return groceryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Did not find grocery by id - " + id));
    }

    @Override
    public void save(final Grocery grocery) {
        groceryRepository.save(grocery);
    }

    @Override
    public void deleteById(final int id) {
        groceryRepository.deleteById(id);
    }
}
