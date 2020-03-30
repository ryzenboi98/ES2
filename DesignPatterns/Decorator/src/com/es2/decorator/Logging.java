package com.es2.decorator;
import java.io.IOException;
import java.lang.String;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logging extends Decorator {

    public Logging(AuthInterface auth){
        super(auth);
    }

    public void auth(String username, String password) throws AuthException, IOException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        System.out.println(System.currentTimeMillis() + ",auth()");
        System.out.println("Welcome "+ username + "! " + dateFormat.format(date));
        super.auth(username, password);
    }
}
