package com.Herwaarden.Character.Model.Friend;

public class MyFriendModel {
    private int friendId;
    private String friendName;
    private String relationship;

    public MyFriendModel() {
    }

    public MyFriendModel(int friendId, String friendName, String relationship){
        this.friendId = friendId;
        this.friendName = friendName;
        this.relationship = relationship;
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

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }
}
