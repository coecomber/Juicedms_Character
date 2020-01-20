package com.Herwaarden.Character.Logic;

import com.Herwaarden.Character.Model.Chat.Message;
import com.Herwaarden.Character.Model.Chat.Messages;
import com.Herwaarden.Character.Model.FriendChat.MyFriendChatModel;
import com.Herwaarden.Character.Model.FriendChat.MyFriendChatsModel;

public class ChatLogic {

    public ChatLogic(){

    }

    public Messages getChatMessages(MyFriendChatsModel myFriendChatsModel){
        Messages messages = new Messages();

        for(MyFriendChatModel myFriendChatModel : myFriendChatsModel.getFriendChatList()){
            Message message = new Message();
            message.setMessage(myFriendChatModel.getMessage());
            if(myFriendChatModel.isFriendIsSender()){
                message.setFriendIsSender(true);
            } else {
                message.setFriendIsSender(false);
            }

            CharacterLogic characterLogic = new CharacterLogic();

            message.setUsernameFriend(characterLogic.getCharacterById(myFriendChatModel.getFriendId()).getName());
            messages.getMessages().add(message);
        }

        return messages;
    }
}
