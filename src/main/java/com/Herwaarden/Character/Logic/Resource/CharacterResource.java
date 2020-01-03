package com.Herwaarden.Character.Logic.Resource;

import com.Herwaarden.Character.CharacterApplication;
import com.Herwaarden.Character.Model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/character")
public class CharacterResource {

    public static int getFriendCount = 1;
    private static Logger LOG = LoggerFactory
            .getLogger(CharacterApplication.class);

    @Autowired
    private RestTemplate restTemplate;

    //Get a list of characters of logged in player.
    @RequestMapping("/get/{userId}")
    public List<CharacterModel> getCharacter(@PathVariable("userId") String userId){


        return Collections.singletonList(
                new CharacterModel("yeet")
        );
    }

    //Gets friends of a player
    @RequestMapping("/get/friend/{characterId}")
    public FriendsModel getFriends(@PathVariable("characterId") String characterId){
        LOG.info("CharacterResource.getFriends() method called for the " + getFriendCount + "'th time.");
        getFriendCount++;

        FriendsModel friendsModel = restTemplate.getForObject("http://friend-service/friend/get/" + characterId, FriendsModel.class);

        System.out.println(friendsModel);
        System.out.println(friendsModel.getFriendModelList());

        return friendsModel;
    }
}
