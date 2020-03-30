package com.es2.memento;
import java.lang.String;
import java.util.ArrayList;

public class Server extends Object{
    ArrayList<String> studentsName;

    public Server(){
        studentsName = new ArrayList<String>();
    }

    public void addStudent(String studentName) throws ExistingStudentException {
        if(studentsName.contains(studentName))
            throw new ExistingStudentException();
        else
            studentsName.add(studentName);
    }

    public Memento backup() {
        return new Memento(studentsName);
    }

    public void restore(Memento state) {
        studentsName = state.getState();
    }

    public ArrayList<String> getStudentNames() {
        return studentsName;
    }


}
