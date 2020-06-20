package com.fr.ensim.partyNow.APIRest.Metier;

import java.util.List;

public interface IUtilisateurMetier {
    public Utilisateur ajouterUtilisateur(Utilisateur u);
    public boolean supprimerUtilisateur(String uEmail);
    public Utilisateur modifierUtilisateur(Utilisateur u);
    public List<Utilisateur> listerUtilisateurs();
}
