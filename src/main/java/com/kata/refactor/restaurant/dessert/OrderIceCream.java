package com.kata.refactor.restaurant.dessert;

import java.util.Scanner;

public class OrderIceCream {
    private static final Scanner scanner = new Scanner(System.in);
    double roastedNuts = 0.5;
    double brownie = 1;
    double cookies = 1.5;
    double cherries = 0.75;
    private static double total=0;
    double vanilla=1.50;
    double strawberry=1.75;
    double chocolate=1.85;

    public StringBuilder order(int choice) {
        int vanillaScoops = 0, strawberryScoops = 0, chocolateScoops = 0;
        boolean roastedNutsUsed = false, brownieUsed = false, cookiesUsed = false, cherriesUsed = false;
        if(choice == 1) {
            System.out.println("Which flavour you would like to choose?");
            System.out.println("1. Vanilla: €"+vanilla);
            System.out.println("2. Strawberry: €"+strawberry);
            System.out.println("3. Chocolate: €"+chocolate);
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            System.out.println("How many scoops?");
            int scoops = scanner.nextInt();
            if(choice == 1) {
                vanillaScoops += scoops;
                total += vanilla * scoops;
            } else if(choice == 2) {
                strawberryScoops += scoops;
                total += strawberry * scoops;
            } else if(choice == 3) {
                chocolateScoops += scoops;
                total += chocolate * scoops;
            } else {
                System.out.println("Invalid choice, please try again");
                return null;
            }
        } else if(choice == 2) {
            System.out.println("1. Roasted nuts: €"+ roastedNuts);
            System.out.println("2. Cherries: €"+ cherries);
            System.out.println("3. Brownie: €"+ brownie);
            System.out.println("4. Cookies: €"+ cookies);
            choice = scanner.nextInt();
            if(choice == 1) {
                roastedNutsUsed = true;
                total += roastedNuts;
            } else if(choice == 2) {
                cherriesUsed = true;
                total += cherries;
            } else if(choice == 3) {
                brownieUsed = true;
                total += brownie;
            } else if(choice == 4) {
                cookiesUsed = true;
                total += cookies;
            } else {
                System.out.println("Invalid choice, please try again");
                return null;
            }
        } else {
            System.out.println("Invalid choice, please try again");
            return null;
        }

        System.out.println("Ice cream:");
        StringBuilder stringBuilder = new StringBuilder();
        if(vanillaScoops != 0) {
            stringBuilder.append(vanillaScoops+" scoop(s) of Vanilla, ");
        }
        if(strawberryScoops != 0) {
            stringBuilder.append(strawberryScoops+" scoop(s) of Strawberry, ");
        }
        if(chocolateScoops != 0) {
            stringBuilder.append(chocolateScoops+" scoop(s) of Chocolate, ");
        }

        if(roastedNutsUsed || brownieUsed || cookiesUsed || cherriesUsed) {
            stringBuilder.append(" with ");
            if(roastedNutsUsed) {
                stringBuilder.append(" Roasted Nuts ");
            }
            if(brownieUsed) {
                stringBuilder.append(" Brownie ");
            }
            if(cookiesUsed) {
                stringBuilder.append(" Cookies ");
            }
            if(cherriesUsed) {
                stringBuilder.append(" Cherries ");
            }
        }
        return stringBuilder;
    }

    public static void main(String[] args) {
        OrderIceCream orderIceCream = new OrderIceCream();
        total = 0;
        int choice = -1;
        StringBuilder stringBuilder = new StringBuilder();
        while(choice != 0) {
            System.out.println("Choose what you want to add: ");
            System.out.println("1. Ice cream flavour");
            System.out.println("2. Toppings");
            System.out.println("0 for exit");
            choice = scanner.nextInt();
            StringBuilder order = orderIceCream.order(choice);
            if(order != null) {
                stringBuilder.append(order.toString());
            }
        }

        stringBuilder.append(" Price: €"+ total);
        System.out.println(stringBuilder.toString());
    }
}
