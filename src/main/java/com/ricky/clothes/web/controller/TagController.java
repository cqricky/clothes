package com.ricky.clothes.web.controller;

import com.ricky.clothes.model.Tag;
import com.ricky.clothes.service.TagService;
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

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newPage() {
        return "tag/new";
    }

    @RequestMapping(value = "/edit/{tagId}", method = RequestMethod.GET)
    public String editPage(@PathVariable Integer tagId, Model model) {
        Tag tag = tagService.selectTagById(tagId);
        model.addAttribute("tag", tag);
        return "tag/edit";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String create(HttpServletResponse res, Tag tag) {
        tagService.create(tag);
        return "redirect:/tags/";
    }

    @RequestMapping(value = "/{tagId}", method = RequestMethod.POST)
    public String update(@PathVariable Integer tagId, HttpServletResponse res, Tag tag) {
        tag.setId(tagId);
        tagService.update(tag);
        return "redirect:/tags/";
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
