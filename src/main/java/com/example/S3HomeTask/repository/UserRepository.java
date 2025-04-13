package com.example.S3HomeTask.repository;


import com.example.S3HomeTask.domain.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class UserRepository {

    private List<User> users = new ArrayList<>();

    public UserRepository(List<User> users) {
        this.users = users;
        if (users.isEmpty()) {
            User user = new User();
            user.setAge(15);
            user.setName("Ivan");
            user.setEmail("ivan@gmail.com");
            users.add(user);}
        System.out.println(users);
    }

    public List<User> getUsers() {
//        if (users.isEmpty()) {
//            User user = new User();
//            user.setAge(15);
//            user.setName("Ivan");
//            user.setEmail("ivan@gmail.com");
//            users.add(user);}

        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
    public void addUser(User user) {
        users.add(user);
    }

}
