package assignment;

import java.util.HashMap;
import java.util.Map;

public class AuthenticationManager {
    private Map<String, String> userDatabase;

    public AuthenticationManager() {
        this.userDatabase = new HashMap<>();
        
        userDatabase.put("admin", "password123");
        userDatabase.put("user", "userpass");
    }

    public boolean authenticate(String username, String password) {
        return userDatabase.containsKey(username) && userDatabase.get(username).equals(password);
    }
}
