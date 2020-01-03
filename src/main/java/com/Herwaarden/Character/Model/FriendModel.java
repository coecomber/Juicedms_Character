package com.Herwaarden.Character.Model;

public class FriendModel {

    public int friendId;
    public String friendName;

    public FriendModel() {
    }

    public FriendModel(int friendId, String friendName){
        this.friendId = friendId;
        this.friendName = friendName;
    }

    public int getFriendId() {
        return friendId;
    }

    public void setFriendId(int friendId) {
        this.friendId = friendId;
    }

    public String getFriendName() {
        return friendName;
    }

    public void setFriendName(String friendName) {
        this.friendName = friendName;
    }
}
