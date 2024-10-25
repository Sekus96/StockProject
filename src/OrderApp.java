import java.util.Scanner;

public class OrderApp {
    private OrdersList ordersList;
    private Scanner scanner;

    public OrderApp() {
        ordersList = new OrdersList();
        scanner = new Scanner(System.in);
    }

    public void start() {
        int option;

        do {
            displayMenu();
            option = scanner.nextInt();

            switch (option) {
                case 1 -> processOrder("Buy");
                case 2 -> processOrder("Sell");
                case 3 -> System.out.println("See you soon!");
                default -> System.out.println("Invalid option, please try again.");
            }
        } while (option != 3);

        scanner.close(); // Zamknięcie skanera po zakończeniu
    }

    private void displayMenu() {
        System.out.println("""
                Menu:
                1 - Buy shares
                2 - Sell shares
                3 - End
                """);
    }

    private void processOrder(String orderType) {
        System.out.println("Provide type of order (Add/Remove): ");
        String type = scanner.next();

        if (!type.equals("Add") && !type.equals("Remove")) {
            System.out.println("Invalid order type. Please enter 'Add' or 'Remove'.");
            return;
        }

        System.out.println("Provide price: ");
        double price = scanner.nextDouble();

        if (price <= 0) {
            System.out.println("Price must be greater than 0.");
            return;
        }

        System.out.println("Provide quantity: ");
        int quantity = scanner.nextInt();

        if (quantity <= 0) {
            System.out.println("Quantity must be greater than 0.");
            return;
        }

        Order order = new Order(orderType, type, price, quantity);
        ordersList.addToList(order);

        // Wywołaj displayBestPrices bezpośrednio z klasy OrdersList (dodano w addToList)
    }
}