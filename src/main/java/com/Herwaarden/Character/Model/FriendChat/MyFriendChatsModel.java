package com.Herwaarden.Character.Model.FriendChat;

import java.util.ArrayList;
import java.util.List;

public class MyFriendChatsModel {
    List<MyFriendChatModel> friendChatList;

    public MyFriendChatsModel() {
        this.friendChatList = new ArrayList<>();
    }

    public List<MyFriendChatModel> getFriendChatList() {
        return friendChatList;
    }
}
