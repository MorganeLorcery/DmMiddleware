package Exceptions;

import java.rmi.RemoteException;

public class InvalidCredentialsException extends RemoteException {

    public InvalidCredentialsException(String s) {
        super(s);
    }

}
