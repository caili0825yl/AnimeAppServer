package com.otaku_tamashi.app.Service;

public interface FavouriteService {
    String  add(String username,long id);
    void   minus(String username,long id);
}
