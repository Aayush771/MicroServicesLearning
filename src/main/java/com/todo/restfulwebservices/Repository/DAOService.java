package com.todo.restfulwebservices.Repository;


import com.todo.restfulwebservices.Entity.User;
import com.todo.restfulwebservices.Exception.UserNotFoundException;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class DAOService {
 private static  List<User> userList = new ArrayList<>();
 private  static  Integer userCount = 0;

    static {
        userList.add(new User(++userCount,"Mandan", LocalDate.now().minusYears(30)));
        userList.add(new User(++userCount,"Selvie", LocalDate.now().minusDays(15).minusYears(13)));
        userList.add(new User(++userCount,"Lokie", LocalDate.now().minusDays(48).minusYears(87)));
        userList.add(new User(++userCount,"Mobius", LocalDate.now().minusDays(75).minusYears(43)));
        userList.add(new User(++userCount,"He Who Remains!", LocalDate.now().minusDays(1500).minusYears(150)));
        userList.add(new User(++userCount,"KING", LocalDate.now().minusDays(100).minusYears(10)));
    }
    public List<User> findAllUsers(){
        return userList;
    }
    public User findUserById(Integer id){
       return  userList.stream()
                .filter(element -> Objects.equals(element.getUserId(), id)) // Example condition: starts with "B"
                .findFirst().orElseThrow(()-> new UserNotFoundException("User Not found with this id- "+id));
       // return result.get();
    }


    /**
     * Saves a user by incrementing the user count and adding the user to the user list.
     *
     * @param  user  the user to be saved
     * @return       the saved user
     */
    public  User saveUser(User user){
        user.setUserId(++userCount);
        userList.add(user);
        return user;
    }

}

