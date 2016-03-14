package com.ricky.clothes.service;

import com.ricky.clothes.mapper.ClothesMapper;
import com.ricky.clothes.model.Clothes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by caiqing on 16/3/9.
 */
@Service
public class ClothesService {
    @Autowired
    ClothesMapper clothesMapper;

    public List<Clothes> selectClothes () {
        return clothesMapper.selectAll();
    }

    public List<Clothes> selectAllWithTag() {
        return clothesMapper.selectAllWithTag();
    }
}
