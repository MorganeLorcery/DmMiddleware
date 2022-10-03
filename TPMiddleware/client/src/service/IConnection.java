package service;

import java.rmi.RemoteException;

public interface IConnection {
    boolean signUp (String mail, String pwd) throws RemoteException;
    IVODService login(String mail, String pwd) throws RemoteException;
}
