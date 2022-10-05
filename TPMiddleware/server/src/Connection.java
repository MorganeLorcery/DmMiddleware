import Exceptions.InvalidCredentialsException;
import Exceptions.SignUpException;
import service.*;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Connection extends UnicastRemoteObject implements IConnection {

    ArrayList<Client> clientList;
    IVODService movies;

    protected Connection() throws RemoteException {
        super();
    }

    public boolean signUp(String mail, String pwd) throws RemoteException, SignUpException {
        try {
            SignUpException.controle(mail, clientList);
            clientList.add(new Client(mail, pwd));
            return true;
        }
        catch(SignUpException signUpException){
            signUpException.printStackTrace();
            return false;
        }
    }

    public IVODService login(String mail, String pwd) throws RemoteException, InvalidCredentialsException {
        try {
            InvalidCredentialsException.controle(mail, pwd, clientList);
            return this.movies;
        }
        catch(InvalidCredentialsException invalidCredentialsException){
            invalidCredentialsException.printStackTrace();
            return null;
        }
    }

    public ArrayList<Client> getClientList() {
        return clientList;
    }

    public IVODService getMovies() {
        return movies;
    }
}
