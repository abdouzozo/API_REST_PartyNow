package com.fr.ensim.partyNow.APIRest.Metier;

public class Utilisateur {

    private long id;
    private String FirstName;
    private String LastName;
    private String email;
    private int tel;
    private String password;
    private String ville;
    private String pays;

    public Utilisateur(long id, String firstName, String lastName, String email, int tel, String password, String ville, String pays) {
        this.id = id;
        FirstName = firstName;
        LastName = lastName;
        this.email = email;
        this.tel = tel;
        this.password = password;
        this.ville = ville;
        this.pays = pays;
    }

    public Utilisateur(String firstName, String lastName, String email, int tel, String password) {
        FirstName = firstName;
        LastName = lastName;
        this.email = email;
        this.tel = tel;
        this.password = password;

    }

    public Utilisateur() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }
}
