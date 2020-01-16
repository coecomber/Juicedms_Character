package com.Herwaarden.Character.Model.Friend;

public class FriendModel {

    private int friendOneId;
    private int friendTwoId;
    private String friendName;
    private String relationship;

    public FriendModel() {
    }

    public FriendModel(int friendOneId, int friendTwoId, String friendName, String relationship){
        this.friendOneId = friendOneId;
        this.friendTwoId = friendTwoId;
        this.friendName = friendName;
        this.relationship = relationship;
    }

    public void setFriendOneId(int friendId) {
        this.friendOneId = friendId;
    }

    public void setFriendTwoId(int friendId) {
        this.friendTwoId = friendId;
    }

    public int getFriendOneId() {
        return friendOneId;
    }

    public int getFriendTwoId() {
        return friendTwoId;
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
