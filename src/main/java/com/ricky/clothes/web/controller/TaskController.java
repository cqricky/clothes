package com.ricky.clothes.web.controller;

import com.ricky.clothes.model.Task;
import com.ricky.clothes.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by caiqing on 15/11/18.
 */
@RestController
@RequestMapping("/tasks")
public class TaskController extends BaseAppController {
    @Autowired
    private TaskService taskService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Task> getAllTaks() {
        return taskService.findAll();
//        return new ArrayList<Task>();
    }

}
