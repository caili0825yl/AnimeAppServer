package com.otaku_tamashi.app.Service;

import com.otaku_tamashi.app.POJO.DO.UserLoginDO;

public interface UserService {
    String login(String username,String password);
    String register(UserLoginDO userLoginDO);
}
