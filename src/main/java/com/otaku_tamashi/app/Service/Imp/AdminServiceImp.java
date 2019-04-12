package com.otaku_tamashi.app.Service.Imp;

import com.otaku_tamashi.app.Dao.*;
import com.otaku_tamashi.app.POJO.DO.*;
import com.otaku_tamashi.app.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImp  implements AdminService {
    @Autowired
    private AdminDOMapper adminDOMapper;
    @Autowired
    private AnimeDOMapper animeDOMapper;
    @Autowired
    private NewsListDOMapper newsListDOMapper;
    @Autowired
    private AnimeDataDOMapper animeDataDOMapper;
    @Autowired
    private NewsDOMapper newsDOMapper;
    @Override
    public AdminDO login(String username, String password) {
        AdminDO adminDO=adminDOMapper.selectByAdminnameAndPassword(username,password);
        if(adminDO==null){

            return null;
        }else {

            return adminDO;
        }
    }

    @Override
    public List<AnimeDO> getAnimeList() {
        return animeDOMapper.selectAll();

    }

    @Override
    public List<NewsListDO> getNewsList() {
        return  newsListDOMapper.selectAll();
    }

    @Override
    public void deleteNews(long id) {
        newsListDOMapper.deleteByPrimaryKey(id);
        return;
    }

    @Override
    public void deleteAnime(long id) {
        animeDOMapper .deleteByPrimaryKey(id);
        return;
    }

    @Override
    public void addAnime(AnimeDO animeDO, AnimeDataDO animeDataDO) {
        animeDOMapper.insert(animeDO);
        long id=animeDOMapper.selectByName(animeDO.getName());
        animeDataDO.setListId(id);
        animeDataDOMapper.insert(animeDataDO);
        return;
    }

    @Override
    public void addNews(NewsDO newsDO, NewsListDO newsListDO) {
        newsListDOMapper.insert(newsListDO);
        long id=newsListDOMapper.selectByTitle(newsDO.getTitle());

        newsDO.setListId(id);
        newsDOMapper.insert(newsDO);
        return;
    }

    @Override
    public AnimeDO getAnimeList(long id) {
        AnimeDO animeDO=animeDOMapper.selectByPrimaryKey(id);

        return animeDO;
    }

    @Override
    public AnimeDataDO getAnime(long id) {
        AnimeDataDO animeDataDO=animeDataDOMapper.selectByListID(id);
        return animeDataDO;
    }

    @Override
    public NewsListDO getNewsList(long id) {
        NewsListDO newsListDO=newsListDOMapper.selectByPrimaryKey(id);
        return newsListDO;
    }

    @Override
    public NewsDO getNews(long id) {
        NewsDO newsDO=newsDOMapper.selectByListId(id);
        return newsDO;
    }

    @Override
    public void editAnime(AnimeDO animeDO, AnimeDataDO animeDataDO) {
        animeDOMapper.updateByPrimaryKey(animeDO);
        long listid=animeDOMapper.selectByName(animeDO.getName());
        long id=animeDataDOMapper.selectByListID(listid).getId();
        animeDataDO.setListId(listid);
        animeDataDO.setId(id);
        animeDataDOMapper.updateByPrimaryKey(animeDataDO);
        return;
    }

    @Override
    public void editNews(NewsDO newsDO, NewsListDO newsListDO) {
        newsListDOMapper.updateByPrimaryKey(newsListDO);
        long listid=newsListDOMapper.selectByTitle(newsDO.getTitle());
        long id=newsDOMapper.selectByListId(listid).getId();
        newsDO.setListId(listid);
        newsDO.setId(id);
        newsDOMapper.updateByPrimaryKey(newsDO);
        return;
    }
}
