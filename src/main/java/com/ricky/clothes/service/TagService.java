package com.ricky.clothes.service;

import com.ricky.clothes.mapper.TagMapper;
import com.ricky.clothes.model.Tag;

import java.util.List;

/**
 * Created by caiqing on 16/2/1.
 */
public class TagService {

    TagMapper tagMapper;

    public List<Tag> selectTag() {
        return tagMapper.selectAll();
    }

}
