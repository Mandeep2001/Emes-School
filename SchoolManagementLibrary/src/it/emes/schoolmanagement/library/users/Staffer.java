package it.emes.schoolmanagement.library.users;

import java.io.Serializable;
import java.util.List;

public class Staffer extends User implements Serializable {

    private UserType userType = UserType.STAFF;

    public Staffer() {}

    public Staffer(String username, String password) {
        super(username, password);
    }

    public Staffer(int ID, String username, String password, String firstname, String lastname) {
        super(ID, username, password, firstname, lastname);
    }

    /**
     * Metodo per aggiungere uno studente.
     * Questo metodo consente di aggiungere uno studente nuovo se non ne esiste già uno con quello username.
     * @param list Lista dove aggiungere lo studente
     * @param student Studente da aggiungere
     * @return 0 se lo studente viene aggiunto, 1 se lo studente esiste già
     */
    public int addStudent(List<Student> list, Student student) {
        for (Student st : list) {
            if (st.getUsername().equals(student.getUsername()))
                return 1;
        }
        list.add(student);
        return 0;
    }

    @Override
    public UserType getUserType() {
        return userType;
    }

}
