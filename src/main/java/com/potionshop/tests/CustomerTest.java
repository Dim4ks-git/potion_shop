package com.potionshop.tests;

import com.potionshop.models.Customer;
import com.potionshop.models.Order;
import com.potionshop.models.Potion;
import com.potionshop.models.Shop;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CustomerTest {
    @Test
    public void testCustomerInitialization() {
        Customer customer = new Customer("1", "John Doe", "john@example.com", "password123");

        assertEquals("john@example.com", customer.getEmail());
        assertEquals("password123", customer.getPassword());
        assertTrue(customer.getOrdersHistory().isEmpty());
    }

    @Test
    public void testSetAndGetEmail() {
        Customer customer = new Customer("1", "John Doe", "john@example.com", "password123");
        customer.setEmail("newemail@example.com");

        assertEquals("newemail@example.com", customer.getEmail());
    }

    @Test
    public void testSetAndGetOrdersHistory() {
        Customer customer = new Customer("1", "John Doe", "john@example.com", "password123");
        Order order1 = new Order("O1", "Order1", "2024-12-15T10:00:00", customer, null);
        Order order2 = new Order("O2", "Order2", "2024-12-16T10:00:00", customer, null);

        List<Order> orders = new ArrayList<>();
        orders.add(order1);
        orders.add(order2);

        customer.setOrdersHistory(orders);

        assertEquals(2, customer.getOrdersHistory().size());
        assertEquals(order1, customer.getOrdersHistory().get(0));
        assertEquals(order2, customer.getOrdersHistory().get(1));
    }

    @Test
    public void testSetEmailToNull() {
        Customer customer = new Customer("1", "John Doe", "john@example.com", "password123");
        customer.setEmail(null);

        assertNull(customer.getEmail());
    }

    @Test
    public void testSetAndGetPassword() {
        Customer customer = new Customer("1", "John Doe", "john@example.com", "password123");
        customer.setPassword("123");

        assertEquals("123", customer.getPassword());
    }

    @Test
    public void testBuyPotion() {
        Potion potion1 = new Potion("P1", "Healing Potion", "Restores health", 50.0, 10, "Health");
        Potion potion2 = new Potion("P2", "Mana Potion", "Restores mana", 30.0, 5, "Mana");

        Shop shop = new Shop("S1", "Potion Shop", "123 Magic Street", new Potion[]{potion1, potion2});
        Customer customer = new Customer("1", "John Doe", "john@example.com", "password123");

        // Buy a potion
        customer.buyPotion(potion1, shop);

        // Verify potion stock decreased
        assertEquals(9, potion1.getStoreQuantity());

        // Verify order is added to history
        List<Order> ordersHistory = customer.getOrdersHistory();
        assertEquals(1, ordersHistory.size());

        Order order = ordersHistory.getFirst();
        assertEquals(potion1, order.getPotion());
        assertEquals(customer, order.getCustomer());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBuyPotionOutOfStock() {
        Potion potion = new Potion("P1", "Healing Potion", "Restores health", 50.0, 0, "Health");
        Shop shop = new Shop("S1", "Potion Shop", "123 Magic Street", new Potion[]{potion});
        Customer customer = new Customer("1", "John Doe", "john@example.com", "password123");

        customer.buyPotion(potion, shop);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBuyPotionNotInShop() {
        Potion potion = new Potion("P1", "Healing Potion", "Restores health", 50.0, 10, "Health");
        Shop shop = new Shop("S1", "Potion Shop", "123 Magic Street", new Potion[]{});
        Customer customer = new Customer("1", "John Doe", "john@example.com", "password123");

        customer.buyPotion(potion, shop);
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
