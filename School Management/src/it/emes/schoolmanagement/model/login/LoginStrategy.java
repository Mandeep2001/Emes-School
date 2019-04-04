package it.emes.schoolmanagement.model.login;

public class LoginStrategy implements Login {

    /**
     *  Questo metodo permette di effettuare il login confrontando l'username e la password inserite.
     * @param username username dell'utente
     * @param password password dell'utente
     * @return {@code true} se il login ha successo
     */
    @Override
    public boolean login(String username, String password) {
        return false;
    }
}
