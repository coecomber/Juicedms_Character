package com.Herwaarden.Character.Model.Friend;

import java.util.ArrayList;
import java.util.List;

public class FriendsModel {

    private List<FriendModel> friendModelList;

    public FriendsModel(){
        friendModelList = new ArrayList<>();
    }

    public List<FriendModel> getFriendModelList() {
        return friendModelList;
    }

    public void setFriendModelList(List<FriendModel> friendModelList) {
        this.friendModelList = friendModelList;
    }

    public void addFriendModelListItem(FriendModel friendModel){
        friendModelList.add(friendModel);
    }
}
