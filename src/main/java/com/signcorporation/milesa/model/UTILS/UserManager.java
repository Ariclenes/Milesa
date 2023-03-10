/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.signcorporation.milesa.model.UTILS;

import MODELO.BEAN.User;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author AEM Sign corp
 */
public class UserManager {
    public static User get(String name) {
        try {
            File file = new File("user/" + name + ".properties");
            Properties properties = new Properties();

            FileInputStream inputStream = new FileInputStream(file);
            properties.load(inputStream);
            User user = new User();
            user.setUserName(name);
            user.setFullName(properties.getProperty("fullName"));
            user.setEmail(properties.getProperty("email"));
            user.setPassword(properties.getProperty("password"));
            return user;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void save(User user) {
        try {
            File file = new File("user/" + user.getUserName() + ".properties");
            Properties properties = new Properties();

            FileInputStream inputStream = new FileInputStream(file);
            properties.load(inputStream);

            FileOutputStream outputStream = new FileOutputStream(file);

            properties.setProperty("fullName", user.getFullName());
            properties.setProperty("email", user.getEmail());
            properties.setProperty("password", user.getPassword());
            properties.store(outputStream, "Update Section");
            properties.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




