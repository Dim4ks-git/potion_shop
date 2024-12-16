
package com.potionshop.tests;

import com.potionshop.models.*;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import static org.junit.Assert.*;

import java.util.List;

/**
 * Integration tests for the Potion Shop system.
 */
public class IntegrationTests {

    @Test
    public void testCustomerBuysPotionFromShop() {
        System.out.println("Running testCustomerBuysPotionFromShop...");
        // Arrange
        Potion potion1 = new Potion("P001", "Healing Potion", "Restores health", 10.0, 5, "Health");
        Potion potion2 = new Potion("P002", "Mana Potion", "Restores mana", 15.0, 3, "Mana");

        Potion[] stock = {potion1, potion2};
        Shop shop = new Shop("S001", "Main Shop", "123 Magic Street", stock);

        Customer customer = new Customer("C001", "Alice", "alice@example.com", "password123");

        // Act
        customer.buyPotion(potion1, shop);

        // Assert
        assertEquals(4, potion1.getStoreQuantity());
        assertEquals(1, customer.getOrdersHistory().size());
        Order order = customer.getOrdersHistory().getFirst();
        assertEquals(potion1, order.getPotion());
        System.out.println("testCustomerBuysPotionFromShop passed.");
    }

    @Test
    public void testShopFindsPotion() {
        System.out.println("Running testShopFindsPotion...");
        // Arrange
        Potion potion1 = new Potion("P001", "Healing Potion", "Restores health", 10.0, 5, "Health");
        Potion potion2 = new Potion("P002", "Mana Potion", "Restores mana", 15.0, 3, "Mana");

        Shop shop = new Shop("S001", "Main Shop", "123 Magic Street", new Potion[]{potion1, potion2});

        // Act
        Potion foundPotion = shop.findPotion("P001");
        Potion notFoundPotion = shop.findPotion("P999");

        // Assert
        assertEquals(potion1, foundPotion);
        assertNull(notFoundPotion);
        System.out.println("testShopFindsPotion passed.");
    }

    @Test
    public void testCustomerOrderHistory() {
        System.out.println("Running testCustomerOrderHistory...");
        // Arrange
        Potion potion1 = new Potion("P001", "Healing Potion", "Restores health", 10.0, 5, "Health");
        Potion potion2 = new Potion("P002", "Mana Potion", "Restores mana", 15.0, 3, "Mana");

        Shop shop = new Shop("S001", "Main Shop", "123 Magic Street", new Potion[]{potion1, potion2});

        Customer customer = new Customer("C001", "Bob", "bob@example.com", "password123");

        // Act
        customer.buyPotion(potion1, shop);
        customer.buyPotion(potion2, shop);

        // Assert
        List<Order> orderHistory = customer.getOrdersHistory();
        assertEquals(2, orderHistory.size());
        assertEquals(potion1, orderHistory.get(0).getPotion());
        assertEquals(potion2, orderHistory.get(1).getPotion());
        System.out.println("testCustomerOrderHistory passed.");
    }

    @Test(expected = ArithmeticException.class)
    public void testPotionStockManagementInvalidDecrease() {
        System.out.println("Running testPotionStockManagementInvalidDecrease...");
        // Arrange
        Potion potion = new Potion("P001", "Healing Potion", "Restores health", 10.0, 5, "Health");

        // Act & Assert
        potion.decreaseQuantity(20);
    }

    public void runAll() {
        System.out.println("-".repeat(55));
        System.out.println(" T E S T S");
        System.out.println("-".repeat(55));

        // Run tests
        Result result = JUnitCore.runClasses(IntegrationTests.class);

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

