package com.tb.groceries.controller;

import com.tb.groceries.entity.Grocery;
import com.tb.groceries.service.GroceryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/groceries")
public class GroceriesController {

    private final GroceryService groceryService;

    public GroceriesController(final GroceryService groceryService) {
        this.groceryService = groceryService;
    }

    @GetMapping("/list")
    public String listGroceries(final Model model) {
        final List<Grocery> groceries = groceryService.findAll();
        model.addAttribute("groceries", groceries);
        return "groceries/list-groceries";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(final Model model) {
        final Grocery grocery = new Grocery();
        model.addAttribute("grocery", grocery);
        return "groceries/grocery-form";
    }

    @PostMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("groceryId") final int id,
                                    final Model model) {
        final Grocery grocery = groceryService.findById(id);
        model.addAttribute("grocery", grocery);
        return "groceries/grocery-form";
    }

    @PostMapping("/save")
    public String saveGrocery(@ModelAttribute("grocery") final Grocery grocery) {
        groceryService.save(grocery);
        return "redirect:/groceries/list";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("groceryId") final int id) {
        groceryService.deleteById(id);
        return "redirect:/groceries/list";
    }
}
