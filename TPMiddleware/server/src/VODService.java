import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class VODService extends UnicastRemoteObject implements IVODService {
    protected VODService(int numport) throws RemoteException {
        super(numport);
    }
}
