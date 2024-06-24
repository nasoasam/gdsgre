package com.example.dbunitest;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name = "hello_world")
@Entity
public class HelloWorldEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    public HelloWorldEntity() {
    }

    @Id
    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private String name;

}

