package com.otaku_tamashi.app.Service.Imp;

import com.otaku_tamashi.app.Dao.NewsDOMapper;
import com.otaku_tamashi.app.Dao.NewsListDOMapper;
import com.otaku_tamashi.app.POJO.DO.NewsDO;
import com.otaku_tamashi.app.POJO.DO.NewsListDO;
import com.otaku_tamashi.app.Service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NewsServiceImp implements NewsService {
    @Autowired
    private NewsListDOMapper newsListDOMapper;
    @Autowired
    private NewsDOMapper newsDOMapper;
    @Override
    public List<NewsListDO> getList(String  type) {
        return  newsListDOMapper.selectByType(type);

    }

    @Override
    public NewsDO getContent(long id) {
        NewsDO list=newsDOMapper.selectByListId(id);
        return list;

    }
}
