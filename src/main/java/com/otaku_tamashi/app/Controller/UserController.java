package com.otaku_tamashi.app.Controller;

import com.otaku_tamashi.app.POJO.DO.UserLoginDO;
import com.otaku_tamashi.app.Service.AnimeService;
import com.otaku_tamashi.app.Service.FavouriteService;
import com.otaku_tamashi.app.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private FavouriteService favouriteService;
    @RequestMapping("/register")
    public String  register(@RequestParam(name = "username") String username,@RequestParam(name = "password") String password){
        UserLoginDO userLoginDO=new UserLoginDO();
        String basePassword= Base64.getEncoder().encodeToString(password.getBytes(StandardCharsets.UTF_8));
        userLoginDO.setUsername(username);
        userLoginDO.setPassword(basePassword);
        String  result= userService.register(userLoginDO);
         return result;
    }


    @PostMapping("/login")
    public String login(@RequestParam(name = "username") String username,@RequestParam(name = "password") String password){
        String basePassword= Base64.getEncoder().encodeToString(password.getBytes(StandardCharsets.UTF_8));

        String result= userService.login(username,basePassword);
        return result;
    }

    @PostMapping("/add")
    public String add(@RequestParam(name = "username") String username,@RequestParam(name = "anime") String anime){
        long id=Long.parseLong(anime);
        String result=favouriteService.add(username,id);
        return result;
    }
    @PostMapping("/minus")
    public void minus(@RequestParam(name = "username") String username,@RequestParam(name = "anime") String anime){
        long id=Long.parseLong(anime);
        favouriteService.minus(username,id);
        return ;
    }
}
