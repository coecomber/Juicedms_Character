package com.Herwaarden.Character.Model.Character;

import java.util.ArrayList;
import java.util.List;

public class CharactersModel {
    List<CharacterModel> characterModelList;

    // Constructors
    public CharactersModel() {
        this.characterModelList = new ArrayList<>();
    }

    public CharactersModel(List<CharacterModel> characterModelList) {
        this.characterModelList = characterModelList;
    }


    // Methods
    public List<CharacterModel> getCharacterModelList() {
        return characterModelList;
    }

    public void setCharacterModelList(List<CharacterModel> characterModelList) {
        this.characterModelList = characterModelList;
    }

    public void addCharacterModelList(CharacterModel characterModel){
        characterModelList.add(characterModel);
    }
}
