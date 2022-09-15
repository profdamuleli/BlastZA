package com.blastza.customer;

public record CustomerRegistrationRequest(
    String firstName,
    String lastName,
    String email) {
}
