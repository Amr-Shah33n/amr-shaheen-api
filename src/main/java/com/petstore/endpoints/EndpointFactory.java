package com.petstore.endpoints;

public class EndpointFactory {

    public static <T> T createInstance(Class<T> clazz) {
        try {
            return clazz.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Failed to create an instance of " + clazz.getName(), e);
        }
    }
}
