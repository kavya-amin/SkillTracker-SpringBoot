package com.example.demo.controller;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.demo.SpringSkillTrackerApplication;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringSkillTrackerApplication.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SkillControllerTest {

	@Autowired
	private  Environment env;
	private MockMvc mockMvc;
	org.slf4j.Logger log=LoggerFactory.getLogger(SkillControllerTest.class);
	@Autowired
    private WebApplicationContext wac;

	@Before
	public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        log.info("context loaded sucessfully... Listening on port: "+env.getProperty("server.port"));
	}

	@Test
	public void verifyAllToDoList() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/associate/all").accept(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$", hasSize(7))).andDo(print());
	}
	
	@Test
	public void verifyToDoById() throws Exception {
	 	mockMvc.perform(MockMvcRequestBuilders.get("/api/associateId/3").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.id").exists())
		.andExpect(jsonPath("$.associateFirstName").exists())
		.andExpect(jsonPath("$.associateLastName").exists())
		.andExpect(jsonPath("$.associateEmail").exists())
		.andExpect(jsonPath("$.id").value(3))
		.andExpect(jsonPath("$.associateFirstName").value("Kavya"))
		.andExpect(jsonPath("$.associateLastName").value("Amin"))
		.andExpect(jsonPath("$.associateEmail").value("kavyapoojary989@gmail.com"))
		.andDo(print());
	}
}
