package ru.aston.hometask3.proxy;

import java.util.HashMap;
import java.util.Map;

public class UserServiceCacheProxy implements UserService {
    private final UserService userService;
    private final Map<String, String> cache = new HashMap<>();

    public UserServiceCacheProxy(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String getUser(String username) {
        if (cache.containsKey(username)) {
            System.out.printf("Getting user '%s' from cache%n", username);
            return cache.get(username);
        }

        String user = userService.getUser(username);
        cache.put(username, user);
        return user;
    }
}
