package it.emes.schoolmanagement.serializable.school;

import it.emes.schoolmanagement.database.dao.SchoolDAO;
import it.emes.schoolmanagement.serializable.user.Staff;
import it.emes.schoolmanagement.serializable.user.Student;
import it.emes.schoolmanagement.serializable.user.Teacher;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class School implements Serializable {

    private static List<Staff> staff;
    private static List<Teacher> teachers;
    private static List<Student> students;
    private static List<SchoolClass> schoolClasses;
    private static List<Subject> subjects;
    private static List<Vote> votes;
    private static SchoolDAO schoolDAO = new SchoolDAO();

    public School() {
        staff = new ArrayList<>();
        teachers = new ArrayList<>();
        students = new ArrayList<>();
        schoolClasses = new ArrayList<>();
        subjects = new ArrayList<>();
        votes = new ArrayList<>();
    }

    public static void setup() {
        try {
            loadSubjects();
            loadSchoolClasses();
            loadStaff();
            loadTeachers();
            loadStudents();
            loadVotes();
        } catch (SQLException ex) {
            System.err.println("Errore durante il setup della classe scuola.. " + ex.getMessage());
        }
    }

    public static void loadStaff() throws SQLException {
        staff = schoolDAO.loadStaff();
    }

    public static void loadTeachers() throws SQLException {
        teachers = schoolDAO.loadTeachers();
    }

    public static void loadStudents() throws SQLException {
        students = schoolDAO.loadStudents();
    }

    public static void loadSchoolClasses() throws SQLException {
        schoolClasses = schoolDAO.loadSchoolClasses();
    }

    public static void loadSubjects() throws SQLException {
        subjects = schoolDAO.loadSubjects();
    }

    public static void loadVotes() throws SQLException {
        votes = schoolDAO.loadVotes();
    }

    public static Subject getSubject(int ID) {
        for (Subject sb : subjects) {
            if (sb.getID() == ID)
                return sb;
        }
        return null;
    }

    public static SchoolClass getSchoolClasse(int classID) {
        for (SchoolClass sc : schoolClasses) {
            if (sc.getClassID() == classID)
                return sc;
        }
        return null;
    }

    public static Vote getVoto(int ID) {
        for (Vote voto : votes) {
            if (voto.getID() == ID)
                return voto;
        }

        System.out.println("Voto non trovato");
        return null;
    }

    public static Student getStudent(int ID) {
        for (Student st : students) {
            if (st.getID() == ID)
                return st;
        }

        System.out.println("Studente non trovato.");
        return null;
    }

    public static Teacher getTeacher(int ID) {
        for (Teacher tc : teachers) {
            if (tc.getID() == ID)
                return tc;
        }

        System.out.println("Insegnante non trovato.");
        return null;
    }

    public static Staff getStaffer(int ID) {
        for (Staff st : staff) {
            if (st.getID() == ID)
                return st;
        }

        System.out.println("Staffer non trovato.");
        return null;
    }


    public static List<Staff> getStaff() {
        return staff;
    }

    public static List<Teacher> getTeachers() {
        return teachers;
    }

    public static List<Student> getStudents() {
        return students;
    }

    public static List<SchoolClass> getSchoolClasses() {
        return schoolClasses;
    }

    public static List<Subject> getSubjects() {
        return subjects;
    }

    public static List<Vote> getVotes() {
        return votes;
    }
}
