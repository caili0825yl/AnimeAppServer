package com.otaku_tamashi.app.Service.Imp;

import com.otaku_tamashi.app.Dao.UserLoginDOMapper;
import com.otaku_tamashi.app.POJO.DO.UserLoginDO;
import com.otaku_tamashi.app.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserLoginDOMapper userLoginDOMapper;

    @Override
    public String  login(String username,String password) {
        if(userLoginDOMapper.selectByLogin(username,password)==null){
            return "fail";
        }else {
            return "success";
        }
    }

    @Override
    public String register(UserLoginDO userLoginDO) {
        try {
            userLoginDOMapper.insert(userLoginDO);
            return "success";
        }catch (DuplicateKeyException e){
            return "fail";

        }
    }
}
