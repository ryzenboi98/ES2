package com.es2.composite;
import java.lang.String;

public abstract class Menu extends Object{
    public String label;

    public Menu(){ }

    public String getLabel(){
        return this.label;
    }

    public void setLabel(String label){
        this.label = label;
    }
    public abstract void showOptions();
}
