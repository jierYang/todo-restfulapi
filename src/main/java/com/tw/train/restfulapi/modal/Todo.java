package com.tw.train.restfulapi.modal;

import javax.persistence.*;
import java.util.Date;


@Entity

public class Todo {
    @Id
    @GeneratedValue
    private Long id;
    private String action;

    private Date date;

    @OneToOne(cascade = CascadeType.ALL)//City是关系的维护端
    @JoinColumn(name = "status_id")
     Status status;

    public Todo(){}

    public Todo(Long id, String action, Date date){
        this.id = id;
        this.action = action;

        this.date = date;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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
}
