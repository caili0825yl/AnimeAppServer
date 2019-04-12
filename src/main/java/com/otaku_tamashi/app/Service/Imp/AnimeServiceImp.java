package com.otaku_tamashi.app.Service.Imp;

import com.otaku_tamashi.app.Dao.AnimeDOMapper;
import com.otaku_tamashi.app.Dao.AnimeDataDOMapper;
import com.otaku_tamashi.app.Dao.FavouriteDOMapper;
import com.otaku_tamashi.app.POJO.DO.AnimeDO;
import com.otaku_tamashi.app.POJO.DO.AnimeDataDO;
import com.otaku_tamashi.app.Service.AnimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class AnimeServiceImp implements AnimeService {
    @Autowired
    private AnimeDataDOMapper AnimeDataDOMapper;
@Autowired
private AnimeDOMapper animeDOMapper;
@Autowired
private FavouriteDOMapper favouriteDOMapper;
    @Override
    public AnimeDataDO getContent(long id) {
        AnimeDataDO animeDataDO=AnimeDataDOMapper.selectByListID(id);
        return animeDataDO;
    }

    @Override
    public List<AnimeDO> getList() {

        return animeDOMapper.selectAll();
    }

    @Override
    public List<AnimeDO> getFavouriteList(String username) {
     List<Long> list=favouriteDOMapper.selectFav(username);

     List<AnimeDO> animelist=new ArrayList<>();
     for(int n=0;n<list.size();n++){
         AnimeDO animeDO=animeDOMapper.selectByPrimaryKey(list.get(n));
         animelist.add(animeDO);
     }
     return animelist;
    }
}
