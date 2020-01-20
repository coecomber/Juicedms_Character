package com.Herwaarden.Character.Logic;

import com.Herwaarden.Character.DAL.Interface.Repository.ICharacterRepository;
import com.Herwaarden.Character.Factory.CharacterFactory;
import org.junit.jupiter.api.Test;
import static com.google.common.truth.Truth.assertThat;

class CharacterLogicTest {

    private ICharacterRepository characterRepository = new CharacterFactory().GetCharacterSQLRepository();

    //Testplan TC03
    @Test
    void testCreateCharacter_NoDuplicatieEntries() {
        String name = "Juiced";
        String email = "Joostvherwaarden@gmail.com";
        CharacterLogic characterLogic = new CharacterLogic();
        boolean characterMade = characterLogic.createCharacter(name, email);

        //Expecting false: The database can't contain duplicate entries.
        assertThat(characterMade == false);
    }
}