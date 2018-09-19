package com.tw.train.restfulapi.modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;


@Entity

public class Todo {
    @Id
    @GeneratedValue
    private long id;
    private String action;
    private String status;
    private Date date;
    private String tags;

    public Todo(){}

    public Todo(long id, String action, String status, Date date,String tags){
        this.id = id;
        this.action = action;
        this.status = status;
        this.date = date;
        this.tags = tags;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public String getStatus() {
        return status;
    }

    public Date getDate() {
        return date;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}
