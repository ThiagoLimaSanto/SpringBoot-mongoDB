package com.application.workshop_mongodb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.workshop_mongodb.domain.User;
import com.application.workshop_mongodb.dto.UserDto;
import com.application.workshop_mongodb.repository.UserRepository;
import com.application.workshop_mongodb.services.exception.ObjectNotFoundException;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        User user = repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("User not found!"));
        if (user == null) {
            throw new ObjectNotFoundException("User not found!");
        }
        return user;
    }

    public User insert(User obj) {
        return repository.insert(obj);
    }

    public User fromDto(UserDto obj) {
        return new User(obj.getId(), obj.getName(), obj.getEmail());
    }

    public void delete(String id) {
        findById(id);
        repository.deleteById(id);
    }

    public User update(User user) {
        User newUser = findById(user.getId());
        updateData(newUser, user);

        return repository.save(newUser);
    }

    private void updateData(User newUser, User user) {
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
    }
}
