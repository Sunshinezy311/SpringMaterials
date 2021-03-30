package zy.springmvc.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    String username;
    String password;
    Integer age;
    Date date;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "User{" +
                "uname='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", date=" + date +
                '}';
    }
}
