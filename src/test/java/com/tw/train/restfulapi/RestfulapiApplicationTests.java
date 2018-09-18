package com.tw.train.restfulapi;

import com.tw.train.restfulapi.modal.Todo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class RestfulapiApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getTodoList() throws Exception {
//        Todo todo = new Todo(1, "wjh", "finished", new Date());
//        Todo todoNew = new Todo(UUID.randomUUID(), "todoNew", "to do", new Date());
//
//        List<Todo> todoList = Arrays.asList(todo, todoNew);
//
//        given(toDoService.getTodoList()).willReturn(todoList);
//
//        mvc.perform(
//                get("/todos"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(2)))
//                .andExpect(jsonPath("$[0].name").value("wjh"))
//                .andExpect(jsonPath("$[1].name").value("todoNew"));
    }

    @Test
    public void shouldGetTodoById() throws Exception {
        String contentAsString = mockMvc.perform(get("/todos/{id}", 5))
                .andReturn()
                .getResponse()
                .getContentAsString();
        System.out.println(contentAsString);
    }


}
