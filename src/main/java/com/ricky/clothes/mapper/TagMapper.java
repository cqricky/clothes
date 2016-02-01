package com.ricky.clothes.mapper;

import com.ricky.clothes.model.Tag;

import java.util.List;

public interface TagMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Tag record);

    int insertSelective(Tag record);

    Tag selectByPrimaryKey(Integer id);

    List<Tag> selectAll();

    int updateByPrimaryKeySelective(Tag record);

    int updateByPrimaryKey(Tag record);
}