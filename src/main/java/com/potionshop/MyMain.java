package com.potionshop;

import com.potionshop.models.Entity;
import com.potionshop.tests.*;

import java.util.Scanner;

//--------------------------------------------------
//
// CLASS MyMain
//
//--------------------------------------------------

public class MyMain {

    public static <T extends Entity> void displayClass(T entityInstance) {
        System.out.println(entityInstance.toString());
    }

    public static void testCustomer() {
        CustomerTest customerTest = new CustomerTest();
        customerTest.runAll();
    }

    public static void testOrder() {
        OrderTest orderTest = new OrderTest();
        orderTest.runAll();
    }

    public static void testShop() {
        ShopTest shopTest = new ShopTest();
        shopTest.runAll();
    }

    public static void testPotion() {
        PotionTest potionTest = new PotionTest();
        potionTest.runAll();
    }

    public static void testEntity() {
        EntityTest entityTest = new EntityTest();
        entityTest.runAll();
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=".repeat(40));
        System.out.println(" ".repeat(10) + "FUNCTIONALITY TESTS" + " ".repeat(11));
        System.out.println("=".repeat(40));

        System.out.println("TEST OPTIONS");

        System.out.println("-".repeat(40));
        System.out.println("1. Test Customer.java");
        System.out.println("2. Test Entity.java");
        System.out.println("3. Test Order.java");
        System.out.println("4. Test Potion.java");
        System.out.println("5. Test Shop.java");
        System.out.println("6. Display all classes");
        System.out.println("7. Exit");
        System.out.println("-".repeat(40));

        System.out.println("    Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                testCustomer();
                break;
            case 2:
                testEntity();
                break;
            case 3:
                testOrder();
                break;
            case 4:
                testPotion();
                break;
            case 5:
                testShop();
                break;
            case 6:

                break;
            case 7:
                System.out.println("Exit");
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }

        scanner.close();

    }
}
