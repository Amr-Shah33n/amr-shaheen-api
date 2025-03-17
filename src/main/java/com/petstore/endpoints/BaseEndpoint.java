package com.petstore.endpoints;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;
import io.qameta.allure.restassured.AllureRestAssured;

import static io.restassured.filter.log.LogDetail.ALL;
import static io.restassured.http.ContentType.JSON;
import static org.apache.http.HttpHeaders.ACCEPT;


public class BaseEndpoint {

    public static final String BASE_URL = "https://petstore3.swagger.io/api/v3";

    public RequestSpecBuilder defaultRequestSpecification()  {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .setContentType(JSON)
                .addHeader(ACCEPT, JSON.getAcceptHeader())
                .log(ALL)
                .addFilter(new AllureRestAssured());
    }

    public ResponseSpecification defaultResponseSpecification(int statusCode) {
        return new ResponseSpecBuilder()
                .expectStatusCode(statusCode)
                .log(ALL)
                .build();
    }
}
