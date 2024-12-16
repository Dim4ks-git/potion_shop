package com.potionshop.tests;

import com.potionshop.models.Potion;
import com.potionshop.models.Shop;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class ShopTest {

    @Test
    public void testDefaultConstructor() {
        // Create a Shop using the default constructor
        Shop shop = new Shop();

        // Verify default values
        assertEquals("default address", shop.getAddress());
        assertNotNull(shop.getStock());
        assertEquals(0, shop.getStock().length);
    }

    @Test
    public void testCopyConstructor() {
        // Create original objects
        Potion[] stock = {
                new Potion("P123", "Mana Potion", "Restores mana", 25.5, 100, "Magic"),
                new Potion("P124", "Healing Potion", "Restores health", 15.0, 50, "Magic")
        };
        Shop original = new Shop("S123", "Potion Shop", "123 Wizard Lane", stock);

        // Use the copy constructor
        Shop copy = new Shop(original);

        // Verify the copied values
        assertEquals(original.getId(), copy.getId());
        assertEquals(original.getName(), copy.getName());
        assertEquals(original.getAddress(), copy.getAddress());
        assertArrayEquals(original.getStock(), copy.getStock());

        // Ensure the stock array is a new instance
        assertNotSame(original.getStock(), copy.getStock());
    }

    @Test
    public void testShopInitializationWithParameters() {
        Potion[] stock = {
                new Potion("P123", "Mana Potion", "Restores mana", 25.5, 100, "Magic"),
                new Potion("P124", "Healing Potion", "Restores health", 15.0, 50, "Magic")
        };

        Shop shop = new Shop("S123", "Potion Shop", "123 Wizard Lane", stock);

        assertEquals("S123", shop.getId());
        assertEquals("Potion Shop", shop.getName());
        assertEquals("123 Wizard Lane", shop.getAddress());
        assertArrayEquals(stock, shop.getStock());
    }

    @Test
    public void testSetAndGetAddress() {
        Shop shop = new Shop("S124", "Alchemy Shop", "321 Alchemy Avenue", null);
        shop.setAddress("456 Sorcerer Street");

        assertEquals("456 Sorcerer Street", shop.getAddress());
    }

    @Test
    public void testSetAndGetStock() {
        Potion[] stock = {
                new Potion("P125", "Stamina Potion", "Boosts stamina", 20.0, 70, "Physical")
        };

        Shop shop = new Shop("S125", "Herbalist's Shop", "789 Nature's Path", null);
        shop.setStock(stock);

        assertArrayEquals(stock, shop.getStock());
    }

    @Test
    public void testSetAddressToNull() {
        Shop shop = new Shop("S126", "Magic Shop", "101 Spellcaster Circle", null);
        shop.setAddress(null);

        assertNull(shop.getAddress());
    }

    @Test
    public void testSetStockToNull() {
        Shop shop = new Shop("S127", "Potion Emporium", "555 Enchanter Boulevard", null);
        shop.setStock(null);

        assertNull(shop.getStock());
    }

    @Test
    public void testEmptyStock() {
        Shop shop = new Shop("S128", "Small Potion Shop", "999 Empty Shelf Road", new Potion[0]);

        assertNotNull(shop.getStock());
        assertEquals(0, shop.getStock().length);
    }

    @Test
    public void testFindPotionById_Found() {
        // Setup
        Potion potion1 = new Potion("P001", "Health Potion", "Restores health", 10.0, 50, "Healing");
        Potion potion2 = new Potion("P002", "Mana Potion", "Restores mana", 15.0, 30, "Magic");
        Shop shop = new Shop("S001", "Potion Shop", "123 Magic St", new Potion[]{potion1, potion2});

        // Execute
        Potion result = shop.findPotion("P001");

        // Verify
        assertNotNull(result);
        assertEquals("P001", result.getId());
        assertEquals("Health Potion", result.getName());
    }

    @Test
    public void testFindPotionById_NotFound() {
        // Setup
        Potion potion1 = new Potion("P001", "Health Potion", "Restores health", 10.0, 50, "Healing");
        Shop shop = new Shop("S001", "Potion Shop", "123 Magic St", new Potion[]{potion1});

        // Execute
        Potion result = shop.findPotion("P999");

        // Verify
        assertNull(result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindPotionById_NullId() {
        // Setup
        Shop shop = new Shop("S001", "Potion Shop", "123 Magic St", new Potion[0]);

        // Execute
        shop.findPotion(null);
    }

    @Test
    public void testFindPotionByIdAndQuantity_Found() {
        // Setup
        Potion potion1 = new Potion("P001", "Health Potion", "Restores health", 10.0, 50, "Healing");
        Potion potion2 = new Potion("P002", "Mana Potion", "Restores mana", 15.0, 30, "Magic");
        Shop shop = new Shop("S001", "Potion Shop", "123 Magic St", new Potion[]{potion1, potion2});

        // Execute
        Potion result = shop.findPotion("P002", 30);

        // Verify
        assertNotNull(result);
        assertEquals("P002", result.getId());
        assertEquals(30, result.getStoreQuantity());
    }

    @Test
    public void testFindPotionByIdAndQuantity_NotFound() {
        // Setup
        Potion potion1 = new Potion("P001", "Health Potion", "Restores health", 10.0, 50, "Healing");
        Shop shop = new Shop("S001", "Potion Shop", "123 Magic St", new Potion[]{potion1});

        // Execute
        Potion result = shop.findPotion("P001", 10);

        // Verify
        assertNull(result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindPotionByIdAndQuantity_NullId() {
        // Setup
        Shop shop = new Shop("S001", "Potion Shop", "123 Magic St", new Potion[0]);

        // Execute
        shop.findPotion(null, 10);
    }

    @Test
    public void testFindPotionByIdAndQuantity_EmptyStock() {
        // Setup
        Shop shop = new Shop("S001", "Potion Shop", "123 Magic St", new Potion[0]);

        // Execute
        Potion result = shop.findPotion("P001", 10);

        // Verify
        assertNull(result);
    }

    public void runAll() {
        System.out.println("-".repeat(55));
        System.out.println(" T E S T S");
        System.out.println("-".repeat(55));

        // Run tests
        Result result = JUnitCore.runClasses(ShopTest.class);

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
