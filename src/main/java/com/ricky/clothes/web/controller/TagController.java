package com.ricky.clothes.web.controller;

import com.ricky.clothes.model.Tag;
import com.ricky.clothes.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
@RequestMapping("/tags")
public class TagController extends BaseAppController {
    @Autowired
    TagService tagService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String selectAll(HttpServletRequest req, HttpServletResponse res, Model model) {
        List<Tag> tags = tagService.selectTag();
        model.addAttribute("tags", tags);
//        throw  new NullPointerException();
        return "tag/index";
    }


    @RequestMapping(value = "/tag", method = RequestMethod.GET)
    public ModelAndView selectAllTag(HttpServletRequest req, HttpServletResponse res) {
        List<Tag> tags = tagService.selectTag();
        ModelAndView mv = new ModelAndView();
        mv.addObject("tags", tags);
        mv.setViewName("tag/index");
        return mv;
    }
}
