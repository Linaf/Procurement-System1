/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.controller;

import edu.mum.domain.Item;
import edu.mum.domain.Specification;
import edu.mum.service.CategoryService;
import edu.mum.service.ItemService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Lina
 */
@Controller
 @RequestMapping(value="/items")
public class ItemController {

    @Autowired
    ItemService itemService;
    @Autowired
    CategoryService categoryService;

    /**
     *
     * @param model
     * @return
     */
    @RequestMapping(value="/add", method = RequestMethod.GET)
    public String getNewItem( Model model) {
        Item item = new Item();
        //Specification spec = new Specification();
        model.addAttribute("item", item);
        model.addAttribute("categories", categoryService.findAll());
        //model.addAttribute("spec", spec);
        return "addItemPage";
    } 
    @RequestMapping(value="/add", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addItem(@RequestBody  Item item) {
       
       itemService.saveItem(item);
    } 
}
