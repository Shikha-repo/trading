package com.tradingApp.trading.services;

import com.tradingApp.trading.model.user.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {
    private List<User> userList=new ArrayList<>();

   public UserService(){
       User user1= User.builder()
               .userId("1")
               .email("abc@gmail.com")
               .name("user1")
               .build();
       User user2= User.builder()
               .userId("2")
               .email("rjfhj@gmail.com")
               .name("user2")
               .build();
       User user3= User.builder()
               .userId("3")
               .email("ijiiu@gmail.com")
               .name("user3")
               .build();
       userList.addAll(Arrays.asList(user1,user2,user3));
   }
   public List<User> getUserList(){
       return userList;
   }
}
