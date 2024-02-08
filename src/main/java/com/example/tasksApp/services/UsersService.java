package com.example.tasksApp.services;

import com.example.tasksApp.domain.user.User;
import com.example.tasksApp.domain.user.UserRecord;
import com.example.tasksApp.domain.user.UsersRepository;
import com.example.tasksApp.infra.PasswordEncryptor;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {
    @Autowired
    private UsersRepository repository;
    @Autowired
    private PasswordEncryptor encryptor;

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public void createUser(UserRecord data) {
        User newUser = new User(data);
        newUser.setPassword(encryptor.encryptPassword(newUser.getPassword()));
        repository.save(newUser);
    }

    public void deleteUser(String userId) {
        Optional<User> existingUserOptional = repository.findById(userId);

        if (existingUserOptional.isPresent()) {
            repository.deleteById(userId);
        } else {
            throw new EntityNotFoundException();
        }
    }
}
