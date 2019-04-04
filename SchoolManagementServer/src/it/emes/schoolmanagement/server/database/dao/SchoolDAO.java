package it.emes.schoolmanagement.server.database.dao;

import it.emes.schoolmanagement.library.school.School;
import it.emes.schoolmanagement.library.school.SchoolClass;
import it.emes.schoolmanagement.library.school.Subject;
import it.emes.schoolmanagement.library.school.Vote;
import it.emes.schoolmanagement.library.users.Staffer;
import it.emes.schoolmanagement.library.users.Student;
import it.emes.schoolmanagement.library.users.Teacher;
import it.emes.schoolmanagement.library.users.User;
import it.emes.schoolmanagement.server.database.handler.Connect;
import org.omg.CORBA.CODESET_INCOMPATIBLE;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * La classe SchoolDAO consente di interfacciare il sistema con il database.
 * Contiene i metodi per caricare tutte le risorse necessarie al sistema
 * (Students, Teachers, Staffers, Votes, Subjects, SchoolClasses).
 */
public class SchoolDAO {

    private School school;

    public SchoolDAO() {
        school = new School();
    }

    public List<Vote> loadVotes() throws SQLException {
        List<Vote> votes = new ArrayList<>();
        PreparedStatement preparedStatement = Connect.getConnection().prepareStatement(
                "SELECT id, studentID, teacherID, vote " +
                        "FROM votes;");
        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            Vote vote = new Vote(rs.getInt("id"), rs.getInt("studentID"),
                    rs.getInt("teacherID"), rs.getInt("subjectID"), rs.getDouble("vote"));
            votes.add(vote);
        }
        return votes;
    }

    public List<Subject> loadSubjects() throws SQLException {
        List<Subject> subjects = new ArrayList<>();
        PreparedStatement preparedStatement = Connect.getConnection().prepareStatement(
                "SELECT id, name FROM subjects;");
        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            Subject subject = new Subject(rs.getInt("id"),
                    rs.getString("name"));
            subjects.add(subject);
        }
        return subjects;
    }

    public List<SchoolClass> loadSchoolClasses() throws SQLException {
        List<SchoolClass> schoolClasses = new ArrayList<>();
        PreparedStatement preparedStatement = Connect.getConnection().prepareStatement(
                "SELECT id, name " +
                        "FROM classes;");
        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            SchoolClass schoolClass = new SchoolClass(rs.getInt("id"),
                    rs.getString("name"));
            schoolClasses.add(schoolClass);
        }
        return schoolClasses;
    }

    public List<Student> loadStudents() throws SQLException {
        List<Student> students = new ArrayList<>();
        PreparedStatement preparedStatement = Connect.getConnection().prepareStatement("SELECT id, username, password, firstname, lastname, classID " +
                "FROM students;");
        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            Student student = new Student(rs.getInt("id"),
                    rs.getString("username"), rs.getString("password"),
                    rs.getString("firstname"), rs.getString("lastname"),
                    school.getSchoolClass(rs.getInt("classID")));
            students.add(student);
        }
        return students;
    }

    public List<Teacher> loadTeachers() throws SQLException {
        List<Teacher> teachers = new ArrayList<>();
        PreparedStatement preparedStatement = Connect.getConnection().prepareStatement("SELECT id, username, password, firstname, lastname, subjectID " +
                "FROM teachers;");
        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            Teacher teacher = new Teacher(rs.getInt("id"),
                    rs.getString("username"), rs.getString("password"),
                    rs.getString("firstname"), rs.getString("lastname"), school.getSubject(rs.getInt("subjectID")));
            teachers.add(teacher);
        }
        return teachers;
    }

    public List<Staffer> loadStaff() throws SQLException {

        List<Staffer> staffers = new ArrayList<>();
        PreparedStatement preparedStatement = Connect.getConnection().prepareStatement("SELECT id, username, password, firstname, lastname " +
                "FROM staffers;");
        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            Staffer staffer = new Staffer(rs.getInt("id"),
                    rs.getString("username"), rs.getString("password"),
                    rs.getString("firstname"), rs.getString("lastname"));
            staffers.add(staffer);
        }
        return staffers;
    }

    public int load() {
        try {
            school.setSubjects(loadSubjects());
            school.setSchoolClasses(loadSchoolClasses());
            school.setStaffers(loadStaff());
            school.setTeachers(loadTeachers());
            school.setStudents(loadStudents());
            school.setVotes(loadVotes());
            return 0;
        } catch (SQLException ex) {
            System.err.println("Errore durante il caricamento delle risorse.. " + ex.getMessage());
            return 1;
        }
    }

    public School getSchool() {
        load();
        return school;
    }
}
