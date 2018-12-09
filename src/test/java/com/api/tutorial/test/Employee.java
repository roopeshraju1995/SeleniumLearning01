package com.api.tutorial.test;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Employee {

    @Test
    public void validateEmployee()
    {
        given().get("https://od-api-demo.oxforddictionaries.com:443/api/v1/filters").then().statusCode(200).log().all();
    }
}
