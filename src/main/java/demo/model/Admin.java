package demo.model;

import java.io.Serializable;

public class Admin implements Serializable {

    private Integer id;
    private String username;
    private String password;

    public Admin() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String  getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String  getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}