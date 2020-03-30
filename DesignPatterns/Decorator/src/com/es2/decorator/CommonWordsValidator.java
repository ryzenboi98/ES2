package com.es2.decorator;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CommonWordsValidator extends Decorator {

    public CommonWordsValidator(AuthInterface auth){
        super(auth);
    }

    public void auth(String username, String password) throws AuthException, IOException {
        String request = getHTTPRequest(password);

        if(request.equals("bad pass")) {
            System.out.println("boyy");
            throw new AuthException();
        }
        else super.auth(username, password);
    }
    public java.lang.String getHTTPRequest(String word) throws IOException
    {
        try {
            StringBuilder result = new StringBuilder();
            URL url = new URL("https://owlbot.info/api/v2/dictionary/" + word + "?format=json");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.1; en-GB;     rv:1.9.2.13) Gecko/20101203 Firefox/3.6.13 (.NET CLR 3.5.30729)");
            conn.setRequestMethod("GET");
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            rd.close();
            return result.toString();
        }
        catch(Exception e){
            System.out.println(e);
        }

        return "bad pass";
    }

    /*
    public boolean noCaps(String password)
    {
        char[] charArray = password.toCharArray();

        for(int i=0; i < charArray.length; i++){
            if( Character.isUpperCase( charArray[i] ))
                return false;
        }
        return true;
    }
    */

    public static void main(String args[])
    {
        AuthInterface auth;

        auth = new CommonWordsValidator(new Logging(new Auth()));

        try {
            auth.auth("admin","admin");
        } catch (AuthException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            auth.auth("joe","moma");
        } catch (AuthException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }




}
