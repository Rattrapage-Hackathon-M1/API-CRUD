package fr.esgi.User_Task.application.dto.permission;

import java.util.Date;
import java.util.List;

public class JwtPayload {
    private String sub;
    private List<String> roles;
    private Date exp;
    private Date iat;

    // Getters and setters

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public Date getExp() {
        return exp;
    }

    public void setExp(Date exp) {
        this.exp = exp;
    }

    public Date getIat() {
        return iat;
    }

    public void setIat(Date iat) {
        this.iat = iat;
    }
}
