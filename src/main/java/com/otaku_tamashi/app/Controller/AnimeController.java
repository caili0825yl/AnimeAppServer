package com.otaku_tamashi.app.Controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.otaku_tamashi.app.POJO.DO.AnimeDO;
import com.otaku_tamashi.app.POJO.DO.AnimeDataDO;
import com.otaku_tamashi.app.Service.AnimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/anime")
public class AnimeController {
    @Autowired
    private AnimeService animeService;

    @RequestMapping("getlist")
    public List<AnimeDO> getList(@RequestParam(name = "start")Integer start){
        PageHelper.startPage(start,5);
        List<AnimeDO> list=animeService.getList();
        return new PageInfo<AnimeDO>(list).getList();
    }

    @RequestMapping("getcontent")
    public AnimeDataDO getContent(@RequestParam(name = "listid")long id){
        AnimeDataDO animeDataDO=animeService.getContent(id);
        return animeDataDO;
    }

    @RequestMapping("getfavouritelist")
    public List<AnimeDO> getFavouriteList(@RequestParam(name = "start")Integer start,@RequestParam(name = "username") String username){
        PageHelper.startPage(start,5);
        List<AnimeDO> list=animeService.getFavouriteList(username);
        return new PageInfo<AnimeDO>(list).getList();
    }
}
