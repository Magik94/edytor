package pl.szul.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Created by Dawid on 30.05.2017.
 */
@Document
public class UserEnity {
    private String username;
    private String password;
    private List<String> roles;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
