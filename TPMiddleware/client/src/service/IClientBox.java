package service;

import java.rmi.RemoteException;

public interface IClientBox{
    void stream(Byte[] chunck) throws RemoteException;
}
