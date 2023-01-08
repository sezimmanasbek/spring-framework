package com.cydeo.controller;

import org.apache.coyote.Response;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(WelcomeController.class)
class WelcomeControllerTest {

 @Autowired
    private MockMvc mvc;

    @Test
    void welcome() throws Exception {
//     call /welcome endpoint
        RequestBuilder request = MockMvcRequestBuilders.get("/welcome")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mvc.perform(request).andReturn();
        assertEquals(200,result.getResponse().getStatus());
        assertEquals("welcome",result.getResponse().getContentAsString());
 }

    @Test
    void welcome2()throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/welcome")
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(content().string("welcome"))
                .andReturn();


 }

}
