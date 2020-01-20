package com.Herwaarden.Character.Model.FriendChat;

import java.util.ArrayList;
import java.util.List;

public class FriendsChatModel {
    List<FriendChatModel> friendChatList;

    public FriendsChatModel(){
        this.friendChatList = new ArrayList<>();
    }

    public List<FriendChatModel> getFriendChatList(){
        return friendChatList;
    }

    public void addFriendChatList(FriendChatModel friendChat){
        friendChatList.add(friendChat);
    }

}
