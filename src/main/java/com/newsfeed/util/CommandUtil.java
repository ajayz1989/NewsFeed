package com.newsfeed.util;

import com.newsfeed.model.InputCommand;

/**
 * Created by ajayk297 on 20/01/18.
 */
public class CommandUtil {


    public static InputCommand validateAndGetCommand(String inputString){
        for (InputCommand command : InputCommand.values()){
            if (inputString.equalsIgnoreCase(command.name())){
                return command;
            }
        }
        return null;
    }

}
