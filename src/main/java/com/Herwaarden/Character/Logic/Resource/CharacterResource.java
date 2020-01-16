package com.Herwaarden.Character.Logic.Resource;

import com.Herwaarden.Character.CharacterApplication;
import com.Herwaarden.Character.Logic.CharacterLogic;
import com.Herwaarden.Character.Model.Character.CharacterModel;
import com.Herwaarden.Character.Model.Friend.MyFriendsModel;
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

    public static int getFriendCount = 1;
    private static Logger LOG = LoggerFactory
            .getLogger(CharacterApplication.class);

    @Autowired
    private RestTemplate restTemplate;

    //Get a list of characters of logged in player.
    @CrossOrigin(origins = {"http://localhost:9000","http://217.101.44.31:9000"})
    @GetMapping("/characters/get/{email}")
    public List<CharacterModel> getCharacter(@PathVariable("email") String email){
        CharacterLogic characterLogic = new CharacterLogic();
        List<CharacterModel> charactersModels = characterLogic.getMyCharactersByEmail(email);

        for(CharacterModel characterModel : charactersModels){
            System.out.println(characterModel.getId());
        }

        return charactersModels;
    }

    //Get a single character by id.
    @CrossOrigin(origins = {"http://localhost:9000","http://217.101.44.31:9000"})
    @GetMapping("/character/get/{characterId}")
    public CharacterModel getCharacter(@PathVariable("characterId") int characterId){
        CharacterLogic characterLogic = new CharacterLogic();

        return characterLogic.getCharacterById(characterId);
    }

    @CrossOrigin(origins = {"http://localhost:9000","http://217.101.44.31:9000"})
    @PostMapping("/character/add/{name}/{email}")
    public void addCharacter(@PathVariable("name") String name, @PathVariable("email") String email){
        CharacterLogic characterLogic = new CharacterLogic();
        characterLogic.createCharacter(name, email);

        System.out.println("Character created with username: " + name + " and email: " + email);
    }

    //Gets friends of a player
    @CrossOrigin(origins = {"http://localhost:9000","http://217.101.44.31:9000"})
    @GetMapping("/friend/get/{characterId}")
    public MyFriendsModel getFriends(@PathVariable("characterId") String characterId){
        CharacterLogic characterLogic = new CharacterLogic();

        MyFriendsModel myFriendsModel = restTemplate.getForObject("http://friend-service/api/public/get/" + characterId, MyFriendsModel.class);

        LOG.info("CharacterResource.getFriends() method called for the " + getFriendCount + "'th time.");
        getFriendCount++;

        return myFriendsModel;
    }
}
