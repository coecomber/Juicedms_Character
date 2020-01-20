package com.Herwaarden.Character.DAL.Interface.Context;

import com.Herwaarden.Character.Model.Character.CharacterModel;
import java.util.List;

public interface ICharacterContext {
    List<CharacterModel> getMyCharacters(String email);
    CharacterModel getCharacter(int id);
    CharacterModel getCharacterByName(String name);
    boolean createCharacter(String name, String email);
    CharacterModel updateCharacter(CharacterModel characterModel);
}
