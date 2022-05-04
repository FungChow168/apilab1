package com.techreturners.apilab1.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@AutoConfigureMockMvc
@SpringBootTest
public class CoffeeTest {

    @Autowired
    private MockMvc mockMvcController;

    @Test
    public void testCoffeeLoverWithoutParam() throws Exception {

        String expectedContent = "latte";

        this.mockMvcController.perform(
                MockMvcRequestBuilders.get("/coffee"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.name").value(expectedContent));
    }

    @Test
    public void testCoffeeLoverParamCappuccino() throws Exception {

        String expectedContent = "cappucino";

        this.mockMvcController.perform(
                        MockMvcRequestBuilders.get("/coffee?name=cappucino"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.name").value(expectedContent));
    }

}
