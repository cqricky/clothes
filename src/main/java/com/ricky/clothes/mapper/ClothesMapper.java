package com.ricky.clothes.mapper;

import com.ricky.clothes.model.Clothes;

public interface ClothesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Clothes record);

    int insertSelective(Clothes record);

    Clothes selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Clothes record);

    int updateByPrimaryKey(Clothes record);
}