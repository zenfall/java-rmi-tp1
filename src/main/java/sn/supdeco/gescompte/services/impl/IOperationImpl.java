package sn.supdeco.gescompte.services.impl;

import sn.supdeco.gescompte.exceptions.CompteDebitException;
import sn.supdeco.gescompte.models.Compte;
import sn.supdeco.gescompte.models.Utilisateur;
import sn.supdeco.gescompte.services.IOperation;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

public class IOperationImpl implements IOperation {
    private Map<String,Utilisateur> utilisateurs;
    private Map<String, Compte> comptes;

    public IOperationImpl() {
        this.utilisateurs = new HashMap<>();
        this.comptes = new HashMap<>();
    }

    @Override
    public Utilisateur creerUtilisateur(Utilisateur utilisateur) throws RemoteException {
       int id = utilisateurs.size()+1;
       utilisateur.setId(String.format("U%d",id));
       this.utilisateurs.put(utilisateur.getId(),utilisateur);
        System.out.println(utilisateurs.get(utilisateur.getId()));

       return utilisateurs.get(utilisateur.getId());


    }

    @Override
    public Compte creerCompte(Utilisateur utilisateur) throws RemoteException {
       int id = comptes.size()+1;


        Compte compte = new Compte(String.format("C%d",id), 10000, utilisateur);
        comptes.put(compte.getCompteId(),compte);

        return comptes.get(compte.getCompteId());


    }

    @Override
    public Compte debiterCompte(Compte compte, double montant) throws RemoteException, CompteDebitException {
        Compte utilisateurCompte = comptes.get(compte.getCompteId());
        utilisateurCompte.debiterCompte(montant);
        return utilisateurCompte;
    }

    @Override
    public Compte crediterCompte(Compte compte, double montant) throws RemoteException {
        Compte utilisateurCompte = comptes.get(compte.getCompteId());
        utilisateurCompte.crediterCompte(montant);
        return utilisateurCompte;
    }

    @Override
    public double consulterCompte(Compte compte) throws RemoteException {
        Compte utilisateurCompte = comptes.get(compte.getCompteId());

        return utilisateurCompte.getSolde();

    }
}
