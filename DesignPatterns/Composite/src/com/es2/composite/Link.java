package com.es2.composite;
import java.lang.String;

public class Link extends Menu{
    public String url;

    public Link(){}

    public String getURL(){
        return url;
    }
    public void setURL(String URL) {
        this.url = URL;
    }

    public void showOptions(){
        System.out.println(this.label + "\n" + this.url);
    }
}
