package com.shamstabrez16.orderservice;

import org.testcontainers.containers.PostgreSQLContainer;

public class CustomPostgreSQLContainer extends PostgreSQLContainer<CustomPostgreSQLContainer> {
    public CustomPostgreSQLContainer(String dockerImageName) {
        super(dockerImageName);
        withDatabaseName("orderservice"); // Change to your desired database name
        withUsername("postgres");   // Change to your desired username
        withPassword("yourpassword");   // Change to your desired password
    }
}