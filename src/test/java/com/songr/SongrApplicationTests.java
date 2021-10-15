package com.songr;

import com.songr.models.Album;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
class SongrApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@Test
	public void album()
	{
		Album sut = new Album("amr diab", "Hayeish Yeftekerni", 14, 3234, "https://img.youm7.com/large/202001290523382338.jpg");

		assertEquals("amr diab", sut.getTitle());
		assertEquals(14, sut.getSongCount());
	}

	@Test
	public void render_app() throws Exception
	{
		mockMvc.perform(get("/albums"))
				.andDo(print())  // shows output on server console for debugging
				.andExpect(content().string(containsString("<h1>Songr</h1>")))
				.andExpect(status().isOk());
	}

}
