package com.potionshop.tests;

import com.potionshop.models.Potion;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class PotionTest {

    @Test
    public void testPotionInitializationWithParameters() {
        Potion potion = new Potion("P123", "Mana Potion", "Restores mana", 25.5, 100, "Magic");

        assertEquals("P123", potion.getId());
        assertEquals("Mana Potion", potion.getName());
        assertEquals("Restores mana", potion.getDescription());
        assertEquals(25.5, potion.getPrice(), 0.001);
        assertEquals(100, potion.getStoreQuantity());
        assertEquals("Magic", potion.getType());
    }

    @Test
    public void testPotionDefaultInitialization() {
        Potion potion = new Potion();

        assertEquals("default", potion.getId());
        assertEquals("default", potion.getName());
        assertNull(potion.getDescription());
        assertEquals(0.0, potion.getPrice(), 0.001);
        assertEquals(0, potion.getStoreQuantity());
        assertNull(potion.getType());
    }

    @Test
    public void testSetAndGetDescription() {
        Potion potion = new Potion();
        potion.setDescription("Increases stamina");

        assertEquals("Increases stamina", potion.getDescription());
    }

    @Test
    public void testSetAndGetPrice() {
        Potion potion = new Potion();
        potion.setPrice(50.0);

        assertEquals(50.0, potion.getPrice(), 0.001);
    }

    @Test
    public void testSetAndGetStoreQuantity() {
        Potion potion = new Potion();
        potion.setStoreQuantity(200);

        assertEquals(200, potion.getStoreQuantity());
    }

    @Test
    public void testSetAndGetType() {
        Potion potion = new Potion();
        potion.setType("Physical");

        assertEquals("Physical", potion.getType());
    }

    @Test
    public void testSetDescriptionToNull() {
        Potion potion = new Potion();
        potion.setDescription(null);

        assertNull(potion.getDescription());
    }

    @Test
    public void testSetTypeToNull() {
        Potion potion = new Potion();
        potion.setType(null);

        assertNull(potion.getType());
    }

    public void runAll() {
        System.out.println("-".repeat(55));
        System.out.println(" T E S T S");
        System.out.println("-".repeat(55));

        // Run tests
        Result result = JUnitCore.runClasses(PotionTest.class);

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
