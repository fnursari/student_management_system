package com.project.schoolmanagment.utils;

public class Messages {

    private Messages() { //-- not the created any instance this constructor. You can make it also abstract class(another possibility).
    }

    public static final String NOT_PERMITTED_METHOD_MESSAGE = "You do not have any permission to do this operation";
    public static final String NOT_FOUND_USER_MESSAGE = "Error: User not found with id %s";

    public static final String ROLE_NOT_FOUND = "There is no role like that, check the database";
    public static final String ROLE_ALREADY_EXIST = "Role already exist in DB";

    public static final String ALREADY_REGISTER_MESSAGE_USERNAME = "Error: User with username %s is already registered";//-- we use like String.format(message, variable)
    public static final String ALREADY_REGISTER_MESSAGE_SSN = "Error: User with ssn %s is already registered";
    public static final String ALREADY_REGISTER_MESSAGE_PHONE_NUMBER = "Error: User with phone number %s is already registered";
    public static final String ALREADY_REGISTER_MESSAGE_EMAIL = "Error: User with email %s is already registered";
    //Shortcut -> CTRL+SHIFT+U --> Turn the uppercase
    public static final String ALREADY_SEND_A_MESSAGE_TODAY = "Error: You have already send a message with this e-mail";
}
