package com.mywork.myspringboot.integrationtest;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@ExtendWith(SpringExtension.class)
public class BookControllerTest {
    @LocalServerPort
    private int port;

    @Value("${wiremock.server.url}")
    private String wireMockBaseUrl;

    private RestTemplate restTemplate = new RestTemplate();

    private static WireMockServer wireMockServer;

    @BeforeEach
    public void setup() {
        //System.out.println("port=" + port);
        wireMockServer = new WireMockServer(new WireMockConfiguration().port(8080));
        System.out.println("starting server at ");
        wireMockServer.start();
        System.out.println("server started at " + wireMockServer.port());
    }

    @AfterEach
    public void tearDown() {
        wireMockServer.stop();
        System.out.println("server stopped");
    }

    @Test
    public void yourTest() {
        System.out.println("entered test");
        System.out.println("wireMockBaseUrl: " + wireMockBaseUrl);
        System.out.println("get(urlEqualTo(\"/api/books/all\"))="+get(urlEqualTo("/api/books/all")));
        // Stubbing example
        stubFor(get(urlEqualTo("/api/books/all"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{ \"key\": \"value\" }")));
        // Make a request to your Spring Boot application
        System.out.println("Stubbed");
        String result = restTemplate.getForObject(wireMockBaseUrl + "/api/books/all", String.class);

        System.out.println("Returned " + result);

        // Assertions...
    }
}
