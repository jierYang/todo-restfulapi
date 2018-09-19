package com.tw.train.restfulapi.modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;


@Entity

public class Todo {
    @Id
    @GeneratedValue
    private Long id;
    private String action;
    private Long status_id;
    private Date date;

    public Todo(){}

    public Todo(Long id, String action, Long status_id, Date date){
        this.id = id;
        this.action = action;
        this.status_id = status_id;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }



    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getStatus_id() {
        return status_id;
    }

    public void setStatus_id(Long status_id) {
        this.status_id = status_id;
    }
}
