package it.emes.schoolmanagement.serializable.school;

import java.io.Serializable;

public class Vote implements Serializable {

    private int ID;
    private double vote;
    private int studentID;
    private int teacherID;

    public Vote(double vote) {
        this.vote = vote;
    }

    public Vote(int ID, int studentID, int teacherID, int subjectID, double vote) {
        this.ID = ID;
        this.studentID = studentID;
        this.teacherID = teacherID;
        this.vote = vote;
    }

    @Override
    public String toString() {
        return "Vote{" +
                "ID=" + ID +
                ", vote=" + vote +
                ", studentID=" + studentID +
                ", teacherID=" + teacherID +
                '}';
    }

    public double getVote() {
        return vote;
    }

    public void setVote(double vote) {
        this.vote = vote;
    }

    public int getID() {
        return ID;
    }

    public int getStudentID() {
        return studentID;
    }

    public int getTeacherID() {
        return teacherID;
    }
}
