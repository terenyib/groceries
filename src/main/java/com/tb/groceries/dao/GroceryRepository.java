package com.tb.groceries.dao;

import com.tb.groceries.entity.Grocery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroceryRepository extends JpaRepository<Grocery, Integer> {

    public List<Grocery> findAllByOrderByNameAsc();
}
