package com.ricky.clothes.service;

import com.ricky.clothes.constant.EnumLocation;
import com.ricky.clothes.mapper.ClothesMapper;
import com.ricky.clothes.mapper.TypeMapper;
import com.ricky.clothes.model.Clothes;
import com.ricky.clothes.model.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by caiqing on 16/3/9.
 */
@Service
@Transactional
public class ClothesService {
    @Autowired
    ClothesMapper clothesMapper;

    @Autowired
    TypeMapper typeMapper;

    public List<Clothes> selectClothes() {
        return clothesMapper.selectAll();
    }

    public List<Clothes> selectAllWithTag() {
        return clothesMapper.selectAllWithTag();
    }

    @Transactional(propagation = Propagation.NEVER)
    public void saveClothes(){
        Type type = new Type();
        type.setName("red2");

        typeMapper.insert(type);

        if(true){
//            throw new NullPointerException();
        }

        Clothes clothes = new Clothes();
        clothes.setName("test2");
        clothes.setImageName("testimagename2");
        clothes.setLocation(EnumLocation.KAIKAI);

        clothesMapper.insert(clothes);


    }

}
