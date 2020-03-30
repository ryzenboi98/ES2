package com.es2.decorator;
import java.lang.String;
import java.io.IOException;

public interface AuthInterface {
    void auth(String username, String password) throws AuthException, IOException;
}
