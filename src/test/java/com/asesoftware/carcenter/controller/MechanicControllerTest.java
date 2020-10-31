package com.asesoftware.carcenter.controller;

import com.asesoftware.carcenter.Main;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Prueba de integración servicios mechanics
 *
 * @author adrian
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MechanicControllerTest {

    @LocalServerPort
    private int port;
    private static final TestRestTemplate REST_TEMPLATE = new TestRestTemplate();
    
    private String createURLWithPort(String uri) {
        return "http://localhost:"
                .concat(String.valueOf(port)).concat("/api/v1").concat(uri);
    }
    
    @Test
    public void getAvailableMechanics() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> response = REST_TEMPLATE.exchange(
                createURLWithPort("/mechanic/available-mechanics"),
                HttpMethod.GET, entity, String.class);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
