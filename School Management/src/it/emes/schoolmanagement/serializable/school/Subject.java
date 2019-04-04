package it.emes.schoolmanagement.serializable.school;

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

    /**
     * Questo metodo aggiunge un voto alla lista dei voti.
     * @param voto è l'oggetto da aggiungere alla lista dei voti
     */
    public void aggiungiVoto(Vote voto) {
        this.votes.add(voto);
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

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }
}
