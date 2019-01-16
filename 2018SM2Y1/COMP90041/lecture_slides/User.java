package cardemo;

/**
 * Copyright(c) 2018 Thomas Christy - All Rights Reserved.
 *
 * PROPRIETARY AND CONFIDENTIAL
 *
 * This file User.java was created within project CarDemo on 09/2018 for TC, LTD
 * by Thomas Christy.
 *
 * This software and all its assets is the proprietary information of Thomas
 * Christy <thomas@thomaschristy.co.uk>, unless otherwise stated.
 *
 * Unauthorized copying of this file or files under this project <CarDemo>, via
 * any medium is strictly prohibited, without written consent.
 *
 * @author Thomas Christy.
 */
public class User
{

    private static boolean user = false;
    private final String username; //search database
    private final String password; // search encrypted database

    public User(String username, String password)
    {
        this.username = username;// run sofisticated encryption
        this.password = password;
        user = true;
    }

    public static boolean varified()
    {
        return user;
    }

}
