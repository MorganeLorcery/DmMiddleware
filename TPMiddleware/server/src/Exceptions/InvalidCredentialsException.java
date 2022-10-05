package Exceptions;

import service.Client;

import java.util.ArrayList;
import java.util.Optional;

public class InvalidCredentialsException extends Exception {
    public InvalidCredentialsException(){
        super();
    }

    public static void controle(String mail, String password, ArrayList<Client> clientList) throws InvalidCredentialsException {
        Optional<Client> user = clientList.stream().filter(client -> mail.equals(client.getMail())).findFirst();
        if(user.get().getPassword().equals(password))
            throw new InvalidCredentialsException();
    }
}
