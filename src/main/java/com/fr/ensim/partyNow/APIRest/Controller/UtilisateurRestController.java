package com.fr.ensim.partyNow.APIRest.Controller;

import com.fr.ensim.partyNow.APIRest.Metier.Utilisateur;
import com.fr.ensim.partyNow.APIRest.Metier.UtilisateurMetierImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class UtilisateurRestController {
    private UtilisateurMetierImpl metier;

    // Simulation d'un séquenceur pour générer l'identifiant des utilisateurs
    private AtomicInteger fakeSeq = new AtomicInteger(0);

    public UtilisateurRestController() {
        metier = new UtilisateurMetierImpl();
    }

    @GetMapping("/api/utilisateur")
    public List<Utilisateur> listerUtilisateurs(){
        System.out.println("lister All success");
        return metier.listerUtilisateurs();
    }

    @GetMapping("/api/utilisateur/{email}")
    public ResponseEntity<Utilisateur> recupererUtilisateur(@PathVariable("email") String uEmail){


        for(Utilisateur u : metier.listerUtilisateurs()){
            if(u.getEmail().equals(uEmail))
                return ResponseEntity.ok().body(u);
        }
        return null;
    }


    @PostMapping(path= "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Utilisateur> ajouterUtilisateur(@RequestBody Utilisateur u) {

        u.setId(fakeSeq.incrementAndGet()-1);
        // URI de localisation de la ressource
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{email}").build(u.getEmail());

        metier.ajouterUtilisateur(u);
        System.out.println("Add success");

        // réponse 201 avec la localisation et la ressource créée
        return ResponseEntity.created(location).body(u);

    }

    @DeleteMapping("/api/utilisateur/{email}")
    public  ResponseEntity<Utilisateur> supprimerUtilisateur(@PathVariable("email") @NonNull String uEmail) {
        metier.supprimerUtilisateur(uEmail);
        System.out.println("Delete success");
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/api/utilisateur/{email}")
    public ResponseEntity<Utilisateur> modifierUtilisateur(@PathVariable("email") String uEmail, @RequestBody Utilisateur u) {


        metier.modifierUtilisateur(u);

        // réponse 201
        return ResponseEntity.ok().body(u);
    }

}
