package com.example.S3HomeTask.Controller;

import com.example.S3HomeTask.domain.User;
import com.example.S3HomeTask.services.DataProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private DataProcessingService service;

    @GetMapping
    public List<String> getAllTasks() {
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("count");
        return tasks;
    }
    @GetMapping("/sort")
    public List<User> sortUserByAge() {
        return service.sortUsersByAge(service.getRepository().getUsers());
    }

    @GetMapping("/filter")
    public List<User> filterUserByAge() {
        return service.filterUsersByAge(service.getRepository().getUsers(), 13);
    }

    @GetMapping("/count")
    public Double countUserByAge() {
        return service.calculateAverageAge(service.getRepository().getUsers());
    }
}
