import java.util.Scanner;
import Models.Order;
import Models.TShirt;

public class Main {
    public static void main(String[] args) {
        // Creating T-shirt objects
        TShirt tShirt1 = new TShirt("Gorkhali Batman", 572, 1235, "Karuna", "You either die a hero or live long enough to see yourself be a villain", new String[]{"XL", "Medium", "Large"});

        TShirt tShirt2 = new TShirt("Nepal Flag", 681, 1500, "Himalayan Designs", "Beautiful representation of the Nepali flag", new String[]{"Small", "Medium", "Large"});

        TShirt tShirt3 = new TShirt("Everest Explorer", 789, 1800, "Mountain Gear", "Conquer the heights with this Everest-themed design", new String[]{"Large", "XL"});

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the maximum number of orders you want to place:");
        int maxOrders = scanner.nextInt();

        Order[] orders = new Order[maxOrders];
        int ordersCount = 0;

        while (ordersCount < maxOrders) {
            // Display available T-shirts
            System.out.println("Available T-shirts:");
            tShirt1.displayTShirt();
            tShirt2.displayTShirt();
            tShirt3.displayTShirt();

            // Select T-shirt for ordering
            System.out.println("Enter the product code of the T-shirt you want to order (or -1 to finish ordering):");
            int selectedProductCode = scanner.nextInt();

            // Check if the user wants to finish ordering
            if (selectedProductCode == -1) {
                break;
            }

            TShirt selectedTShirt = null;

            // Check which T-shirt matches the selected product code
            if (selectedProductCode == tShirt1.getProductCode()) {
                selectedTShirt = tShirt1;
            } else if (selectedProductCode == tShirt2.getProductCode()) {
                selectedTShirt = tShirt2;
            } else if (selectedProductCode == tShirt3.getProductCode()) {
                selectedTShirt = tShirt3;
            }

            // Process the selected T-shirt
            if (selectedTShirt != null) {
                System.out.println("Enter your name:");
                String userName = scanner.next();

                System.out.println("Enter your phone number:");
                String userPhoneNumber = scanner.next();

                // Create Order object and add it to the array
                orders[ordersCount] = new Order(userName, userPhoneNumber,
                        new int[]{selectedTShirt.getProductCode()}, new double[]{selectedTShirt.getPrice()});

                System.out.println("Order placed successfully!");
                ordersCount++;
            } else {
                // Handle the case when the selected product code doesn't match any T-shirt
                System.out.println("Invalid product code. Please select a valid T-shirt.");
            }
        }

        System.out.println("\nOrder Details:");
        for (int i = 0; i < ordersCount; i++) {
            Order order = orders[i];
            order.printBill(new TShirt[]{tShirt1, tShirt2, tShirt3});
            System.out.println("-------------");
        }

    // Calculate and print the grand total
        double grandTotal = 0;
        System.out.println("Grand Total:");
        for (int i = 0; i < ordersCount; i++) {
            Order order = orders[i];
            double orderTotal = order.calculateTotal(new TShirt[]{tShirt1, tShirt2, tShirt3});
            System.out.println("Order " + (i + 1) + " Total: " + orderTotal);
            grandTotal += orderTotal;
        }
        System.out.println("Overall Grand Total: " + grandTotal);
    }
}
