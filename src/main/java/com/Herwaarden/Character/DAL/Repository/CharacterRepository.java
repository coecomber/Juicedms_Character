package com.Herwaarden.Character.DAL.Repository;

import com.Herwaarden.Character.DAL.Interface.Context.ICharacterContext;
import com.Herwaarden.Character.DAL.Interface.Repository.ICharacterRepository;
import com.Herwaarden.Character.Model.Character.CharacterModel;
import com.Herwaarden.Character.Model.Character.CharactersModel;

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
    public boolean createCharacter(String name, String email) {
        return characterContext.createCharacter(name, email);
    }
}
