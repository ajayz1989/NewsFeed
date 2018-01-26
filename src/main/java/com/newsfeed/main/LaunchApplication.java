package com.newsfeed.main;

import com.newsfeed.controller.CommandDelegator;
import com.newsfeed.exception.InvalidCommandExeption;
import com.newsfeed.exception.InvalidUserException;
import com.newsfeed.exception.NoUserLoggedInException;
import com.newsfeed.model.InputCommand;
import com.newsfeed.util.CommandUtil;

import java.util.Scanner;

/**
 * Created by ajayk297 on 20/01/18.
 */
public class LaunchApplication {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        while (true) {
            System.out.println("Enter any command to start - ");
            String command = sc.next();

            try {
                InputCommand inputCommand = CommandUtil.validateAndGetCommand(command);
                if (inputCommand == null ){
                    throw new InvalidCommandExeption("Please enter a valid command");
                }
                String response = CommandDelegator.delegateDesiredOperation(inputCommand);
                System.out.println("Response - " + response);

            } catch (InvalidUserException e) {
                e.printStackTrace();
            } catch (NoUserLoggedInException e) {
                e.printStackTrace();
            } catch (InvalidCommandExeption invalidCommandExeption) {
                invalidCommandExeption.printStackTrace();
            }


        }
    }
}
