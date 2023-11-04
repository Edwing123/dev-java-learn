

import static java.lang.StringTemplate.STR;

public class InstanceOf {
    public static void main(String[] args) {
        var authenticationService = AuthenticationServiceProvider.getAuthenticationService();
        var authenticated = authenticationService.authenticate(
            new AuthCredentials("Edwing123", "banana")
        );

        AuthenticationService secondAuthenticationService = null;

        if (authenticated) {
            System.err.println("Welcome, Edwing123!");
        } else {
            System.err.println("Invalid credentials.");
        }

        if (authenticationService instanceof  AuthenticationServiceImpl) {
            System.err.println("authenticationService is an instance of AuthenticationServiceImpl.");
        } else {
            System.err.println("authenticationService is not an instance of AuthenticationServiceImpl.");
        }

        System.err.println(STR."secondAuthenticationService = \{secondAuthenticationService}.");
        System.err.println(STR."secondAuthenticationService instanceof AuthenticationService = \{secondAuthenticationService instanceof AuthenticationService}.");
    }
}

class AuthenticationServiceProvider {
    public static AuthenticationService getAuthenticationService() {
        return new AuthenticationServiceImpl();
    }
}

record AuthCredentials(String username, String password) {}

class AuthenticationServiceImpl implements AuthenticationService {
    @Override
    public boolean authenticate(AuthCredentials credentials) {
        return credentials.username().equals("Edwing123") && credentials.password().equals("banana");
    }
}

interface AuthenticationService {
    boolean authenticate(AuthCredentials credentials);
}
