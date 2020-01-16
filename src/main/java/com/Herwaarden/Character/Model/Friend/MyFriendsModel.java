package com.Herwaarden.Character.Model.Friend;

import java.util.ArrayList;
import java.util.List;

public class MyFriendsModel {

    private List<MyFriendModel> myFriendModelList;

    public MyFriendsModel(){
        myFriendModelList = new ArrayList<>();
    }

    public List<MyFriendModel> getFriendModelList() {
        return myFriendModelList;
    }

    public void setFriendModelList(List<MyFriendModel> friendModelList) {
        this.myFriendModelList = friendModelList;
    }

    public void addFriendModelListItem(MyFriendModel friendModel){
        myFriendModelList.add(friendModel);
    }
}
