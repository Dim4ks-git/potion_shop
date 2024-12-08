package com.potionshop;

import java.util.Scanner;

public class MyMain {

    public static String buildBanner() {
        String banner;

        banner = "=".repeat(20) + "\n" +
                " ".repeat(6) + "WELCOME" + " ".repeat(7) + "\n" +
                "=".repeat(20);

        return banner;
    }

    public static void main(String[] args) {
        String menuBanner = buildBanner();
        System.out.println(menuBanner);
        System.out.println("    MENU OPTIONS    ");
        System.out.println("-".repeat(20));
        System.out.println("1. Buy Potion");
        System.out.println("2. View All Potions Available");
        System.out.println("3. Exit Program");
        System.out.println("-".repeat(20));
        System.out.println("    Enter your choice(1-3): ");
        System.out.println("=".repeat(20));
    }
}
