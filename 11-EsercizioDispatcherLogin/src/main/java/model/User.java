package model;

public class User {

    private String fullname;
    private String username;
    private String password;
    private Role ruolo;

    public User(String fullname, String username, String password) {
        this.fullname = fullname;
        this.username = username;
        this.password = password;
        this.ruolo = Role.USER;
    }

    public String getFullname() {
        return fullname;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public Role getRuolo() {
        return ruolo;
    }
    public void setRuolo(Role ruolo) {
        this.ruolo = ruolo;
    }
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return ruolo == Role.ADMIN;
    }

    @Override
    public String toString() {
        return "User{" +
                "fullname='" + fullname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", ruolo=" + ruolo +
                '}';
    }
}
