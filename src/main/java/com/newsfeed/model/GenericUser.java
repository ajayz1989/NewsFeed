package com.newsfeed.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ajayk297 on 20/01/18.
 */
public class GenericUser {

     private String userName;
     private String password;
     private Map<Integer, GenericPost> postList ;

    public GenericUser(String userName, String password) {
        this.userName = userName;
        this.password = password;
        postList = new HashMap<Integer, GenericPost>();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Map<Integer, GenericPost> getPostList() {
        return postList;
    }

    public void setPostList(Map<Integer, GenericPost> postList) {
        this.postList = postList;
    }
}
