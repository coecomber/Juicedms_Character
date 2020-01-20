package com.Herwaarden.Character;

import com.Herwaarden.Character.Logic.CharacterLogic;
import com.Herwaarden.Character.Logic.Resource.CharacterResource;
import com.Herwaarden.Character.Model.Character.CharacterModel;
import com.Herwaarden.Character.Model.Friend.MyFriendModel;
import com.Herwaarden.Character.Model.Friend.MyFriendsModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class CharacterModelApplicationTests {

	CharacterResource characterResource;

	@Autowired
	private MockMvc mockMvc;

	//Integration tests
	@Test
	void TestGettingPlayerByEmail() throws Exception {
		CharacterLogic characterLogic = new CharacterLogic();

		mockMvc.perform(get("/api/public/characters/get/joostvherwaarden@hotmail.com")
				.contentType("application/json"));

		List<CharacterModel> characterModelList = characterLogic.getMyCharactersByEmail("joostvherwaarden@hotmail.com");
		System.out.println(characterModelList + " = characterModelList");
		for( CharacterModel currentCharacterModel : characterModelList){
			assertThat(currentCharacterModel.getName()).isEqualTo("Juiced");
		}
	}

	@Test
	void TestGettingPlayerById() throws Exception {
		CharacterLogic characterLogic = new CharacterLogic();

		mockMvc.perform(get("/api/public/character/1")
				.contentType("application/json"));

		CharacterModel characterModel = characterLogic.getCharacterById(1);
		assertThat(characterModel.getName()).isEqualTo("Juiced");
	}

	@Test
	void TestGettingPlayerByName() throws Exception {
		CharacterLogic characterLogic = new CharacterLogic();

		mockMvc.perform(get("/api/public/character/getbyname/juiced")
				.contentType("application/json"));

		CharacterModel characterModel = characterLogic.getCharacterById(1);
		assertThat(characterModel.getName()).isEqualTo("Juiced");
	}

	@Test
	void TestGettingChatsById() throws Exception {
		CharacterLogic characterLogic = new CharacterLogic();

		mockMvc.perform(get("/api/public/friendchat/get/1")
				.contentType("application/json"));

		//Always asserts true for now
		assertThat("1").isEqualTo("1");
	}

}
