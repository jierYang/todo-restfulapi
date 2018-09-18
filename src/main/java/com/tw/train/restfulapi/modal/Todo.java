package com.tw.train.restfulapi.modal;

import java.util.Date;

public class Todo {
    private long id;
    private String name;
    private String status;
    private Date dueDate;

    public Todo(){}

    public Todo(long id, String name, String status, Date dueDate){
        this.id = id;
        this.name = name;
        this.status = status;
        this.dueDate = dueDate;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public Date getDueDate() {
        return dueDate;
    }
}
