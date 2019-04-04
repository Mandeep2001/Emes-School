package it.emes.schoolmanagement.server.database.handler;

import it.emes.schoolmanagement.library.school.SchoolClass;
import it.emes.schoolmanagement.library.school.Subject;
import it.emes.schoolmanagement.library.school.Vote;
import it.emes.schoolmanagement.library.users.Staffer;
import it.emes.schoolmanagement.library.users.Student;
import it.emes.schoolmanagement.library.users.Teacher;
import it.emes.schoolmanagement.server.database.dao.SchoolDAO;

public class SchoolHandler {

    private static SchoolDAO schoolDAO;

    public Student getStudent(int ID) {
        return SchoolHandler.getSchoolDAO().getSchool().getStudent(ID);
    }

    public Teacher getTeacehr(int ID) {
        return SchoolHandler.getSchoolDAO().getSchool().getTeacher(ID);
    }

    public Staffer getStaffer(int ID) {
        return SchoolHandler.getSchoolDAO().getSchool().getStaffer(ID);
    }

    public SchoolClass getSchoolClass(int ID) {
        return SchoolHandler.getSchoolDAO().getSchool().getSchoolClass(ID);
    }

    public Subject getSubject(int ID) {
        return SchoolHandler.getSchoolDAO().getSchool().getSubject(ID);
    }

    public Vote getVote(int ID) {
        return SchoolHandler.getSchoolDAO().getSchool().getVoto(ID);
    }

    public static SchoolDAO getSchoolDAO() {
        if (schoolDAO == null)
            schoolDAO = new SchoolDAO();
        return schoolDAO;
    }
}
