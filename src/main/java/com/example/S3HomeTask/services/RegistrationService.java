package com.example.S3HomeTask.services;

import com.example.S3HomeTask.domain.User;
import com.example.S3HomeTask.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    private final UserRepository userRepository;
    //поля UserService, DataProcessingService, NotificationService
    private  DataProcessingService dataProcessingService;
    private  UserService userService;
    private  NotificationService notificationService;

    public RegistrationService(UserRepository userRepository, DataProcessingService dataProcessingService) {
        this.userRepository = userRepository;
        this.dataProcessingService = dataProcessingService;
    }


    //метод processRegistration


    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    public void setDataProcessingService(DataProcessingService dataProcessingService) {
        this.dataProcessingService = dataProcessingService;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public NotificationService getNotificationService() {
        return notificationService;
    }

    public void setNotificationService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void processRegistration(User user) {
        userService.createUser(user.getName(), user.getAge(), user.getEmail());

    }
}
