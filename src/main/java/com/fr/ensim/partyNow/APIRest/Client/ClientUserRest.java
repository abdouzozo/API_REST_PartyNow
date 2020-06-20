package com.fr.ensim.partyNow.APIRest.Client;

import java.net.URISyntaxException;

import java.io.IOException;
import java.net.URI;
import java.util.Base64;

import com.fr.ensim.partyNow.APIRest.Metier.Utilisateur;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

public class ClientUserRest {
    public static void main(String[] args) throws URISyntaxException {
        // Client REST fourni par le framework Spring
        RestTemplate restTemplate = new RestTemplate();

        final String baseUrl = "http://localhost:8080";
        URI uri = new URI(baseUrl);

        Utilisateur user_1 = new Utilisateur("Abdou","Zozo","abdouzozo@gmail.com",074,"monpassword");
        ResponseEntity<String> result = restTemplate.postForEntity(uri, user_1, String.class);
        //Verify request succeed
        System.out.println("le code retour est : "+ result.getStatusCodeValue());

        Utilisateur user_2 = new Utilisateur("Jean","Michelle","jeanmichelle@gmail.com",044,"monpassword");
         result = restTemplate.postForEntity(uri, user_2, String.class);
        //Verify request succeed
        System.out.println("le code retour est : "+ result.getStatusCodeValue());

        Utilisateur user_3 = new Utilisateur("Pierre","Lebis","pierrelebis@gmail.com",054,"monpassword");
         result = restTemplate.postForEntity(uri, user_3, String.class);
        //Verify request succeed
        System.out.println("le code retour est : "+ result.getStatusCodeValue());

    }
}
