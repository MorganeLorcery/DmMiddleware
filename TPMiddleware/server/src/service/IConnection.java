package service;

import Exceptions.InvalidCredentialsException;
import Exceptions.SignUpException;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IConnection extends Remote {
    boolean signUp (String mail, String pwd) throws RemoteException, SignUpException;
    IVODService login(String mail, String pwd) throws RemoteException, InvalidCredentialsException, InvalidCredentialsException;
}
