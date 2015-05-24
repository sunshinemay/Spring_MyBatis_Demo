package demo.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable {

    private Integer id;
    private String name;
    private String content;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time;

    public Message() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String  getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String  getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date  getTime() {
        return this.time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}