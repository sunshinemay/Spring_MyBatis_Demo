package demo.model;

import java.io.Serializable;

public class Activity implements Serializable {

    private Integer id;
    private String name;

    public Activity() {
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
}