package kg.online_store.jwt;

public class UsernameAndPasswordAuthenticationRequest {

    private String name;
    private String password;

    public UsernameAndPasswordAuthenticationRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
