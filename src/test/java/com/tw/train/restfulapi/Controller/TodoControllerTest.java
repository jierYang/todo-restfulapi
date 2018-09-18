package com.tw.train.restfulapi.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import com.tw.train.restfulapi.Service.TodoService;
import com.tw.train.restfulapi.modal.Todo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc

public class TodoControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TodoService todoService;

    @Test
    public void shouldGetTodoById() throws Exception {
        String contentAsString = mockMvc.perform(get("/todos/{id}", 1))
                .andReturn()
                .getResponse()
                .getContentAsString();
        System.out.println(contentAsString);
    }

    @Test
    public void getTodoListTest() throws Exception {
        Todo todoOne = new Todo(1L, "meeting", "To Do", new Date(), "Learning DevOps");
        Todo todoTwo = new Todo(2L, "meeting with LY", "To Do", new Date(), "Learning DevOps");

        List<Todo> todoList = Arrays.asList(todoOne, todoTwo);

        given(todoService.getTodoList()).willReturn(todoList);
        mockMvc.perform(get("/todos"))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[1].id").value(2L));
    }

    @Test
    public void getTodoByIdTest() throws Exception {
        Todo todoOne = new Todo(1L, "meeting", "To Do", new Date(), "Learning DevOps");
        given(todoService.getTodoById(1L)).willReturn(todoOne);
        mockMvc.perform(get("/todos/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.action").value("meeting"));
    }

    @Test
    public void createTodoTest() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "{\"action\" : \"meeting\", \"status\" : \"To Do\", \"date\" : 1537252078161, \"tags\" : \"Learning DevOps\"}";
        Todo todo = mapper.readValue(jsonString, Todo.class);

        given(todoService.createTodo(todo)).willReturn(todo);

        mockMvc.perform(post("/todos")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(mapper.writeValueAsString(todo)))
                .andExpect(status().isOk());
//                .andExpect(jsonPath("$.id").value(1L))
//                .andExpect(jsonPath("$.action").value("meeting"));
//verify(todoService,times(1)).createTodo(todo);

//        verifyNoMoreInteractions(todoService);
    }

    @Test
    public void deleteTodoByIdTest() throws Exception {
        Todo todoOne = new Todo(1L, "meeting", "To Do", new Date(), "Learning DevOps");
        Todo todoTwo = new Todo(2L, "meeting with LY", "To Do", new Date(), "Learning DevOps");

        List<Todo> todoList = Arrays.asList(todoOne, todoTwo);

        given(todoService.getTodoById(1L)).willReturn(todoTwo);


        mockMvc.perform(delete("/todos/delete/{id}", 1L))
                .andExpect(status().isOk());

//        verify(todoService, times(1)).getTodoById(1L);
//        verify(todoService, times(1)).deleteTodo(1L);
//        verifyNoMoreInteractions(todoService);
    }

}
