import java.lang.reflect.Array;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Connection extends UnicastRemoteObject implements RMIInterface{

    Array clientList;
    xxx Movies;

    protected Connection(int numport) throws RemoteException {
        super(numport);
    }

    boolean signUp (String mail, String pwd) throws SignInFailed;

    IVODService login(String mail, String pwd) throws InvalidCredentialsException;
}
