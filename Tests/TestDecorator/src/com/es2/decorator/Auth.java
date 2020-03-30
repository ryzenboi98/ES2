//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.es2.decorator;

public class Auth implements AuthInterface {
    public Auth() {
    }

    public void auth(String username, String password) throws AuthException {
        if (username.equals("admin") && password.equals("admin")) {
            System.out.println("Logon");
        } else {
            throw new AuthException();
        }
    }
}
