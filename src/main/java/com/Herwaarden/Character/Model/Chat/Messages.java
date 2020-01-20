package com.Herwaarden.Character.Model.Chat;

import java.util.ArrayList;
import java.util.List;

public class Messages {
    List<Message> messages;

    public Messages(){
        this.messages = new ArrayList<>();
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
