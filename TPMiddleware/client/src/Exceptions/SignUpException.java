package Exceptions;

import service.Client;

import java.util.ArrayList;
import java.util.Optional;

public class SignUpException extends Exception {

    public SignUpException(){
        super();
    }

    public static void controle(String mail, ArrayList<Client> clientList) throws SignUpException {
        Optional<Client> user = clientList.stream().filter(client -> mail.equals(client.getMail())).findAny();
        if(user.isPresent()){
            throw new SignUpException();
        }
    }

}
