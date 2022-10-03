package service;

import service.IVODService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class VODService extends UnicastRemoteObject implements IVODService {

    public VODService(int numport) throws RemoteException {
        super(numport);
    }

    public List<MovieDesc> viewCatalog(){
        return null;
    }

    public Bill playmovie(String isbn, IClientBox box){
        return new Bill();
    }

}
