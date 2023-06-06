package com.blue.blastZA.dao.impl;

import com.blue.blastZA.dao.CustomerDao;
import com.blue.blastZA.model.Customer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CustomerDaoImplTest {

    @Autowired
    private CustomerDao customerDao;

    @Test
    void itShouldGetAllCustomers() {
    }

    @Test
    void itShouldGetACustomerById() {
        //given
        Customer customer = new Customer();
        customer.setCustomer_id(1);
        customer.setFirst_name("Lutendo");
        customer.setLast_name("Damuleli");
        customer.setPoints(100);
        customer.setAddress("11 Main Street");
        customer.setCity("Johannesburg");
        customer.setState("ZA");
        customer.setBirth_date(null);
        customer.setPhone("0815588153");

        Mockito.when(customerDao.get(1)).thenReturn(customer);
    }

    @Test
    void itShouldSave() {
    }

    @Test
    void itShouldDelete() {
    }
}