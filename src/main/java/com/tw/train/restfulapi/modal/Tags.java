package com.tw.train.restfulapi.modal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tags {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

//    @ManyToMany(mappedBy = "tags")
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//    private List<Tags> todos = new ArrayList<>();

    public Tags(){}
    public Tags(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

//    public List<Tags> getTodos() {
//        return todos;
//    }
//
//    public void setTodos(List<Tags> todos) {
//        this.todos = todos;
//    }
}
