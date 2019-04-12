package com.otaku_tamashi.app.Service.Imp;

import com.otaku_tamashi.app.Dao.FavouriteDOMapper;
import com.otaku_tamashi.app.POJO.DO.FavouriteDO;
import com.otaku_tamashi.app.Service.FavouriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FavouriteServiceImp implements FavouriteService {
    @Autowired
    private FavouriteDOMapper favouriteDOMapper;
    @Override
    public String add(String username, long id) {
        FavouriteDO favouriteDO=new FavouriteDO();
        favouriteDO.setListid(id);
        favouriteDO.setUsername(username);
        if(favouriteDOMapper.selectByUsernameAndListID(id,username)==null){
            favouriteDOMapper.insert(favouriteDO);
            return "success";
        }else {

            return "fail";
        }

    }

    @Override
    public void minus(String username, long id) {
        FavouriteDO favouriteDO=new FavouriteDO();
        favouriteDOMapper.deleteByUsernameAndId(id,username);
        return;
    }
}
