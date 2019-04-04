package it.emes.test.database;

import it.emes.schoolmanagement.serializable.school.School;
import it.emes.schoolmanagement.serializable.school.SchoolClass;
import it.emes.schoolmanagement.serializable.user.Staff;
import it.emes.schoolmanagement.serializable.user.Student;

import java.sql.SQLException;

public class SchoolTest {

    public static void main(String[] args) throws SQLException {

        Staff staff = new Staff();

        //staff.addStudent(new Student("Sfera", "1234", "Sfera", "Ebbasta", new SchoolClass("La prima")));

        School.setup();
        for (Student st : School.getStudents()) {
            System.out.println(st);
        }

        System.out.println(School.getStudent(1));

//        staff.deleteUser(School.getStudents().get(1));
//
//        for (Student st : School.getStudents()) {
//            System.out.println(st);
//        }

    }

}
