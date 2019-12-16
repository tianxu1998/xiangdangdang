package com.xiangdangdang.controller;

import com.xiangdangdang.entity.Tag;
import com.xiangdangdang.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/tag")
public class TagController {
    @Autowired
    private TagService tagService;

    @ResponseBody
    @RequestMapping("/alltag")
    public List<Tag> allTag() {
        List<Tag> res = tagService.findAllTag();
        res.sort(Comparator.comparingInt(Tag::getCount).reversed());
        return res;
    }
}
