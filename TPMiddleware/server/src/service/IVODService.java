package service;

import java.rmi.Remote;
import java.util.List;

public interface IVODService extends Remote {

    List<MovieDesc> viewCatalog();
    Bill playmovie(String isbn, IClientBox box);
}
