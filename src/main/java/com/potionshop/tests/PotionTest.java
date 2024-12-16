package com.potionshop.tests;

import com.potionshop.models.Potion;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class PotionTest {

    @Test
    public void testDefaultConstructor() {
        // Create a Potion using the default constructor
        Potion potion = new Potion();

        // Verify default values
        assertEquals("default", potion.getDescription());
        assertEquals(0.0, potion.getPrice(), 0.001);
        assertEquals(0, potion.getStoreQuantity());
        assertEquals("default", potion.getType());
    }

    @Test
    public void testCopyConstructor() {
        // Create an original Potion
        Potion original = new Potion("P123", "Mana Potion", "Restores mana", 25.5, 100, "Magic");

        // Use the copy constructor
        Potion copy = new Potion(original);

        // Verify the copied values
        assertEquals(original.getId(), copy.getId());
        assertEquals(original.getName(), copy.getName());
        assertEquals(original.getDescription(), copy.getDescription());
        assertEquals(original.getPrice(), copy.getPrice(), 0.001);
        assertEquals(original.getStoreQuantity(), copy.getStoreQuantity());
        assertEquals(original.getType(), copy.getType());
    }

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

    @Test(expected = IllegalArgumentException.class)
    public void testPotionInitializationWithNegativePrice() {
        new Potion("P123", "Mana Potion", "Restores mana", -10.0, 100, "Magic");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPotionInitializationWithNegativeStoreQuantity() {
        new Potion("P123", "Mana Potion", "Restores mana", 25.5, -1, "Magic");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPotionInitializationWithZeroPrice() {
        new Potion("P123", "Mana Potion", "Restores mana", 0, 100, "Magic");
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


    @Test
    public void increaseQuantity_ShouldIncreaseStoreQuantity() {
        Potion potion = new Potion();
        int initialQuantity = potion.getStoreQuantity();
        int increaseAmount = 10;

        int newQuantity = potion.increaseQuantity(increaseAmount);

        assertEquals(initialQuantity + increaseAmount, newQuantity);
    }

    @Test(expected = IllegalArgumentException.class)
    public void increaseQuantity_ShouldThrowExceptionForNegativeAmount() {
        Potion potion = new Potion();
        potion.increaseQuantity(-1);
    }


    @Test(expected = ArithmeticException.class)
    public void increaseQuantity_ShouldThrowExceptionForOverflow() {
        Potion potion = new Potion();
        potion.increaseQuantity(Integer.MAX_VALUE - 10); // Set close to max
        potion.increaseQuantity(11); // Exceeds Integer.MAX_VALUE
    }

    @Test(expected = ArithmeticException.class)
    public void increaseQuantity_ShouldHandleBoundaryValues() {
        Potion potion = new Potion();

        // Setting to a value just below the maximum
        potion.setStoreQuantity(Integer.MAX_VALUE - 1);

        // Should succeed
        int result = potion.increaseQuantity(1);

        assertEquals(Integer.MAX_VALUE, result);

        potion.increaseQuantity(1);

    }

    @Test
    public void increaseQuantity_ShouldWorkForZeroAmount() {
        Potion potion = new Potion();
        int initialQuantity = potion.getStoreQuantity();

        int newQuantity = potion.increaseQuantity(0);

        assertEquals(initialQuantity, newQuantity);
    }

    @Test
    public void decreaseQuantity_ShouldDecreaseStoreQuantity() {
        Potion potion = new Potion();
        potion.setStoreQuantity(50); // Initialize storeQuantity to 50

        int newQuantity = potion.decreaseQuantity(10);

        assertEquals(40, newQuantity);
    }

    @Test(expected = IllegalArgumentException.class)
    public void decreaseQuantity_ShouldThrowExceptionForNegativeAmount() {
        Potion potion = new Potion();
        potion.setStoreQuantity(20); // Initialize storeQuantity to 20
        potion.decreaseQuantity(-1); // Should throw IllegalArgumentException
    }

    @Test(expected = ArithmeticException.class)
    public void decreaseQuantity_ShouldThrowExceptionForResultingNegativeQuantity() {
        Potion potion = new Potion();
        potion.setStoreQuantity(10); // Initialize storeQuantity to 10
        potion.decreaseQuantity(20); // Should throw ArithmeticException
    }

    @Test
    public void decreaseQuantity_ShouldWorkForExactQuantity() {
        Potion potion = new Potion();
        potion.setStoreQuantity(25); // Initialize storeQuantity to 25

        int newQuantity = potion.decreaseQuantity(25);

        assertEquals(0, newQuantity); // storeQuantity should be exactly 0
    }

    @Test
    public void decreaseQuantity_ShouldWorkForZeroAmount() {
        Potion potion = new Potion();
        potion.setStoreQuantity(15); // Initialize storeQuantity to 15

        int newQuantity = potion.decreaseQuantity(0);

        assertEquals(15, newQuantity); // storeQuantity should remain unchanged
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
