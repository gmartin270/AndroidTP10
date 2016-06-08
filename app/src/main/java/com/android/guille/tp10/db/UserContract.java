package com.android.guille.tp10.db;

import android.provider.BaseColumns;

/**
 * Created by Guille on 14/05/2016.
 */
public class UserContract {

    public static final String DBNAME = "userDB";
    public static final Integer VERSION = 1;

    public UserContract(){};

    public static abstract class ChatTable implements BaseColumns {
        public static final String TABLE_NAME = "chat";
        public static final String MONGO_ID = "mongo_id";
        public static final String TO = "toUser";
        public static final String DATE = "date";
        public static final String MSG = "msg";
        public static final String FROM = "fromUser";
        public static final String TABLE_CREATE = " CREATE TABLE " + TABLE_NAME + " (" +
                                                    _ID + " INTEGER PRIMARY KEY, " +
                                                    TO + " TEXT, " +
                                                    DATE + " DATE, " +
                                                    MSG + " TEXT, " +
                                                    FROM + " TEXT, " +
                                                    MONGO_ID + " TEXT );";


    }

    public static abstract class MsgTable implements BaseColumns {
        public static final String TABLE_NAME = "msg";
        public static final String MONGO_ID = "mongo_id";
        public static final String MSG = "msg";
        public static final String DATE = "date";
        public static final String CHAT = "chat";
        public static final String FROM = "fromUser";
        public static final String TABLE_CREATE = " CREATE TABLE " + TABLE_NAME + " (" +
                                                    _ID + " INTEGER PRIMARY KEY, " +
                                                    MSG + " TEXT, " +
                                                    DATE + " DATE, " +
                                                    CHAT + " TEXT, " +
                                                    FROM + " TEXT, " +
                                                    MONGO_ID + " TEXT );";
    }
}
