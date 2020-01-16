package com.Herwaarden.Character.DAL.Interface.Repository;

import com.Herwaarden.Character.Model.Character.CharacterModel;
import java.util.List;

public interface ICharacterRepository {
    List<CharacterModel> getMyCharacters(String email);
    CharacterModel getCharacter(int id);
    boolean createCharacter(String name, String email);
}
