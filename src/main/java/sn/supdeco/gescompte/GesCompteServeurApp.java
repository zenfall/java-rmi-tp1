package sn.supdeco.gescompte;

import com.sun.xml.internal.messaging.saaj.soap.name.NameImpl;
import sn.supdeco.gescompte.exceptions.CompteDebitException;
import sn.supdeco.gescompte.services.IOperation;
import sn.supdeco.gescompte.services.impl.IOperationImpl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Hello world!
 *
 */
public class GesCompteServeurApp
{
    public static void main( String[] args ) throws CompteDebitException
    {
        try {
            IOperationImpl operation = new IOperationImpl();
            IOperation stub = (IOperation) UnicastRemoteObject.exportObject(operation,0);
            LocateRegistry.createRegistry(2000);
            Naming.rebind("rmi://localhost:2000/operation", stub);
            System.out.println("Server Started !");
        }catch (RemoteException | MalformedURLException e){
           // e.printStackTrace();
            System.out.println(String.format("error : %s",e.getMessage()));
        }

    }
}
