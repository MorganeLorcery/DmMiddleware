import Exceptions.InvalidCredentialsException;
import Exceptions.SignUpException;
import service.*;

import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Scanner;

public class Display {

    Scanner sc = new Scanner(System.in);
    IVODService iVODService = null;

    String askEmail(){
        System.out.println("Veuillez saisir votre email");
        String email = sc.nextLine();
        return email;
    }

    String askPwd(){
        System.out.println("Veuillez saisir votre mot de passe");
        String pwd = sc.nextLine();
        return pwd;
    }

    IVODService login(IConnection stub) throws InvalidCredentialsException, RemoteException {
        iVODService =stub.login(askEmail(),askPwd());
        while (iVODService==null){
            System.out.println("Le mot de passe ou l'email est incorrect, veuillez réessayer");
            iVODService = stub.login(askEmail(),askPwd());
        }
        return iVODService;
    }


    void signIn(IConnection stub) throws RemoteException, SignUpException {
        boolean isValidMail = stub.signUp(askEmail(),askPwd());
        while(!isValidMail){
            System.out.println("L'email existe déjà, veuillez en saisir un nouveau");
            isValidMail = stub.signUp(askEmail(),askPwd());
        }
        System.out.println("Inscription reussie !");
    }

    void searchMovie() throws RemoteException {
        IClientBox clientBox = new ClientBox(2001);
        System.out.println("Voici le catalogue des films disponibles");
        List<MovieDesc> movieDescs =iVODService.viewCatalog();
        System.out.println(movieDescs);
        System.out.println("Veuillez saisir l'identifiant du film que vous souhaitez visionner");
        String ibs = sc.nextLine();
        Bill bill = iVODService.playMovie(ibs,clientBox);

        while(bill==null){
            System.out.println("Film introuvable, voici le catalogue des films disponibles");
            System.out.println(movieDescs);
            System.out.println("Veuillez saisir l'identifiant du film que vous souhaitez visionner");
            ibs = sc.nextLine();
            bill = iVODService.playMovie(ibs,clientBox);
        }
        System.out.println("Veuillez payer "+bill +" euros");
    }
}
