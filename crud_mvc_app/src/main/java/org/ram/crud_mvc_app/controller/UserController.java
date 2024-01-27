package org.ram.crud_mvc_app.controller;

import java.util.List;
import java.util.Optional;

import org.ram.crud_mvc_app.service.UserService;
import org.ram.crud_mvc_app.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    public UserService userService;

    @PostMapping("/create") //4
    public String addUser(@ModelAttribute User user){
        userService.createUser(user);
        return "redirect:/users";
    }

    @GetMapping("/new")     //3
    public String createUser(Model model){
        model.addAttribute("user", new User());
        return "user-form";
    }
    
    @GetMapping("/")    //1
    public String readAll(Model model){
        List<User> users = userService.retriveUser();
        model.addAttribute("users", users);
        return "user-list"; //return the name of the html/thymeleaf view
    }

    @GetMapping("/getById/{id}")    //2
    public String getUserById(@PathVariable Integer id, Model model){
        Optional<User> user = userService.getUserById(id);
        if (user.isPresent()) {
            model.addAttribute("user", user.get());
            return "user-details";
        }else{
            return "redirect:/users";  
        }
    }

    @GetMapping("/edit/{id}")   //5
    public String editUser(@PathVariable Integer id, Model model){
        Optional<User> user = userService.getUserById(id);
        if(user.isPresent()){
            model.addAttribute("user", user.get());
            return "user-form";
        }else{
            return "redirect:/users";
        }
    }
        

    // @PostMapping("/edit/{id}")
    // public String editUser(@PathVariable Integer id, @ModelAttribute User user){
    //     userService.updateUser(id, user);
    //     return "redirect:/users";
    // }

    @PostMapping("/update") //6
    public String updateUser(@ModelAttribute User user){
        userService.updateUser(user);
        return "redirect:/users";
    }

    // @DeleteMapping("/delete")
    // public String deleteAll(@ModelAttribute User user){
    //     userService.delete(user);
    //     return "redirect:/users";
    // }

    @GetMapping("/delete/{id}")
    public String deleteAll(@PathVariable Integer id){
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
