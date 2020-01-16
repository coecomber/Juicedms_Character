package com.Herwaarden.Character.Logic;

import com.Herwaarden.Character.DAL.Interface.Repository.ICharacterRepository;
import com.Herwaarden.Character.Factory.CharacterFactory;
import com.Herwaarden.Character.Model.Character.CharacterModel;
import com.Herwaarden.Character.Model.Character.CharactersModel;
import com.Herwaarden.Character.Model.Friend.MyFriendsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class CharacterLogic {
    private ICharacterRepository characterRepository;

    @Autowired
    private RestTemplate restTemplate;

    public CharacterLogic(){
        characterRepository = new CharacterFactory().GetCharacterSQLRepository();
    }

    public List<CharacterModel> getMyCharactersByEmail(String email){
        List<CharacterModel> charactersModel = characterRepository.getMyCharacters(email);

        return charactersModel;
    }

    public CharacterModel getCharacterById(int id){
        return characterRepository.getCharacter(id);
    }

    public boolean createCharacter(String name, String email){
        return characterRepository.createCharacter(name, email);
    }
}
