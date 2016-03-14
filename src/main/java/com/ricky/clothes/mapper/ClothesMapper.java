package com.ricky.clothes.mapper;

import com.ricky.clothes.model.Clothes;

import java.util.List;

public interface ClothesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Clothes record);

    List<Clothes> selectAll();

    List<Clothes> selectAllWithTag();

    int insertSelective(Clothes record);

    Clothes selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Clothes record);

    int updateByPrimaryKey(Clothes record);
}