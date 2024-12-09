package com.potionshop.tests;

import com.potionshop.models.Entity;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class EntityTest {

    @Test
    public void testEntityInitializationWithParameters() {
        Entity entity = new Entity("123", "Potion");

        assertEquals("123", entity.getId());
        assertEquals("Potion", entity.getName());
    }

    @Test
    public void testEntityDefaultInitialization() {
        Entity entity = new Entity();

        assertEquals("default", entity.getId());
        assertEquals("default", entity.getName());
    }

    @Test
    public void testSetAndGetId() {
        Entity entity = new Entity();
        entity.setId("456");

        assertEquals("456", entity.getId());
    }

    @Test
    public void testSetAndGetName() {
        Entity entity = new Entity();
        entity.setName("Elixir");

        assertEquals("Elixir", entity.getName());
    }

    @Test
    public void testSetIdToNull() {
        Entity entity = new Entity();
        entity.setId(null);

        assertNull(entity.getId());
    }

    @Test
    public void testSetNameToNull() {
        Entity entity = new Entity();
        entity.setName(null);

        assertNull(entity.getName());
    }

    public void runAll() {
        System.out.println("-".repeat(55));
        System.out.println(" T E S T S");
        System.out.println("-".repeat(55));

        // Run tests
        Result result = JUnitCore.runClasses(EntityTest.class);

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
