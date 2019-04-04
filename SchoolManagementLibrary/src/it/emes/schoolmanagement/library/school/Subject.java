package it.emes.schoolmanagement.library.school;

import java.io.Serializable;
import java.util.List;

public class Subject implements Serializable {

    private int ID;
    private String subjectName;
    private List<Vote> votes;
    private double average;

    public Subject(int id, String subjectName) {
        this.ID = id;
        this.subjectName = subjectName;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "ID=" + ID +
                ", subjectName='" + subjectName + '\'' +
                ", votes=" + votes +
                ", average=" + average +
                '}';
    }

    public int getID() {
        return ID;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public double getAverage() {
        return average;
    }
}