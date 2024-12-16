package com.potionshop.tests;

import com.potionshop.models.Customer;
import com.potionshop.models.Order;
import com.potionshop.models.Potion;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class OrderTest {

    @Test
    public void testDefaultConstructor() {
        // Create an Order using the default constructor
        Order order = new Order();

        // Verify default values
        assertEquals("0000-00-00T00:00:00Z", order.getTimestamp());
        assertNull(order.getCustomer());
        assertNull(order.getPotion());
    }

    @Test
    public void testCopyConstructor() {
        // Create original objects
        Customer customer = new Customer("C123", "John Doe", "john@example.com", "password123");
        Potion potion = new Potion("P123", "Healing Potion", "Restores health", 25.0, 10, "Health");
        Order original = new Order("O123", "Order 1", "2024-12-09T10:00:00Z", customer, potion);

        // Use the copy constructor
        Order copy = new Order(original);

        // Verify the copied values
        assertEquals(original.getId(), copy.getId());
        assertEquals(original.getName(), copy.getName());
        assertEquals(original.getTimestamp(), copy.getTimestamp());
        assertEquals(original.getCustomer(), copy.getCustomer());
        assertEquals(original.getPotion(), copy.getPotion());
    }


    @Test
    public void testOrderInitializationWithParameters() {
        Customer customer = new Customer("C123", "John Doe", "john@example.com", "password123");
        Potion potion = new Potion("P123", "Mana Potion", "Restores mana", 25.5, 100, "Magic");
        Order order = new Order("O123", "Order 1", "2024-12-09T10:00:00Z", customer, potion);

        assertEquals("O123", order.getId());
        assertEquals("Order 1", order.getName());
        assertEquals("2024-12-09T10:00:00Z", order.getTimestamp());
        assertEquals(customer, order.getCustomer());
        assertEquals(potion, order.getPotion());
    }

    @Test
    public void testOrderDefaultInitialization() {
        Order order = new Order();

        assertEquals("default", order.getId());
        assertEquals("default", order.getName());
        assertEquals("0000-00-00T00:00:00Z", order.getTimestamp());
        assertNull(order.getCustomer());
        assertNull(order.getPotion());
    }

    @Test
    public void testSetAndGetTimestamp() {
        Order order = new Order();
        order.setTimestamp("2024-12-10T14:00:00Z");

        assertEquals("2024-12-10T14:00:00Z", order.getTimestamp());
    }

    @Test
    public void testSetAndGetCustomer() {
        Customer customer = new Customer("C124", "Jane Doe", "jane@example.com", "password456");
        Order order = new Order();
        order.setCustomer(customer);

        assertEquals(customer, order.getCustomer());
    }

    @Test
    public void testSetAndGetPotion() {
        Potion potion = new Potion("P124", "Healing Potion", "Restores health", 15.0, 50, "Magic");
        Order order = new Order();
        order.setPotion(potion);

        assertEquals(potion, order.getPotion());
    }

    @Test
    public void testSetTimestampToNull() {
        Order order = new Order();
        order.setTimestamp(null);

        assertNull(order.getTimestamp());
    }

    @Test
    public void testSetCustomerToNull() {
        Order order = new Order();
        order.setCustomer(null);

        assertNull(order.getCustomer());
    }

    @Test
    public void testSetPotionToNull() {
        Order order = new Order();
        order.setPotion(null);

        assertNull(order.getPotion());
    }

    public void runAll() {
        System.out.println("-".repeat(55));
        System.out.println(" T E S T S");
        System.out.println("-".repeat(55));

        // Run tests
        Result result = JUnitCore.runClasses(OrderTest.class);

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
