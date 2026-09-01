package ru.aston.hometask3.proxy;

public class Main {
    void main() {
        UserService userService = new UserServiceCacheProxy(
                new UserServiceImpl()
        );

        userService.getUser("user1");
        userService.getUser("user1");
        userService.getUser("user2");
        userService.getUser("user3");
        userService.getUser("user2");
    }
}
