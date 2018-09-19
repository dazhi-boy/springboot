package com.example.demo.admin.controller;

import com.example.demo.admin.entity.User;
import com.example.demo.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Administrator on 2018/9/19.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/list")
    public String list(Model model){
        UserToModel(model);
        return "user/list";
    }

    @RequestMapping("/insertPage")
    public String insertPage(Model model){
        return "user/add";
    }

    @RequestMapping("/insert")
    public String insert(Model model,User user){
        int result = userService.insert(user);
        UserToModel(model);
        return "user/list";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable Integer id){
        int result = userService.delete(id);
        UserToModel(model);
        return "user/list";
    }

    @RequestMapping("/editPage/{id}")
    public String editPage(Model model, @PathVariable Integer id){
        User user = userService.getById(id);
        model.addAttribute("user", user);
        return "user/edit";
    }

    @RequestMapping("/edit")
    public String edit(Model model, User user){
        userService.update(user);
        UserToModel(model);
        return "user/list";
    }

    private void UserToModel(Model model) {
        List<User> userList = userService.list();
        model.addAttribute("users", userList);
    }
}
