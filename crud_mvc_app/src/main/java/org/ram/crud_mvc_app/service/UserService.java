package org.ram.crud_mvc_app.service;

import java.util.List;
import java.util.Optional;

import org.ram.crud_mvc_app.repository.UserRepo;
import org.ram.crud_mvc_app.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public User createUser(User user){
        return userRepo.save(user);
    }

    public List<User> retriveUser(){
        return userRepo.findAll();
    }

    public Optional<User> getUserById(Integer id){
       return userRepo.findById(id);
    }

    public User updateUser(User user){
        return userRepo.save(user);
    }
    // public User updateUser(Integer id, User user){
    //     User update = userRepo.findById(id).orElseThrow(()-> new RuntimeException("id not found"+ id));
    //     update.setEmail(user.getEmail());
    //     update.setPassword(user.getPassword());
    //     update.setFirstName(user.getFirstName());
    //     update.setLastName(user.getLastName());

    //     return userRepo.save(update);
    // }

    public void deleteUser(Integer id){
        userRepo.deleteById(id);
    }
}
