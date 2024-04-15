package com.example.springbootdemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.springbootdemo.dto.ItemResponse;
import com.example.springbootdemo.dto.Sample;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class SpringBootDemoApplicationTests {

	// APIを発行するためのMockオブジェクトを生成
	@Autowired
	private MockMvc mockMvc;
	@Test
	void contextLoads() throws Exception{
		// javaのObjectをJSOnに変換するためのクラスを生成
		ObjectMapper objectMapper = new ObjectMapper();

		// 結果を検証するためのクラスを生成して、期待をセット
		Sample sample = new Sample();
		sample.setId(100);
		sample.setName("hoge");

		// 「/hello」パスのAPIを実行してレスポンスを検証
		this.mockMvc.perform(MockMvcRequestBuilders.get("/hello"))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(status().isOk())
				.andExpect(content().json(objectMapper.writeValueAsString(sample)));
	}

	@Test
	void testGetItemById() throws Exception {
		// 検証するAPIパス
		final String API_PATH = "/item/1";

		// JavaのObjectをJSONに変換するためのクラスを生成
		ObjectMapper objectMapper = new ObjectMapper();

		// 結果を検証するためのクラスを生成して、期待値をセット
		ItemResponse itemResponse = new ItemResponse();
		itemResponse.setId(1);
		itemResponse.setItemName("大豆");

		// APIを実行してレスポンスを検証
		this.mockMvc.perform(MockMvcRequestBuilders.get(API_PATH))
			.andDo(MockMvcResultHandlers.print())
			.andExpect(status().isOk())
			.andExpect(content().json(objectMapper.writeValueAsString(itemResponse)));
	}
}
