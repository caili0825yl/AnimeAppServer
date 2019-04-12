package com.otaku_tamashi.app.Service;

import com.otaku_tamashi.app.POJO.DO.NewsDO;
import com.otaku_tamashi.app.POJO.DO.NewsListDO;

import java.util.List;

public interface NewsService {
    List<NewsListDO> getList(String type);
    NewsDO getContent(long id);
}
