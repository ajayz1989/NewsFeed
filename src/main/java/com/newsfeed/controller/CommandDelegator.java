package com.newsfeed.controller;

import com.newsfeed.exception.InvalidUserException;
import com.newsfeed.exception.NoUserLoggedInException;
import com.newsfeed.model.GenericUser;
import com.newsfeed.model.InputCommand;
import com.newsfeed.service.TaskService;

/**
 * Created by ajayk297 on 20/01/18.
 */
public class CommandDelegator {


    public static String delegateDesiredOperation(InputCommand command) throws InvalidUserException, NoUserLoggedInException {

        TaskService service = new TaskService();
        switch (command)
        {
            case SIGNUP:
                return service.signupUser();
            case LOGOUT:
                return "User logged out successfully";
            case LOGIN:
                 String userName = service.loginUser();
                return "User *" + userName + "* logged in successfully";
            case POST:
                String user = service.userName;
                if (user == null) throw new NoUserLoggedInException("Please login first to post");
                return service.postComment(user);
            case UPVOTE:
                service.upVoteComment();
            case DOWNVOTE:
                service.downVoteComment();
            case FOLLOW:
                break;
            case REPLY:
                break;
            case SHOWNEWSFEED:
                return service.showNewsFeed();
        }
        return null;
    }
}
