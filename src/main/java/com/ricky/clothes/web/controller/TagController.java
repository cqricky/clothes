package com.ricky.clothes.web.controller;

import com.ricky.clothes.model.Tag;
import com.ricky.clothes.service.TagService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by caiqing on 16/2/1.
 */
@Controller
@RequestMapping("/tags")
public class TagController extends BaseAppController {
    TagService tagService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String selectAll(@ModelAttribute("model") Model model) {
        List<Tag> tags = tagService.selectTag();
        model.addAttribute("tags", tags);

        return "tag/index";

    }


}
