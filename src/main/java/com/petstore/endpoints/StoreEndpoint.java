package com.petstore.endpoints;

import com.petstore.payloads.StoreOrderPayload;
import io.restassured.specification.RequestSpecification;

public class StoreEndpoint extends BaseEndpoint {

    private final String ORDER_BY_ID_PATH = "/store/order/{orderId}";
    private final String POST_ORDER_PATH = "/store/order";

    public RequestSpecification orderByIdRequestSpecification(int orderId)  {
        return super.defaultRequestSpecification()
                .setBasePath(ORDER_BY_ID_PATH)
                .addPathParam("orderId", orderId)
                .build();
    }

    public RequestSpecification postRequestSpecification(StoreOrderPayload payload)  {
        return super.defaultRequestSpecification()
                .setBasePath(POST_ORDER_PATH)
                .setBody(payload)
                .build();
    }

}
