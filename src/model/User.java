package model;

/**
 * Created by iliesalinadenisa on 25/04/2017.
 */
public class User {
    private String username;
    private String password;
    private String name;
    private boolean admin;

    public User(String username, String password, String name, boolean admin) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.admin = admin;
    }

    public User(){
        super();
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
