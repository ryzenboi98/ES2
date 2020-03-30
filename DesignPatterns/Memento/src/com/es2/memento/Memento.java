package com.es2.memento;
import java.util.ArrayList;
import java.lang.String;

public class Memento extends Object{
    ArrayList<String> studentNames;

    public Memento(ArrayList<String> studentName){
        studentNames = new ArrayList<String>(studentName);
    }

    public ArrayList<String> getState(){
        return studentNames;
    }

    public static void main(String args[])  //static method
    {
        Server s = new Server();
        BackupService backup = new BackupService(s);
        backup.takeSnapshot();
        try {
            s.addStudent("Maria José");
        } catch (ExistingStudentException e) {
            e.printStackTrace();
        }
        backup.takeSnapshot();
        try {
            s.addStudent("Manuel António");
        } catch (ExistingStudentException e) {
            e.printStackTrace();
        }
        System.out.println(s.getStudentNames().size());

        try {
            backup.restoreSnapshot(1);
        } catch (NotExistingSnapshotException e) {
            e.printStackTrace();
        }
        System.out.println(s.getStudentNames().size());
    }
}
