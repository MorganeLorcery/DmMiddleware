import Exceptions.InvalidCredentialsException;
import Exceptions.SignUpException;
import service.*;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws RemoteException {
        try{
            Display display = new Display();
            Registry reg = LocateRegistry.getRegistry(2001);
            IConnection stub = (IConnection)reg.lookup("connexion");
            System.out.println("Bienvenue ! Avez-vous déjà un compte ? (O/N)");
            Scanner s = new Scanner(System.in);
            if (s.equals("O")) display.login(stub);
            if (s.equals("N")) display.signIn(stub);
            else return;
            display.searchMovie();
        }
        catch (RemoteException | NotBoundException | SignUpException | InvalidCredentialsException e){
            e.printStackTrace();
        }
    }
}
