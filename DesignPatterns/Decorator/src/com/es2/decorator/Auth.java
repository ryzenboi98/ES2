package com.es2.decorator;
import java.io.IOException;

public class Auth  implements AuthInterface {
    public Auth(){
    }

    public void auth(String username, String password) throws AuthException, IOException {
        if(!username.equals("admin") || !password.equals("admin"))
            throw new AuthException();
    }
}
