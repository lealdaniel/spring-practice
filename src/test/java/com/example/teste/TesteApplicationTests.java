package com.example.teste;

import com.example.teste.dto.CreateAccountDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.coyote.http11.upgrade.UpgradeServletOutputStream;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class TesteApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void shouldCreateUser() throws Exception {
		CreateAccountDto createAccountDto = new CreateAccountDto("Daniel", "012345678901", 0.0);

		ResultActions result = mvc.perform(
				MockMvcRequestBuilders.post("/api/v1/account")
						.contentType("application/json")
						.content(objectMapper.writeValueAsString(createAccountDto))
		);

		result.andDo(MockMvcResultHandlers.print()).
				andExpect(MockMvcResultMatchers.status().isCreated()).
				andExpect(MockMvcResultMatchers.content().json("{'name': 'Daniel', 'cpf': '012345678901'}"));

	}

}
