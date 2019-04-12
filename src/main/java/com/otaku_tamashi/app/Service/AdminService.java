package com.otaku_tamashi.app.Service;

import com.otaku_tamashi.app.POJO.DO.*;

import java.util.List;

public interface AdminService {
    AdminDO login(String username, String password);  //登陆功能
    List<AnimeDO> getAnimeList();
    List<NewsListDO> getNewsList();
    void deleteNews(long id);
    void deleteAnime(long id);
    void addAnime(AnimeDO animeDO, AnimeDataDO animeDataDO);
    void addNews(NewsDO newsDO,NewsListDO newsListDO);
    void editAnime(AnimeDO animeDO, AnimeDataDO animeDataDO);
    void editNews(NewsDO newsDO,NewsListDO newsListDO);
    AnimeDO getAnimeList(long id);
    AnimeDataDO getAnime(long id);
    NewsListDO getNewsList(long id);
    NewsDO getNews(long id);
}
