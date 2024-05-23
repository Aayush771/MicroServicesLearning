package com.todo.restfulwebservices.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.todo.restfulwebservices.Models.User;
@Component
public class UserDAOService {

    private static List<User> userList = new ArrayList<>();

    static {
        userList.add(new User(1,"Ayush",LocalDate.now().minusYears(23)));
        userList.add(new User(2,"Mohan",LocalDate.now().minusYears(25)));
        userList.add(new User(3,"Rakesh",LocalDate.now().minusYears(27)));
        userList.add(new User(4,"Ramesh",LocalDate.now().minusYears(30)));
    }

    public List<User> findAll(){
        return userList;
    }
    public void save(User user){
         userList.add(user);
    }
    public User findById(Integer id){
        return userList.stream()
        .filter(user -> user.getUserId().equals(id))
        .findFirst()
        .orElse(null);
    }
    public User saveUser(User user) {
        // TODO Auto-generated method stub
        user.setUserId(userList.size()+1);
        save(user);
        return user;
    }
}

