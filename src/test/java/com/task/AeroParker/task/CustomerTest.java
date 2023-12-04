package com.task.AeroParker.task;

import com.task.AeroParker.task.Model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

class CustomerTest {

    private Customer customer;

    @BeforeEach
    void setup() {
        customer = new Customer();
    }

    @Test
    void testDefaultConstructor() {
        assertNotNull(customer);
    }

    @Test
    void testParameterizedConstructor() {
        String email = "test@example.com";
        String title = "Mr";
        String firstName = "John";
        String lastName = "Doe";
        String addressLine1 = "123 Main St";
        String addressLine2 = "Apt 4";
        String city = "Metropolis";
        String postcode = "12345";
        String phoneNumber = "555-1234";

        Customer customer = new Customer(email, title, firstName, lastName, addressLine1, addressLine2, city, postcode, phoneNumber);

        assertEquals(email, customer.getEmailAddress());
        assertEquals(title, customer.getTitle());
        assertEquals(firstName, customer.getFirstName());
        assertEquals(lastName, customer.getLastName());
        assertEquals(addressLine1, customer.getAddressLine1());
        assertEquals(addressLine2, customer.getAddressLine2());
        assertEquals(city, customer.getCity());
        assertEquals(postcode, customer.getPostcode());
        assertEquals(phoneNumber, customer.getPhoneNumber());
        assertNotNull(customer.getRegistered());
    }

    @Test
    void testSettersAndGetters() {
        String testValue = "Test";
        customer.setEmailAddress(testValue);
        assertEquals(testValue, customer.getEmailAddress());

        customer.setTitle(testValue);
        assertEquals(testValue, customer.getTitle());

        customer.setFirstName(testValue);
        assertEquals(testValue, customer.getFirstName());

        customer.setLastName(testValue);
        assertEquals(testValue, customer.getLastName());

        customer.setAddressLine1(testValue);
        assertEquals(testValue, customer.getAddressLine1());

        customer.setAddressLine2(testValue);
        assertEquals(testValue, customer.getAddressLine2());

        customer.setCity(testValue);
        assertEquals(testValue, customer.getCity());

        customer.setPostcode(testValue);
        assertEquals(testValue, customer.getPostcode());

        customer.setPhoneNumber(testValue);
        assertEquals(testValue, customer.getPhoneNumber());
    }

    @Test
    void testPrePersist() {
        Customer newCustomer = new Customer();
        assertNull(newCustomer.getRegistered());

        newCustomer = new Customer("email@example.com", "Mr", "John", "Doe", "123 Main St", "Apt 4", "City", "12345", "555-1234");
        LocalDateTime registrationTime = newCustomer.getRegistered();

        assertNotNull(registrationTime);
        assertTrue(registrationTime.isBefore(LocalDateTime.now().plusMinutes(1)) && registrationTime.isAfter(LocalDateTime.now().minusMinutes(1)),
                "The registration time should be close to the current time");
    }
}

