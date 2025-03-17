package com.petstore.endpoints;

import com.petstore.ConfigurationLoader;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;
import io.qameta.allure.restassured.AllureRestAssured;

import static io.restassured.filter.log.LogDetail.ALL;
import static io.restassured.http.ContentType.JSON;
import static org.apache.http.HttpHeaders.ACCEPT;


public class BaseEndpoint {

    public RequestSpecBuilder defaultRequestSpecification()  {
        return new RequestSpecBuilder()
                .setBaseUri(resolvedBaseUrl())
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

    private String resolvedBaseUrl() {
        ConfigurationLoader config = new ConfigurationLoader();
        String hostUrl = config.getProperty("petstore.base.url");
        String apiVersion = config.getProperty("api.version");
        return String.format("%s/api/%s", hostUrl, apiVersion);
    }

}
