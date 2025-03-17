import com.petstore.endpoints.EndpointFactory;
import com.petstore.endpoints.StoreEndpoint;
import com.petstore.payloads.StoreOrderPayload;
import io.restassured.RestAssured;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static com.petstore.payloads.StoreOrderPayload.Status.APPROVED;
import static org.apache.http.HttpStatus.SC_NOT_FOUND;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.*;

/**
 *
 * For the sake of this exercise. Test are ordered to simulate an E2E CURD flow.
 * Normally, coupled dependant tests are not encouraged
 *
 */

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StoreTest {

    final StoreEndpoint storeEndpoint = EndpointFactory.createInstance(StoreEndpoint.class);
    final int RANDOM_ORDER_ID = 500;

    @Test
    @Order(2)
    public void given_getOrderRequest_when_orderIdIValid_then_orderSuccessfullyRetrievedWithAllFields() {
     RestAssured.given(storeEndpoint.orderByIdRequestSpecification(RANDOM_ORDER_ID))
             .get()
             .then()
             .spec(storeEndpoint.defaultResponseSpecification(SC_OK))
             .body("id", is(notNullValue()))
             .body("petId", is(notNullValue()))
             .body("quantity", is(notNullValue()))
             .body("status", is(notNullValue()))
             .body("complete", anyOf(is(true), is(false)))
             .body("shipDate", is(notNullValue()));
    }

    @Test
    @Order(4)
    public void given_getOrderRequest_when_orderIdIsInvalid_then_orderNotFound() {
        RestAssured.given(storeEndpoint.orderByIdRequestSpecification(RANDOM_ORDER_ID))
                .get()
                .then()
                .spec(storeEndpoint.defaultResponseSpecification(SC_NOT_FOUND))
                .body(is("Order not found"));
    }

    @Test
    @Order(3)
    public void given_deleteOrderRequest_when_orderIdIsValid_then_orderSuccessfullyDeleted() {
        RestAssured.given(storeEndpoint.orderByIdRequestSpecification(RANDOM_ORDER_ID))
                .delete()
                .then()
                .log()
                .all()
                .statusCode(SC_OK);
    }

    @Test
    @Order(5)
    public void given_deleteOrderRequest_when_orderIdDoesNotExit_then_orderNotFound() {
        RestAssured.given(storeEndpoint.orderByIdRequestSpecification(RANDOM_ORDER_ID))
                .delete()
                .then()
                .log()
                .all()
                .statusCode(SC_NOT_FOUND);
    }

    @Test
    @Order(1)
    public void given_postOrderRequest_when_orderPayloadIsValid_then_orderSuccessfullyCreated() {
        StoreOrderPayload payload = new StoreOrderPayload(RANDOM_ORDER_ID, 2, 3, APPROVED, true);

        RestAssured.given(storeEndpoint.postRequestSpecification(payload))
                .post()
                .then()
                .spec(storeEndpoint.defaultResponseSpecification(SC_OK))
                .body("id", is(payload.getId()))
                .body("petId", is(payload.getPetId()))
                .body("quantity", is(payload.getQuantity()))
                .body("status", is(payload.getStatus()));
    }
}
