package com.example.loyal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;

@SpringBootApplication
public class LoyalApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoyalApplication.class, args);
        // Adres URL API Subiekta GT
        String apiUrl = "http://<adres_serwera>:<numer_portu>/api";

        // Nazwa użytkownika i hasło do API Subiekta GT
        String username = "<nazwa_użytkownika>";
        String password = "<hasło>";

        // Tworzenie obiektu RestTemplate, który umożliwia wykonywanie żądań HTTP
        RestTemplate restTemplate = new RestTemplate();

        // Ustawienie nagłówków żądania HTTP Basic Auth z danymi do autoryzacji
        String authHeader = username + ":" + password;
        byte[] authHeaderBytes = authHeader.getBytes();
        String encodedAuthHeader = Base64.getEncoder().encodeToString(authHeaderBytes);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Basic " + encodedAuthHeader);

        // Wykonanie żądania HTTP GET do API Subiekta GT, aby pobrać listę kontrahentów
        String endpoint = apiUrl + "/kontrahenci";
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(endpoint, HttpMethod.GET, requestEntity, String.class);

        // Sprawdzenie kodu statusu odpowiedzi HTTP
        HttpStatus statusCode = (HttpStatus) responseEntity.getStatusCode();
        if (statusCode == HttpStatus.OK) {
            // Pobranie danych z odpowiedzi HTTP w postaci JSON i wyświetlenie ich na konsoli
            String responseBody = responseEntity.getBody();
            System.out.println(responseBody);
        } else {
            // Wyświetlenie komunikatu o błędzie, jeśli żądanie nie powiodło się
            String errorMessage = "Nie udało się pobrać listy kontrahentów. Kod statusu: " + statusCode.toString();
            System.out.println(errorMessage);
        }
    }
}