package com.Herwaarden.Character.Logic;

import com.Herwaarden.Character.DAL.Interface.Repository.ICharacterRepository;
import com.Herwaarden.Character.Factory.CharacterFactory;
import com.Herwaarden.Character.Model.Character.CharacterModel;

import java.util.List;

public class CharacterLogic {
    private ICharacterRepository characterRepository;

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

    public CharacterModel getCharacterByName(String name){
        return characterRepository.getCharacterByName(name);
    }

    public boolean createCharacter(String name, String email){
        return characterRepository.createCharacter(name, email);
    }

    public CharacterModel updateCharacter(CharacterModel characterModel){
        return characterRepository.updateCharacter(characterModel);
    }
}
