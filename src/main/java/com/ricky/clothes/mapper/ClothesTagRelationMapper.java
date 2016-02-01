package com.ricky.clothes.mapper;

import com.ricky.clothes.model.ClothesTagRelation;

public interface ClothesTagRelationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ClothesTagRelation record);

    int insertSelective(ClothesTagRelation record);

    ClothesTagRelation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ClothesTagRelation record);

    int updateByPrimaryKey(ClothesTagRelation record);
}