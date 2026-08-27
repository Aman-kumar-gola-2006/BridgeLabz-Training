package com.cjc.user_management_app.repository;

import com.cjc.user_management_app.model.User;
import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    private Map<Long, User> users = new HashMap<>();
    private long idCounter = 1;

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(idCounter++);
        }
        users.put(user.getId(), user);
        return user;
    }

    public User findById(Long id) {
        return users.get(id);
    }

    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }

    public void delete(Long id) {
        users.remove(id);
    }

    public User findByUsername(String username) {
        return users.values().stream()
            .filter(u -> u.getUsername().equals(username))
            .findFirst()
            .orElse(null);
    }
}