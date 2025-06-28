package model;

public class User {

    private int id;
    private String fullName;
    private String email;
    private String password;
    private boolean active;

    public User() {
    }

    public User(String fullName, String email, String password, boolean active) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.active = active;
    }

    public User(int id, String fullName, String email, String password, boolean active) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String name) {
        this.fullName = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}
