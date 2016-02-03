package com.ricky.clothes.service;

import com.ricky.clothes.mapper.TagMapper;
import com.ricky.clothes.model.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by caiqing on 16/2/1.
 */
@Service
public class TagService {
    @Autowired
    TagMapper tagMapper;

    public List<Tag> selectTag() {
        return tagMapper.selectAll();
    }

}
