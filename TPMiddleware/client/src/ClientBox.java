
import service.IClientBox;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Arrays;


public class ClientBox extends UnicastRemoteObject implements IClientBox {

    protected ClientBox(int port) throws RemoteException {
        super(port);
    }

    @Override
    public void stream(Byte[] chunck) throws RemoteException {
        System.out.println(Arrays.toString(chunck));
    }
}
