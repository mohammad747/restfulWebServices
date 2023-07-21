package com.hashemi.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();
    private static Integer userCount = 0;

    static {
        users.add(new User(++userCount, "Mohammad", LocalDate.now().minusYears(30)));
        users.add(new User(++userCount, "Reza", LocalDate.now().minusYears(25)));
        users.add(new User(++userCount, "Ali", LocalDate.now().minusYears(20)));
    }

    public List<User> findAll() {
        return users;
    }

    public User find(Integer id) {
        return users
                .stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new UserNotFountException("id: " + id));
    }

    public User save(User user) {
        user.setId(++userCount);
        users.add(user);
        return user;
    }
}
