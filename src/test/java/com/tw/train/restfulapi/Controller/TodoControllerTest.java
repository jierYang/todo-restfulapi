package com.tw.train.restfulapi.Controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc

public class TodoControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldGetTodoById() throws Exception {
        String contentAsString = mockMvc.perform(get("/todos/{id}", 1))
                .andReturn()
                .getResponse()
                .getContentAsString();
        System.out.println(contentAsString);
    }


}
