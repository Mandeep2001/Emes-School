package it.emes.schoolmanagement.library.school;

import it.emes.schoolmanagement.library.users.Staffer;
import it.emes.schoolmanagement.library.users.Student;
import it.emes.schoolmanagement.library.users.Teacher;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class School implements Serializable {

    private List<Staffer> staffers;
    private List<Teacher> teachers;
    private List<Student> students;
    private List<SchoolClass> schoolClasses;
    private List<Subject> subjects;
    private List<Vote> votes;

    public School() {
        staffers = new ArrayList<>();
        teachers = new ArrayList<>();
        students = new ArrayList<>();
        schoolClasses = new ArrayList<>();
        subjects = new ArrayList<>();
        votes = new ArrayList<>();
    }

    public School(School school) {
        this.staffers = school.getStaffers();
        this.teachers = school.getTeachers();
        this.students = school.getStudents();
        this.schoolClasses = school.getSchoolClasses();
        this.subjects = school.getSubjects();
        this.votes = school.getVotes();
    }

    /**
     * Questo metodo cerca all'interno della lista {@code subjects} un oggetto subject con l'ID uguale a quello passato
     * come parametro.
     * @param ID L'ID da confrontare.
     * @return Oggetto Subject trovato se ne esiste uno, altrimenti ritorna un null.
     */
    public Subject getSubject(int ID) {
        for (Subject sb : subjects) {
            if (sb.getID() == ID)
                return sb;
        }
        return null;
    }

    /**
     * Questo metodo cerca all'interno della lista {@code schoolClasses} un oggetto schoolClass con l'ID
     * equivalente a quello passato come parametro.
     * @param classID L'ID da confrontare.
     * @return Oggetto SchoolClass trovato se esiste altrimenti un null.
     */
    public SchoolClass getSchoolClass(int classID) {
        for (SchoolClass sc : schoolClasses) {
            if (sc.getClassID() == classID)
                return sc;
        }
        return null;
    }

    public SchoolClass getSchoolClass(String className) {
        for (SchoolClass sc : schoolClasses) {
            if (sc.getName().equals(className))
                return sc;
        }
        return null;
    }

    /**
     * Questo metodo cerca all'interno della lista {@code votes} un oggetto vote con l'ID
     * equivalente a quello passato come parametro.
     * @param ID L'ID da confrontare.
     * @return Oggetto Vote trovato se esiste altrimenti un null.
     */
    public Vote getVoto(int ID) {
        for (Vote voto : votes) {
            if (voto.getID() == ID)
                return voto;
        }

        System.out.println("Voto non trovato");
        return null;
    }

    /**
     * Questo metodo cerca all'interno della lista {@code students} un oggetto student con l'ID
     * equivalente a quello passato come parametro.
     * @param ID L'ID da confrontare.
     * @return Oggetto Student trovato se esiste altrimenti un null.
     */
    public Student getStudent(int ID) {
        for (Student st : students) {
            if (st.getID() == ID)
                return st;
        }

        System.out.println("Studente non trovato.");
        return null;
    }

    /**
     * Questo metodo cerca all'interno della lista {@code teachers} un oggetto teacehr con l'ID
     * equivalente a quello passato come parametro.
     * @param ID L'ID da confrontare.
     * @return Oggetto Teacher trovato se esiste altrimenti un null.
     */
    public Teacher getTeacher(int ID) {
        for (Teacher tc : teachers) {
            if (tc.getID() == ID)
                return tc;
        }

        System.out.println("Insegnante non trovato.");
        return null;
    }

    /**
     * Questo metodo cerca all'interno della lista {@code staffers} un oggetto staffer con l'ID
     * equivalente a quello passato come parametro.
     * @param ID L'ID da confrontare.
     * @return Oggetto Staffer trovato se esiste altrimenti un null.
     */
    public Staffer getStaffer(int ID) {
        for (Staffer st : staffers) {
            if (st.getID() == ID)
                return st;
        }

        System.out.println("Staffer non trovato.");
        return null;
    }

    public List<Staffer> getStaffers() {
        return staffers;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<SchoolClass> getSchoolClasses() {
        return schoolClasses;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setStaffers(List<Staffer> staffers) {
        this.staffers = staffers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void setSchoolClasses(List<SchoolClass> schoolClasses) {
        this.schoolClasses = schoolClasses;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }
}
