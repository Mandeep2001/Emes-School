package it.emes.schoolmanagement.database.dao;

import it.emes.schoolmanagement.database.Connect;
import it.emes.schoolmanagement.serializable.school.School;
import it.emes.schoolmanagement.serializable.school.SchoolClass;
import it.emes.schoolmanagement.serializable.school.Subject;
import it.emes.schoolmanagement.serializable.school.Vote;
import it.emes.schoolmanagement.serializable.user.Staff;
import it.emes.schoolmanagement.serializable.user.Student;
import it.emes.schoolmanagement.serializable.user.Teacher;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SchoolDAO {

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
                    rs.getString("firstname"), rs.getString("lastname"), School.getSchoolClasse(rs.getInt("classID")));
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
                    rs.getString("firstname"), rs.getString("lastname"), School.getSubject(rs.getInt("subjectID")));
            teachers.add(teacher);
        }
        return teachers;
    }

    public List<Staff> loadStaff() throws SQLException {

        List<Staff> staff = new ArrayList<>();
        PreparedStatement preparedStatement = Connect.getConnection().prepareStatement("SELECT id, username, password, firstname, lastname " +
                "FROM staffers;");
        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            Staff staffer = new Staff(rs.getInt("id"),
                    rs.getString("username"), rs.getString("password"),
                    rs.getString("firstname"), rs.getString("lastname"));
            staff.add(staffer);
        }
        return staff;
    }

}
