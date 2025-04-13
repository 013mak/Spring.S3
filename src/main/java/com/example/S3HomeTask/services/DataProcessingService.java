package com.example.S3HomeTask.services;


import com.example.S3HomeTask.domain.User;
import com.example.S3HomeTask.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataProcessingService {

    @Autowired
    private UserRepository repository;

    public List<User> sortUsersByAge(List<User> users) {
        return users.stream()
                .sorted(Comparator.comparing(User::getAge))
                .collect(Collectors.toList());
    }

    public List<User> filterUsersByAge(List<User> users, int age) {
        return users.stream()
                .filter(user -> user.getAge() > age)
                .collect(Collectors.toList());
    }

    public double calculateAverageAge(List<User> users) {
        return users.stream()
                .mapToInt(User::getAge)
                .average()
                .orElse(0);
    }

    public UserRepository getRepository() {
        return repository;
    }

    public void setRepository(UserRepository repository) {
        this.repository = repository;
    }

    public void addUserToList(User user) {
        repository.addUser(user);
        //repository.getUsers().add(user);
    }
}
