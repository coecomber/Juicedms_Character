package com.Herwaarden.Character.DAL.Repository;

import com.Herwaarden.Character.DAL.Interface.Context.ICharacterContext;
import com.Herwaarden.Character.DAL.Interface.Repository.ICharacterRepository;
import com.Herwaarden.Character.Model.Character.CharacterModel;

import java.util.List;

public class CharacterRepository implements ICharacterRepository {

    private ICharacterContext characterContext;

    // Constructors
    public CharacterRepository(ICharacterContext context){
        characterContext = context;
    }

    @Override
    public List<CharacterModel> getMyCharacters(String email) {
        return characterContext.getMyCharacters(email);
    }

    @Override
    public CharacterModel getCharacter(int id) {
        return characterContext.getCharacter(id);
    }

    @Override
    public CharacterModel getCharacterByName(String name) {
        return characterContext.getCharacterByName(name);
    }

    @Override
    public boolean createCharacter(String name, String email) {
        return characterContext.createCharacter(name, email);
    }

    @Override
    public CharacterModel updateCharacter(CharacterModel characterModel) {
        return characterContext.updateCharacter(characterModel);
    }
}
