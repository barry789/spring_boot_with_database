package com.galvanize.xp.spring.boot;

import org.springframework.data.annotation.Id;

public class Name {

    @Id
    private String id;
    private final String name;
    private final String timestamp;
    private final String path;

    Name(String name, String timestamp, String path){
        this.name = name;
        this.timestamp = timestamp;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getPath() {
        return path;
    }
}
