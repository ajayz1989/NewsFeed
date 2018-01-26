package com.newsfeed.model;

import java.util.Date;

/**
 * Created by ajayk297 on 20/01/18.
 */
public class GenericPost {

    private Integer postId;
    private String comment;
    private Date postedDate;
    private int upVote = 0;
    private int downVote = 0;
    private static int counter = 0;
    private String userName;

    public GenericPost(String comment, String userName) {
        this.comment = comment;
        this.userName = userName;
        postId = counter++;
        postedDate = new Date();
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(Date postedDate) {
        this.postedDate = postedDate;
    }

    public int getUpVote() {
        return upVote;
    }

    public void setUpVote() {
        this.upVote = upVote++;
    }

    public int getDownVote() {
        return downVote;
    }

    public void setDownVote() {
        this.downVote = downVote--;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("postId=").append(postId);
        sb.append(", comment='").append(comment).append('\'');
        sb.append(", postedDate=").append(postedDate);
        sb.append(", upVote=").append(upVote);
        sb.append(", downVote=").append(downVote);
        sb.append(", userName=").append(userName);
        return sb.toString();
    }
}
