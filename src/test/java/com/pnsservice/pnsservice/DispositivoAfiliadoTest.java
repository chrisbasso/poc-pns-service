package com.pnsservice.pnsservice;


import com.pnsservice.pnsservice.document.Token;
import com.pnsservice.pnsservice.dto.TokenRequest;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import javax.annotation.PostConstruct;

import static io.restassured.RestAssured.given;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class DispositivoAfiliadoTest
{

    @LocalServerPort
    private int port;

    private String uri;

    @PostConstruct
    public void init()
    {
        uri = "http://localhost:" + port;
    }

    @Test
    public void addTokenTest()
    {
        TokenRequest tokenRequest =  new TokenRequest();
        tokenRequest.setCredencial("0218520801");
        tokenRequest.setTokens(new Token("fcm", "000","Expo000"));

        given()
                .contentType("application/json")
                .body(tokenRequest)
                .when()
                .post("/dispositivoAfiliado").then().statusCode(201).assertThat();
    }

    @Test
    public void deleteTokenTest()
    {
        Token token = new Token("fcm", "000","Expo000");

        given()
                .contentType("application/json")
                .body(token)
                .when()
                .delete("/dispositivoAfiliado").then().statusCode(200).assertThat();
    }

}