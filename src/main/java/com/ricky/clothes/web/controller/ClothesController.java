package com.ricky.clothes.web.controller;

import com.ricky.clothes.model.Clothes;
import com.ricky.clothes.service.ClothesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by caiqing on 16/3/9.
 */
@Controller
@RequestMapping("/clothes")
public class ClothesController extends BaseAppController {
    @Autowired
    ClothesService clothesService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String selectAll ( Model model){
        List<Clothes> clothes = clothesService.selectClothes();


        return "";
    }
}
