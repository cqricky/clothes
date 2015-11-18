package com.ricky.clothes.service;

import com.ricky.clothes.mapper.TaskMapper;
import com.ricky.clothes.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by caiqing on 15/11/18.
 */

@Service
@Transactional
public class TaskService {
    @Autowired
    private TaskMapper taskMapper;

    public List<Task> findAll(){
        return taskMapper.findAll();
    }
}
