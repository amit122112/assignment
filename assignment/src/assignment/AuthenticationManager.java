package assignment;

import java.util.HashMap;
import java.util.Map;

public class AuthenticationManager {
	private static AuthenticationManager instance;
    private Map<String, String> userDatabase;

    public AuthenticationManager() {
        this.userDatabase = new HashMap<>();
        
        userDatabase.put("root", "root");
        userDatabase.put("user", "userpass");
    }
    
    public static synchronized AuthenticationManager getInstance() {
        if (instance == null) {
            instance = new AuthenticationManager();
        }
        return instance;
    }

    public boolean authenticate(String username, String password) {
        return userDatabase.containsKey(username) && userDatabase.get(username).equals(password);
    }
}
