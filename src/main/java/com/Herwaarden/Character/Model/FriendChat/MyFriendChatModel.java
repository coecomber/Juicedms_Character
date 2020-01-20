package com.Herwaarden.Character.Model.FriendChat;

public class MyFriendChatModel {
    private int friendId;
    private boolean friendIsSender;
    private String message;

    public MyFriendChatModel() {
    }

    public int getFriendId() {
        return friendId;
    }

    public void setFriendId(int friendId) {
        this.friendId = friendId;
    }

    public boolean isFriendIsSender() {
        return friendIsSender;
    }

    public void setFriendIsSender(boolean friendIsSender) {
        this.friendIsSender = friendIsSender;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
