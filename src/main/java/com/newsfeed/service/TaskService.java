package com.newsfeed.service;

import com.newsfeed.exception.InvalidUserException;
import com.newsfeed.exception.NoPostExistWithTheIDException;
import com.newsfeed.model.GenericPost;
import com.newsfeed.model.GenericUser;

import java.util.*;

/**
 * Created by ajayk297 on 20/01/18.
 */
public class TaskService {

    private static Map<String, GenericUser> userData = new HashMap<String, GenericUser>();
    private static Map<Integer, GenericPost> postData = new TreeMap<Integer, GenericPost>();
    private Scanner sc = new Scanner(System.in);
    public static String userName = null;

    public String signupUser(){
        System.out.println("Enter userName - ");
        String userName = sc.next();
        if (userData.containsKey(userName)){
            return "User already Exist";
        }
        userData.put(userName, new GenericUser(userName,userName));
        return "Successfully created new user";
    }

    public String loginUser() throws InvalidUserException {
        System.out.println("Enter userName - ");
        String userName = sc.next();
        if (userData.containsKey(userName)){
            this.userName = userName;
            return userName ;
        }else throw new InvalidUserException("User not exist");
    }

    public String postComment(String userName) {
        System.out.println("Enter Post - ");
        String postComment = sc.next();
        GenericPost post = new GenericPost(postComment,userName);
        postData.put(post.getPostId(), post);
        return "Post added successfully";
    }

    public String showNewsFeed() {
        final StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, GenericPost> entry : postData.entrySet()){
            sb.append(entry.getValue().toString());
            sb.append("\n\n\n");
        }
        return sb.toString();
    }

    public String upVoteComment() {
        System.out.println("Enter postid to upvote- ");
        try {
            int postId = sc.nextInt();
            GenericPost post = postData.get(postId);
            if (post == null) {
                throw new NoPostExistWithTheIDException("No post found");
            }
            post.setUpVote();
        }catch (NoPostExistWithTheIDException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return "Upvoted successfully";

    }

    public String downVoteComment() {

        System.out.println("Enter postid to downvote- ");
        try {
            int postId = sc.nextInt();
            GenericPost post = postData.get(postId);
            if (post == null) {
                throw new NoPostExistWithTheIDException("No post found");
            }
            post.setDownVote();
        }catch (NoPostExistWithTheIDException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return "Downvoted successfully";
    }
}
