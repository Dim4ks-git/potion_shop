package com.potionshop.tests;

import com.potionshop.models.Customer;
import com.potionshop.models.Order;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class CustomerTest {
    @Test
    public void testCustomerInitialization() {
        Order[] orders = {new Order(), new Order()};
        Customer customer = new Customer("1", "John Doe", "john@example.com", "password123", orders);

        assertEquals("john@example.com", customer.getEmail());
        assertEquals("password123", customer.getPassword());
        assertArrayEquals(orders, customer.getOrdersHistory());
    }

    @Test
    public void testSetAndGetEmail() {
        Customer customer = new Customer("1", "John Doe", "john@example.com", "password123", null);
        customer.setEmail("newemail@example.com");

        assertEquals("newemail@example.com", customer.getEmail());
    }

    @Test
    public void testSetAndGetOrdersHistory() {
        Customer customer = new Customer("1", "John Doe", "john@example.com", "password123", null);
        Order[] newOrders = {new Order()};
        customer.setOrdersHistory(newOrders);

        assertArrayEquals(newOrders, customer.getOrdersHistory());
    }

    @Test
    public void testSetEmailToNull() {
        Customer customer = new Customer("1", "John Doe", "john@example.com", "password123", null);
        customer.setEmail(null);

        assertNull(customer.getEmail());
    }

    @Test
    public void testSetAndGetPassword() {
        Customer customer = new Customer("1", "John Doe", "john@example.com", "password123", null);
        customer.setPassword("123");

        assertEquals("123", customer.getPassword());
    }

    public void runAll() {
        System.out.println("-".repeat(55));
        System.out.println(" T E S T S");
        System.out.println("-".repeat(55));

        // Run tests
        Result result = JUnitCore.runClasses(CustomerTest.class);

        // Display results
        if (result.wasSuccessful()) {
            System.out.println("Results:");
            System.out.println("Tests run: " + result.getRunCount() + ", Failures: " + result.getFailureCount() + ", Errors: 0, Skipped: 0");
            System.out.println();
            System.out.println("BUILD SUCCESS");
        } else {
            System.out.println("Results:");
            System.out.println("Tests run: " + result.getRunCount() + ", Failures: " + result.getFailureCount() + ", Errors: 0, Skipped: 0");
            System.out.println();
            for (Failure failure : result.getFailures()) {
                System.out.println("-".repeat(55));
                System.out.println("Test failed: " + failure.getTestHeader());
                System.out.println("Reason: " + failure.getMessage());
                System.out.println("Trace:");
                System.out.println(failure.getTrace());
                System.out.println("-".repeat(55));
            }
            System.out.println("BUILD FAILURE");
        }

        System.out.println("-".repeat(55));
    }
}
