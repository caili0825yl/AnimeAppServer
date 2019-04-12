package com.otaku_tamashi.app.Controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.otaku_tamashi.app.POJO.DO.NewsDO;
import com.otaku_tamashi.app.POJO.DO.NewsListDO;
import com.otaku_tamashi.app.Service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {
    @Autowired
    private NewsService newsService;

    @RequestMapping("/getlist")
    public List<NewsListDO> getList(@RequestParam(name = "start")Integer start,@RequestParam(name = "type") String  type,@RequestParam(name = "page")Integer page){
        PageHelper.startPage(start,page);
        List<NewsListDO> list=newsService.getList(type);
        return new PageInfo<NewsListDO>(list).getList();


    }

    @RequestMapping("/getcontent")
    public NewsDO getContent(@RequestParam(name = "listid") long  id){
        NewsDO newsDO=newsService.getContent(id);
        return newsDO;
    }

}
