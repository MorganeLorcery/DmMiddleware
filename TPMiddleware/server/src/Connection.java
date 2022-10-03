import service.IConnection;
import service.IVODService;
import service.MovieDesc;

import java.lang.reflect.Array;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class Connection extends UnicastRemoteObject implements IConnection {

    Array clientList;
    List<MovieDesc> Movies;

    protected Connection(int numport) throws RemoteException {
        super(numport);
    }

    public boolean signUp(String mail, String pwd) throws RemoteException, SignUpException {

    }

    public IVODService login(String mail, String pwd) throws RemoteException, InvalidCredentialsException {

    }

    public Array getClientList() {
        return clientList;
    }

    public List<MovieDesc> getMovies() {
        return Movies;
    }
}
