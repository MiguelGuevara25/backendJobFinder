package pe.edu.upc.jobfinder.controllers;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/reddit")
public class RedditProxy {
    @GetMapping
    public ResponseEntity<String> buscarReddit(
            @RequestParam String q,
            @RequestParam(defaultValue = "5") int limit,
            @RequestParam(required = false) String after
    ) {
        String url = "https://www.reddit.com/search.json?q=" + q + "&limit=" + limit;
        if (after != null && !after.isEmpty()) {
            url += "&after=" + after;
        }

        HttpHeaders headers = new HttpHeaders();
        headers.set("User-Agent", "Mozilla/5.0 (Spring Boot Proxy)");
        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                requestEntity,
                String.class
        );

        return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    }
}