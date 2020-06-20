package com.fr.ensim.partyNow.APIRest.Metier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UtilisateurMetierImpl implements IUtilisateurMetier{
    private Map<String, Utilisateur> listUtilisateurs = new HashMap<String, Utilisateur>();

    @Override
    public Utilisateur ajouterUtilisateur(Utilisateur u) {
        return  listUtilisateurs.put(u.getEmail(), u);
    }

    @Override
    public boolean supprimerUtilisateur(String uEmail) {
        if(listUtilisateurs.get(uEmail)!=null) {
            listUtilisateurs.remove(uEmail);
            return true;
        }
        else throw new RuntimeException("User introuvable");
    }

    @Override
    public List<Utilisateur> listerUtilisateurs() {
        List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
        for(Utilisateur u : listUtilisateurs.values()) {
            utilisateurs.add(u);
        }
        return utilisateurs;
    }

    @Override
    public Utilisateur modifierUtilisateur(Utilisateur u) {
        Utilisateur u_avant = listUtilisateurs.get(u.getEmail());
        if(u_avant == null) {
            throw new RuntimeException("Utilisateur a modifier introuvable");
        }
        else {
            listUtilisateurs.remove(u.getEmail());
            listUtilisateurs.put(u.getEmail(), u);
        }
        return u;
    }
}
