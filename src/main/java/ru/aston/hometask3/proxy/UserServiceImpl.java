package ru.aston.hometask3.proxy;

public class UserServiceImpl implements UserService {
    @Override
    public String getUser(String username) {
        System.out.printf("Getting user '%s' from database%n", username);
        return "User: " + username;
    }
}