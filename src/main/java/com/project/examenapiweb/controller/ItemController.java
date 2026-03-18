package com.project.examenapiweb.controller;

import com.project.examenapiweb.model.Item;
import com.project.examenapiweb.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/items")
@AllArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping
    public String listItems(Model model) {
        model.addAttribute("items", itemService.findAll());
        return "items-list";
    }

    @GetMapping("/{id}")
    public String viewItemDetails(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("item", itemService.findById(id));
        return "item-detail";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("item", itemService.findById(id));
        return "item-edit";
    }

    @PostMapping("/edit")
    public String updateItem(@ModelAttribute("item") Item item) {
        itemService.updateItem(item);
        return "redirect:/items";
    }

    @GetMapping("/stats")
    public String viewStats(Model model) {
        model.addAttribute("stats", itemService.getStats());
        return "item-stats";
    }
}