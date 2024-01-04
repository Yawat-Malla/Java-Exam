package Models;

import java.util.Arrays;

public class Order {
    // Fields
    String name;
     String phoneNumber;
     int[] items;
    double[] prices;

    // Constructor
    public Order(String name, String phoneNumber, int[] items, double[] prices) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.items = items;
        this.prices = prices;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int[] getItems() {
        return items;
    }

    public void setItems(int[] items) {
        this.items = items;
    }

    public double[] getPrices() {
        return prices;
    }

    public void setPrices(double[] prices) {
        this.prices = prices;
    }

    // Method to print the bill with VAT and total price
//    public double calculateTotal(TShirt[] tShirts) {
//        double total = 0;
//        for (int i = 0; i < items.length; i++) {
//            int itemCode = items[i];
//            for (TShirt tShirt : tShirts) {
//                if (tShirt.getProductCode() == itemCode) {
//                    total += tShirt.getPrice();
//                    break;
//                }
//            }
//        }
//        return total;
//    }
    public double calculateTotal(TShirt[] tShirts) {
        double subtotal = 0;

        for (int i = 0; i < items.length; i++) {
            int itemCode = items[i];
            for (TShirt tShirt : tShirts) {
                if (tShirt.getProductCode() == itemCode) {
                    subtotal += tShirt.getPrice();
                    break;
                }
            }
        }

        double vat = subtotal * 0.13; // 13% VAT
        return subtotal + vat;
    }

    // Modify the printBill method
    public void printBill(TShirt[] tShirts) {
        double subtotal = 0;

        System.out.println("Order details:");
        System.out.println("   Name: " + name);
        System.out.println("   Phone number: " + phoneNumber);
        System.out.println("   Items:");

        for (int i = 0; i < items.length; i++) {
            int itemCode = items[i];
            for (TShirt tShirt : tShirts) {
                if (tShirt.getProductCode() == itemCode) {
                    System.out.println("      - " + tShirt.getName());
                    System.out.println("         Quantity: 1"); // Assuming quantity is always 1 for now
                    System.out.println("         Price per unit: " + tShirt.getPrice());
                    subtotal += tShirt.getPrice();
                    break;
                }
            }
        }

        double vat = subtotal * 0.13; // 13% VAT
        double total = subtotal + vat;

        System.out.println("   Subtotal: " + subtotal);
        System.out.println("   VAT (13%): " + vat);
        System.out.println("   Total Price (including VAT): " + total);
        System.out.println();
    }
}