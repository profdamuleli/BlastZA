package com.blue.blastZA.controller;

import com.blue.blastZA.model.Customer;
import com.blue.blastZA.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    @MockBean
    CustomerService customerService;
    @Autowired
    MockMvc mockMvc;

    @Test
    public void test_getCustomerById() throws Exception {
        int id = 1;
        Customer customer = this.getCustomer();
        Mockito.when(customerService.getCustomerById(id)).thenReturn(customer);
        Customer results = customerService.getCustomerById(id);

        mockMvc.perform(get("/api/v1/customer/1")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(new ObjectMapper().writeValueAsString(customer)))
                .andExpect(status().is2xxSuccessful());

        assertThat(results).isNotEqualTo(null);
    }

    @Test
    public void test_deleteCustomerById() throws Exception {
        int id = 1;
        Customer customer = this.getCustomer();
        Mockito.doNothing().when(customerService).deleteById(id);
        customerService.deleteById(id);

        mockMvc.perform(delete("/api/v1/delete/customer/1")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(new ObjectMapper().writeValueAsString(customer)))
                .andExpect(status().is2xxSuccessful());

        assertThat(id).isNotNegative();
    }

    @Test
    public void test_getCustomerList() throws Exception {
        List<Customer> customerList = this.getCustomers();
        Mockito.when(customerService.getCustomers()).thenReturn(customerList);
        List<Customer> customers = customerService.getCustomers();

        mockMvc.perform(get("/api/v1/customer")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(new ObjectMapper().writeValueAsString(customerList)))
                .andExpect(status().is2xxSuccessful());

        assertThat(customers).isNotEmpty();
    }

    @Test
    public void test_saveCustomer() throws Exception {
        Customer customer = this.getCustomer();
        Mockito.doNothing().when(customerService).createCustomer(customer);
        customerService.createCustomer(customer);
        mockMvc.perform(post("/api/v1/customer")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new ObjectMapper().writeValueAsString(customer)))
                .andExpect(status().is2xxSuccessful());

        assertThat(customer).isNotEqualTo(null);
    }

    @Test
    public void test_upDateCustomer() throws Exception {
        Customer customer = this.getCustomer();
        Mockito.when(customerService.updateCustomer(customer)).thenReturn(this.getCustomerUpdated());
        Customer results = customerService.updateCustomer(customer);

        mockMvc.perform(put("/api/v1/customer")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(new ObjectMapper().writeValueAsString(customer)))
                .andExpect(status().is2xxSuccessful());

        assertThat(results).isNotEqualTo(this.getCustomerUpdated());
    }

    public Customer getCustomer(){
        Customer customer = new Customer();
        customer.setFirst_name("Lutendo");
        customer.setLast_name("Damuleli");
        customer.setAddress("68 Main Street");
        customer.setPhone("0815588153");
        customer.setPoints(68);
        customer.setCity("Johannesburg");
        customer.setState("ZA");
        customer.setBirth_date(null);
        return customer;
    }

    public Customer getCustomerUpdated(){
        Customer customer = new Customer();
        customer.setFirst_name("Lutendo");
        customer.setLast_name("Masiagwala");
        customer.setAddress("68 Main Street");
        customer.setPhone("0815588153");
        customer.setPoints(68);
        customer.setCity("Johannesburg");
        customer.setState("ZA");
        customer.setBirth_date(null);
        return customer;
    }

    public List<Customer> getCustomers() {
        List<Customer> customers = new ArrayList<>();
        Customer customer = this.getCustomer();

        Customer customer1 = new Customer();
        customer1.setFirst_name("Lutendo1");
        customer1.setLast_name("Damuleli1");
        customer1.setAddress("68 Main Street1");
        customer1.setPhone("08155881531");
        customer1.setPoints(681);
        customer1.setCity("Johannesburg1");
        customer1.setState("ZA1");
        customer1.setBirth_date(null);

        customers.add(customer);
        customers.add(customer1);
        return customers;
    }
}
