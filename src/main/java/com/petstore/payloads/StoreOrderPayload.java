package com.petstore.payloads;

import java.time.Instant;
import java.time.format.DateTimeFormatter;

public class StoreOrderPayload {

    private int id;
    private int petId;
    private int quantity;
    private String shipDate;
    private String status;
    private boolean complete;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getShipDate() {
        return shipDate;
    }

    public void setShipDate(String shipDate) {
        this.shipDate = shipDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status.value;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public StoreOrderPayload(int id, int petId, int quantity, Status status, boolean complete) {
        this.id = id;
        this.petId = petId;
        this.quantity = quantity;
        this.status = status.value;
        this.complete = complete;
        this.shipDate = DateTimeFormatter.ISO_INSTANT.format(Instant.now());
    }

    public enum Status {
        PLACED("placed"),
        APPROVED("approved"),
        DELIVERED("delivered");

        private final String value;

        Status(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
