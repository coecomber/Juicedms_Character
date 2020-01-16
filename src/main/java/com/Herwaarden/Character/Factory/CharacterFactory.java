package com.Herwaarden.Character.Factory;

import com.Herwaarden.Character.DAL.Context.CharacterContextSQL;
import com.Herwaarden.Character.DAL.Interface.Repository.ICharacterRepository;
import com.Herwaarden.Character.DAL.Repository.CharacterRepository;

public class CharacterFactory {
    private CharacterRepository characterRepository;

    public ICharacterRepository GetCharacterSQLRepository(){
        characterRepository = new CharacterRepository(new CharacterContextSQL());
        return characterRepository;
    }
}
