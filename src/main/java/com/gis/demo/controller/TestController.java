package com.gis.demo.controller;

import com.gis.demo.Dao.UserDao;
import com.gis.demo.Enity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController 相当于@Controller和RequestBody
 */
@RestController
public class TestController {
    @Autowired
    UserDao userDao;

    /**
     * GET /create  --> Create a new user and save it in the database.
     */
    @RequestMapping(value = "/create",produces="text/html;charset=UTF-8",method = RequestMethod.GET)
    public String create(String email, String name) {
        String userId = "";
        try {
            User user = new User();
            user.setEmail(email);
            user.setName(name);
            userDao.save(user);
            userId = String.valueOf(user.getId());
        }
        catch (Exception ex) {
            return "Error creating the user: " + ex.toString();
        }
        return "User succesfully created with id = " + userId;
    }
}
