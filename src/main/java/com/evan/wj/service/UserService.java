package com.evan.wj.service;

import com.evan.wj.dao.UserDAO;
import com.evan.wj.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: liuting
 * @Date: 2021/8/26 10:31
 * @Description:
 */

@Service
public class UserService {

    @Autowired
    UserDAO userDAO;

    public boolean isExist(String username){
        User user = userDAO.findByUsername(username);
        return null != user;
    }

    public User getByName(String username){
        return userDAO.findByUsername(username);
    }

    public User get(String username, String password){
        return userDAO.getByUsernameAndPassword(username, password);
    }

    public void add(User user){
        userDAO.save(user);
    }
}