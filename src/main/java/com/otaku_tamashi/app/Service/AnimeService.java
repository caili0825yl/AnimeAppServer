package com.otaku_tamashi.app.Service;

import com.otaku_tamashi.app.POJO.DO.AnimeDO;
import com.otaku_tamashi.app.POJO.DO.AnimeDataDO;

import java.util.List;

public interface AnimeService {
    List<AnimeDO> getList();
    AnimeDataDO getContent(long id);
    List<AnimeDO> getFavouriteList(String username);
}
