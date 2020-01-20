package com.Herwaarden.Character.Logic.Resource;

import com.Herwaarden.Character.CharacterApplication;
import com.Herwaarden.Character.Logic.CharacterLogic;
import com.Herwaarden.Character.Logic.ChatLogic;
import com.Herwaarden.Character.Model.Character.CharacterModel;
import com.Herwaarden.Character.Model.Chat.Messages;
import com.Herwaarden.Character.Model.FriendChat.MyFriendChatModel;
import com.Herwaarden.Character.Model.FriendChat.MyFriendChatsModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class CharacterResource {

    // How to make REST at least level 2:
    // https://martinfowler.com/articles/richardsonMaturityModel.html#level0


    @Autowired
    private RestTemplate restTemplate;

    //Get a list of characters of logged in player.
    @CrossOrigin(origins = {"*"})
    @GetMapping("/public/characters/get/{email}")
    public List<CharacterModel> getCharacters(@PathVariable("email") String email){
        CharacterLogic characterLogic = new CharacterLogic();
        List<CharacterModel> charactersModels = characterLogic.getMyCharactersByEmail(email);

        for(CharacterModel characterModel : charactersModels){
            System.out.println(characterModel.getId());
        }

        return charactersModels;
    }

    //Get a single character by id.
    @CrossOrigin(origins = {"*"})
    @GetMapping("/public/character/{characterId}")
    public CharacterModel getCharacter(@PathVariable("characterId") int characterId){
        CharacterLogic characterLogic = new CharacterLogic();

        return characterLogic.getCharacterById(characterId);
    }

    //Get a single character by name.
    @CrossOrigin(origins = {"*"})
    @GetMapping("/public/character/getbyname/{characterName}")
    public CharacterModel getCharacterByName(@PathVariable("characterName") String characterName){
        CharacterLogic characterLogic = new CharacterLogic();

        return characterLogic.getCharacterByName(characterName);
    }

    @CrossOrigin(origins = {"*"})
    @PostMapping("/public/character/add/{name}/{email}")
    public void addCharacter(@PathVariable("name") String name, @PathVariable("email") String email){
        CharacterLogic characterLogic = new CharacterLogic();
        characterLogic.createCharacter(name, email);

        System.out.println("Character created with username: " + name + " and email: " + email);
    }

    //Get chats of a player
    @CrossOrigin(origins = {"*"})
    @GetMapping("/public/friendchat/get/{characterId}")
    public Messages getFriendChats(@PathVariable("characterId") int characterId){
        ChatLogic chatLogic = new ChatLogic();

        MyFriendChatsModel myFriendChatsModel = restTemplate.getForObject("http://friendchat-service/api/chats/" + characterId, MyFriendChatsModel.class);

        Messages messages = chatLogic.getChatMessages(myFriendChatsModel);

        for(MyFriendChatModel myFriendChatModel : myFriendChatsModel.getFriendChatList()){
            System.out.println(myFriendChatModel.getMessage());
        }

        return messages;
    }

    @CrossOrigin(origins = {"*"})
    @PostMapping("/public/character")
    public CharacterModel updateCharacter(@RequestBody CharacterModel characterModel){
        CharacterLogic characterLogic = new CharacterLogic();
        return characterLogic.updateCharacter(characterModel);
    }
}
