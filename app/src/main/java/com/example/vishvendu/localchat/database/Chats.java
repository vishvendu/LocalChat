package com.example.vishvendu.localchat.database;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by vishvendu on 23/11/17.
 */


@Entity
public class Chats {

    @Id(autoincrement = true)
    private Long id;

    @NotNull
    private String chatDataUserOne;

    @NotNull
    private String chatDataRandomeUser;

    private Long ChatId;

    @Generated(hash = 283155396)
    public Chats(Long id, @NotNull String chatDataUserOne,
            @NotNull String chatDataRandomeUser, Long ChatId) {
        this.id = id;
        this.chatDataUserOne = chatDataUserOne;
        this.chatDataRandomeUser = chatDataRandomeUser;
        this.ChatId = ChatId;
    }

    @Generated(hash = 2133557250)
    public Chats() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChatDataUserOne() {
        return this.chatDataUserOne;
    }

    public void setChatDataUserOne(String chatDataUserOne) {
        this.chatDataUserOne = chatDataUserOne;
    }

    public String getChatDataRandomeUser() {
        return this.chatDataRandomeUser;
    }

    public void setChatDataRandomeUser(String chatDataRandomeUser) {
        this.chatDataRandomeUser = chatDataRandomeUser;
    }

    public Long getChatId() {
        return this.ChatId;
    }

    public void setChatId(Long ChatId) {
        this.ChatId = ChatId;
    }




 





}
