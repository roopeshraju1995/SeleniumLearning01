package com.api.tutorial.test;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Employee {

    @Test
    public void validateEmployee()
    {
        given().get("http://localhost:8080/SprintRestServices/employee/getEmployee").then().statusCode(200).log().all();
    }
}
