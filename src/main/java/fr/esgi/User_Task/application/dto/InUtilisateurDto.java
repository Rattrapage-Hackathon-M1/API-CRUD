package fr.esgi.User_Task.application.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@NoArgsConstructor
public class InUtilisateurDto {
    private Long id;
    private String username;
    private String mail;
    private String password;
    private String roles;

    @JsonCreator
    public InUtilisateurDto(
            @JsonProperty("id") Long id,
            @JsonProperty("username") String username,
            @JsonProperty("mail") String mail,
            @JsonProperty("password") String password,
            @JsonProperty("roles") String roles) {
        this.id = id;
        this.username = username;
        this.mail = mail;
        this.password = password;
        this.roles = roles;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}
