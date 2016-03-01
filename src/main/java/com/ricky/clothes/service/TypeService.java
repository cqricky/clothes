package com.ricky.clothes.service;

import com.ricky.clothes.mapper.TypeMapper;
import com.ricky.clothes.model.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by caiqing on 16/3/1.
 */
@Service
public class TypeService {
    @Autowired
    TypeMapper typeMapper;

    public List<Type> selectType() {
        return typeMapper.selectAll();
    }

    public Type selectTypeById(Integer typeId) {
        return typeMapper.selectByPrimaryKey(typeId);
    }

    public int create(Type type) {
        return typeMapper.insert(type);
    }

    public int update(Type type) {
        return typeMapper.updateByPrimaryKeySelective(type);
    }
}
