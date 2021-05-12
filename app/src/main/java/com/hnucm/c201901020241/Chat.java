package com.hnucm.c201901020241;

import java.util.List;

public class Chat {

    public List<ChatlistDTO> chatlist;


    public static class ChatlistDTO {
        public String head;
        public String name;
        public String content;
        public String time;
    }
}
