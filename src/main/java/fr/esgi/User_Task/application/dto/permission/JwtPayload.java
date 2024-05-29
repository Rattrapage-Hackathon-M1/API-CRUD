package fr.esgi.User_Task.application.dto.permission;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class JwtPayload {
    private String sub;
    private String iat;
    private String exp;
    private List<String> roles;

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getIat() {
        return iat;
    }

    public void setIat(String iat) {
        this.iat = iat;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
