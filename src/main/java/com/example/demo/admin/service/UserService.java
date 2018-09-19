package com.example.demo.admin.service;

import com.example.demo.admin.entity.User;

import java.util.List;

/**
 * Created by Administrator on 2018/9/19.
 */
public interface UserService {
    List<User> list();
    int insert(User user);
    int update(User user);
    int delete(Integer id);

    User getById(Integer id);
}
