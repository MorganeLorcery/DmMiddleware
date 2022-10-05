import service.Bill;
import service.IClientBox;
import service.IVODService;
import service.MovieDesc;

import java.math.BigInteger;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class VODService extends UnicastRemoteObject implements IVODService {

    protected VODService() throws RemoteException {
    }

    public List<MovieDesc> viewCatalog() throws RemoteException{
        return List.of(
                new MovieDesc("test","111-111-111-11-1-1","oui",new byte[]{0, 1, 0,0, 1, 0,0, 1, 0,0, 1, 0}),
                new MovieDesc("test","111-111-111-11-1-0","oui",new byte[]{0, 1, 0,0, 1, 0,0, 1, 0,0, 1, 0}),
                new MovieDesc("test","111-111-111-11-1-2","oui",new byte[]{0, 1, 0,0, 1, 0,0, 1, 0,0, 1, 0})
        );
    }

    @Override
    public synchronized Bill playMovie(String isbn, IClientBox box) throws RemoteException {
        final int NB_BIT = 5;
        Optional<MovieDesc> movieDescOptional= viewCatalog().stream().filter(movie -> movie.getIsbn().equals(isbn)).findFirst();
        System.out.println(movieDescOptional);
        if(movieDescOptional.isPresent()){
            byte[] bytes = movieDescOptional.get().getBytes();
            box.stream(Arrays.copyOfRange(bytes,0,NB_BIT));
            new Thread(() -> {
                for(int i=NB_BIT;i<bytes.length;i+=NB_BIT){
                    try{
                        box.stream(Arrays.copyOfRange(bytes,i,Math.min((i+NB_BIT),bytes.length)));
                    }catch (RemoteException e){
                        e.printStackTrace();
                    }
                }
            }).start();
            return new Bill(movieDescOptional.get().getMovieName(),(BigInteger.TEN));
        }
        return null;
    }
}
