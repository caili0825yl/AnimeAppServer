package com.otaku_tamashi.app.Controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.otaku_tamashi.app.Dao.AdminDOMapper;
import com.otaku_tamashi.app.POJO.DO.*;
import com.otaku_tamashi.app.Service.AdminService;
import com.otaku_tamashi.app.Service.AnimeService;
import com.otaku_tamashi.app.Service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.swing.plaf.synth.SynthTabbedPaneUI;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.List;

@Controller
@CrossOrigin(allowCredentials = "true",allowedHeaders = "true")
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private HttpSession httpSession;

    @RequestMapping("/")
    public String Admin(){

            return "Login";



    }

    @RequestMapping("/login")
    @ResponseBody
    public boolean login(@RequestParam(name = "username") String username,@RequestParam(name = "password") String password){
        boolean exist;
        String base64password= Base64.getEncoder().encodeToString(password.getBytes(StandardCharsets.UTF_8));
        AdminDO adminDO=adminService.login(username,base64password);
        if(adminDO==null){
            exist=false;
        }else
        {
            exist=true;
        }
        if (exist){
            httpSession.setAttribute("IS_LOGIN",true);
            return true;

        }else {

            return false;

        }
    }
@RequestMapping("/view")
    public String view(){
    if((boolean)httpSession.getAttribute("IS_LOGIN")==true){
        return "Admin";
    }else
        return "Error";

}


    @RequestMapping("/edit")
    public String edit(){
        return "Edit";
    }
    @ResponseBody
    @RequestMapping("/getanimelist")
    public List<AnimeDO> getAnimeList(@RequestParam(name = "page") int page){
        PageHelper.startPage(page,10);
        List<AnimeDO> list=adminService.getAnimeList();
        PageInfo<AnimeDO> pageinfo=new PageInfo<>(list);


        if(pageinfo.isIsFirstPage()&&pageinfo.isIsLastPage()){
            httpSession.setAttribute("page","both");
        }else  if( pageinfo.isIsFirstPage()){
            httpSession.setAttribute("page","first");
        }else if(pageinfo.isIsLastPage()){
            httpSession.setAttribute("page","last");
        }else  {
            httpSession.setAttribute("page","normal");
        }
        httpSession.setAttribute("last",pageinfo.getPages());

        return  pageinfo.getList();

    }

    @ResponseBody
    @RequestMapping("/getnewslist")
    public List<NewsListDO> getNewsList(@RequestParam(name = "page") int page){
        PageHelper.startPage(page,10);
    List<NewsListDO> list=adminService.getNewsList();
    PageInfo<NewsListDO> pageinfo=new PageInfo<>(list);
        if(pageinfo.isIsFirstPage()&&pageinfo.isIsLastPage()){
            httpSession.setAttribute("page","both");
        }else
        if( pageinfo.isIsFirstPage()){
            httpSession.setAttribute("page","first");
        }else if(pageinfo.isIsLastPage()){
            httpSession.setAttribute("page","last");
        }else {
            httpSession.setAttribute("page","normal");

        }
        httpSession.setAttribute("last",pageinfo.getPages());
        return  pageinfo.getList();
    }

    @ResponseBody
    @RequestMapping("/getsession")
    public String getSession(){
        String session=(String)httpSession.getAttribute("page");
        return session;
    }
    @ResponseBody
    @RequestMapping("/getlast")
    public int getLast(){
        int session=(int)httpSession.getAttribute("last");
        return session;
    }

    @RequestMapping("/delete")
    public String  delete(@RequestParam(name ="type") String  type,@RequestParam(name ="id") long id){
        if("anime".equals(type)){
            adminService.deleteAnime(id);
        }else {
            adminService.deleteNews(id);
        }
        return "Delete";
    }

    @RequestMapping("/addnewsview")
    public String  addNewsView(){
        if((boolean)httpSession.getAttribute("IS_LOGIN")==true){
            return "AddNews";
        }else
            return "Error";
    }

    @RequestMapping("/addanimeview")
    public String  addAnimeView(){
        if((boolean)httpSession.getAttribute("IS_LOGIN")==true){
            return "AddAnime";
        }else
            return "Error";
    }
    @RequestMapping("/newsedit")
    public String  newsedit(@RequestParam(name ="id") long id){
        return "AddNews";
    }
    @RequestMapping("/animeedit")
    public String  animeedit(@RequestParam(name ="id") long id){
        return "AddAnime";
    }
    @RequestMapping("/addanime")
    public String addAnime(@RequestParam(name = "name")String name,@RequestParam(name = "tv")String tv,
                           @RequestParam(name = "platform")String platform,@RequestParam(name = "staff")String staff,
                           @RequestParam(name = "voice")String voice,@RequestParam(name = "js")String js,
                           @RequestParam(name = "font")String font,@RequestParam(name = "image")String image
            ,@RequestParam(name = "url")String url){
            AnimeDO animeDO=new AnimeDO();
        AnimeDataDO animeDataDO=new AnimeDataDO();
        animeDO.setFont(font);
        animeDO.setName(name);
        animeDO.setUrl(url);
        animeDO.setPlatform(platform);
        animeDO.setDate(new Date());
        animeDataDO.setImage(image);
        animeDataDO.setJs(js);
        animeDataDO.setName(name);
        animeDataDO.setStaff(staff);
        animeDataDO.setTv(tv);
        animeDataDO.setVoice(voice);
            adminService.addAnime(animeDO,animeDataDO);

        return "Edit";
    }
    @RequestMapping("/addnews")
    public String addNews(@RequestParam(name = "title")String title,@RequestParam(name = "ltitle")String ltitle,
                           @RequestParam(name = "type")String type,@RequestParam(name = "font")String font,
                           @RequestParam(name = "content")String content,@RequestParam(name = "image")String image
           ){
        NewsListDO newsListDO=new NewsListDO();
        NewsDO newsDO=new NewsDO();
        newsDO.setContent(content);
        newsDO.setImage(image);
        newsDO.setLtitle(ltitle);
        newsDO.setTitle(title);
        newsListDO.setDate(new Date());
        newsListDO.setFont(font);
        newsListDO.setTitle(title);
        newsListDO.setType(type);
        adminService.addNews(newsDO,newsListDO);

        return "Edit";
    }
    @ResponseBody
    @RequestMapping("/getanimedata")
    public AniDo getAnimeData(@RequestParam(name = "id") String id){
        long newId=Long.parseLong(id);
        AnimeDO animeDO=adminService.getAnimeList(newId);
        AnimeDataDO animeDataDO=adminService.getAnime(animeDO.getId());
        AniDo aniDo=new AniDo();
        aniDo.setImage(animeDataDO.getImage());
       aniDo.setJs(animeDataDO.getJs());
       aniDo.setName(animeDataDO.getName());
       aniDo.setFont(animeDO.getFont());
       aniDo.setPlatform(animeDO.getPlatform());
       aniDo.setStaff(animeDataDO.getStaff());
       aniDo.setVoice(animeDataDO.getVoice());
       aniDo.setUrl(animeDO.getUrl());
       aniDo.setTv(animeDataDO.getTv());
       return aniDo;

    }
    @ResponseBody
    @RequestMapping("/getnewsdata")
    public NewsDataDo getNewsData(@RequestParam(name = "id") String id){
            long newId=Long.parseLong(id);
            NewsListDO newsListDO=adminService.getNewsList(newId);
            NewsDO newsDO=adminService.getNews(newsListDO.getId());
            NewsDataDo newsDataDo=new NewsDataDo();
            newsDataDo.setFont(newsListDO.getFont());
            newsDataDo.setType(newsListDO.getType());
            newsDataDo.setContent(newsDO.getContent());

            newsDataDo.setImage(newsDO.getImage());
            newsDataDo.setLtitle(newsDO.getLtitle());
            newsDataDo.setTitle(newsDO.getTitle());
            return newsDataDo;
    }

    @RequestMapping("/editnews")
    public String editNews(@RequestParam(name = "title")String title,@RequestParam(name = "ltitle")String ltitle,
                          @RequestParam(name = "type")String type,@RequestParam(name = "font")String font,
                          @RequestParam(name = "content")String content,@RequestParam(name = "image")String image
            ,@RequestParam(name = "id")String id ){
        long newId=Long.parseLong(id);
        NewsListDO newsListDO=new NewsListDO();
        newsListDO.setId(newId);
        NewsDO newsDO=new NewsDO();
        newsDO.setContent(content);
        newsDO.setImage(image);
        newsDO.setLtitle(ltitle);
        newsDO.setTitle(title);
        newsListDO.setDate(new Date());
        newsListDO.setFont(font);
        newsListDO.setTitle(title);
        newsListDO.setType(type);
        adminService.editNews(newsDO,newsListDO);

        return "Edit";
    }
    @RequestMapping("/editanime")
    public String editAnime(@RequestParam(name = "name")String name,@RequestParam(name = "tv")String tv,
                           @RequestParam(name = "platform")String platform,@RequestParam(name = "staff")String staff,
                           @RequestParam(name = "voice")String voice,@RequestParam(name = "js")String js,
                           @RequestParam(name = "font")String font,@RequestParam(name = "image")String image
            ,@RequestParam(name = "url")String url,@RequestParam(name = "id")String id){
       long newId=Long.parseLong(id);
        AnimeDO animeDO=new AnimeDO();
        AnimeDataDO animeDataDO=new AnimeDataDO();
        animeDO.setFont(font);
        animeDO.setName(name);
        animeDO.setUrl(url);
        animeDO.setPlatform(platform);
        animeDO.setDate(new Date());
        animeDO.setId(newId);
        animeDataDO.setImage(image);
        animeDataDO.setJs(js);
        animeDataDO.setName(name);
        animeDataDO.setStaff(staff);
        animeDataDO.setTv(tv);
        animeDataDO.setVoice(voice);
        adminService.editAnime(animeDO,animeDataDO);

        return "Edit";
    }
}
