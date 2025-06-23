package model;

public class User {

    private int id;
    private String name;
    private String nickName;
    private String password;
    private boolean active;

    public User() {
    }

    public User(String name, String nickName, String password, boolean active) {
        this.name = name;
        this.nickName = nickName;
        this.password = password;
        this.active = active;
    }

    public User(int id, String name, String nickName, String password, boolean active) {
        this.id = id;
        this.name = name;
        this.nickName = nickName;
        this.password = password;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
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
