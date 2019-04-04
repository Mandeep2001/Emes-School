package it.emes.schoolmanagement.library.school;

import java.io.Serializable;

public class SchoolClass implements Serializable {

    private int classID;
    private String name;

    public SchoolClass(String name) {
        this.name = name;
    }

    public SchoolClass(int classID, String name) {
        this.classID = classID;
        this.name = name;
    }

    @Override
    public String toString() {
        return "SchoolClass{" +
                "classID=" + classID +
                ", name='" + name + '\'' +
                '}';
    }

    public int getClassID() {
        return classID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}