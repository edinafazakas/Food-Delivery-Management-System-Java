package Presentation;

public class Client {
    private String username;
    private final String password = "1234";

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
