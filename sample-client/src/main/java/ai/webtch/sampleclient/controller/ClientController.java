package ai.webtch.sampleclient.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.http.client.JdkClientHttpRequestFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
@RequestMapping("/client")
public class ClientController {

    private final RestClient restClient;

    public ClientController(RestClient.Builder restClientBuilder) {
        restClient = restClientBuilder
                .baseUrl("http://localhost:8081/api/person/")
                .requestFactory(new JdkClientHttpRequestFactory())
                .build();

    }

    @GetMapping("/simpleGreeting")
    public String simpleGreeting() {
        String response = restClient
                .get()
                .uri("/greeting")
                .retrieve()
                .body(String.class);
        System.out.println("Response: " + response);
        return response;
    }

    @GetMapping("/responseEntityGreeting")
    public ResponseEntity<String> greetingWithHeaders() {

        ResponseEntity<String> greetingWithHeaders = restClient
                .get()
                .uri("/responseEntityGreeting")
                .retrieve()
                .toEntity(String.class);

        System.out.println("Response status: " + greetingWithHeaders.getStatusCode());
        System.out.println("Response headers: " + greetingWithHeaders.getHeaders());
        System.out.println("Content: " + greetingWithHeaders.getBody());

        return greetingWithHeaders;
    }

    @GetMapping("/objectGreeting")
    public Person objectGreeting () {
        return restClient
                .get()
                .uri("/personObjectGreeting")
                .retrieve()
                .body(Person.class);
    }


}
