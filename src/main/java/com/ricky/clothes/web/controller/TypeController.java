package com.ricky.clothes.web.controller;

import com.ricky.clothes.model.Type;
import com.ricky.clothes.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by caiqing on 16/2/1.
 */
@Controller
@RequestMapping("/types")
public class TypeController extends BaseAppController {
    @Autowired
    TypeService typeService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String selectAll(HttpServletRequest req, HttpServletResponse res, Model model) {
        List<Type> types = typeService.selectType();
        model.addAttribute("types", types);
//        throw  new NullPointerException();
        return "types/index";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newPage() {
        return "types/new";
    }

    @RequestMapping(value = "/edit/{typeId}", method = RequestMethod.GET)
    public String editPage(@PathVariable Integer typeId, Model model) {
        Type type = typeService.selectTypeById(typeId);
        model.addAttribute("type", type);
        return "types/edit";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String create(HttpServletResponse res, Type type) {
        typeService.create(type);
        return "redirect:/types/";
    }

    @RequestMapping(value = "/{typeId}", method = RequestMethod.POST)
    public String update(@PathVariable Integer typeId, HttpServletResponse res, Type type) {
        type.setId(typeId);
        typeService.update(type);
        return "redirect:/types/";
    }

    @RequestMapping(value = "/type", method = RequestMethod.GET)
    public ModelAndView selectAllType(HttpServletRequest req, HttpServletResponse res) {
        List<Type> types = typeService.selectType();
        ModelAndView mv = new ModelAndView();
        mv.addObject("types", types);
        mv.setViewName("types/index");
        return mv;
    }
}
