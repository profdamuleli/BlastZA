package com.blastza.customer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class CustomerServiceTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void registerCustomer() {
        // given
        CustomerRegistrationRequest request = new CustomerRegistrationRequest(
              "Lutendo",
              "Damuleli",
                 "lutendo.damuleli.f@gmail.com"
        );
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        // when
        customerRepository.saveAndFlush(customer);

        // then
    }
}