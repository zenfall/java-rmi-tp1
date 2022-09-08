package sn.supdeco.gescompte.models;

public class Compte {
    private String compteId;
    private double solde;
    private Utilisateur utilisateur;

    public Compte(String compteId, double solde, Utilisateur utilisateur) {
        this.compteId = compteId;
        this.solde = solde;
        this.utilisateur = utilisateur;
    }

    public String getCompteId() {
        return compteId;
    }

    public void setCompteId(String compteId) {
        this.compteId = compteId;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
}
