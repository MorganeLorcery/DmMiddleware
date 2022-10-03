package service;

import java.rmi.Remote;

public interface IClientBox extends Remote {
    void stream(Byte[] chunck);
}
