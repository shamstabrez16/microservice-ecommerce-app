package com.shamstabrez16.productservice;

import org.testcontainers.containers.PostgreSQLContainer;

public class CustomPostgreSQLContainer extends PostgreSQLContainer<CustomPostgreSQLContainer> {
    public CustomPostgreSQLContainer(String dockerImageName) {
        super(dockerImageName);
        withDatabaseName("productservice1"); // Change to your desired database name
        withUsername("postgres");   // Change to your desired username
        withPassword("mysecretpassword");   // Change to your desired password
    }
}

