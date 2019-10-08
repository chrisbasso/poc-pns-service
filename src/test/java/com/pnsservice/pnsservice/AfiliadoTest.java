package com.pnsservice.pnsservice;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import javax.annotation.PostConstruct;

import static io.restassured.RestAssured.get;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class AfiliadoTest
{

    @LocalServerPort
    private int port;

    private String uri;

    @PostConstruct
    public void init()
    {
        uri = "http://192.168.12.173:" + port;
    }

    @Test
    public void getAfiliadosTest()
    {
        get("/afiliado/").then().statusCode(200).assertThat();
    }

}
