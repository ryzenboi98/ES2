//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.es2.decorator;

import java.io.IOException;

public class Decorator implements AuthInterface {
    AuthInterface auth;

    public Decorator(AuthInterface auth) {
        this.auth = auth;
    }

    public void auth(String username, String password) throws AuthException, IOException {
        this.auth.auth(username, password);
    }
}
