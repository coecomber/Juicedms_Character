package com.Herwaarden.Character.Model.Chat;

public class Message {
    private String usernameFriend;
    private String message;
    private boolean friendIsSender;

    public Message() {
    }

    public String getUsernameFriend() {
        return usernameFriend;
    }

    public void setUsernameFriend(String usernameFriend) {
        this.usernameFriend = usernameFriend;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isFriendIsSender() {
        return friendIsSender;
    }

    public void setFriendIsSender(boolean friendIsSender) {
        this.friendIsSender = friendIsSender;
    }
}
