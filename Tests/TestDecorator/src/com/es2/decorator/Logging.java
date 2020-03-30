//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.es2.decorator;

import java.io.IOException;

public class Logging extends Decorator {
    public Logging(AuthInterface auth) {
        super(auth);
    }

    public void auth(String username, String password) throws AuthException, IOException {
        System.out.println(System.currentTimeMillis() + ",auth()");
        super.auth(username, password);
    }
}
