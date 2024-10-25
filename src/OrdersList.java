import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class OrdersList {
    private List<Order> buyOrders;
    private List<Order> sellOrders;

    public OrdersList() {
        buyOrders = new LinkedList<>();
        sellOrders = new LinkedList<>();
    }

    public void addToList(Order order) {
        if (order.getType().equals("Add")) {
            if (order.getOrder().equals("Buy")) {
                buyOrders.add(order);
            } else if (order.getOrder().equals("Sell")) {
                sellOrders.add(order);
            }
        } else if (order.getType().equals("Remove")) {
            removeOrder(order);
        }
        displayBestPrices();  // Wyświetlanie najlepszych zleceń po każdej zmianie
    }

    private void removeOrder(Order order) {
        List<Order> orders = order.getOrder().equals("Buy") ? buyOrders : sellOrders;
        orders.removeIf(o -> o.getPrice() == order.getPrice() && o.getQuantity() == order.getQuantity());
    }

    public void displayBestPrices() {
        // Wybieranie najniższej ceny dla Buy
        Order bestBuy = buyOrders.stream()
                .min(Comparator.comparingDouble(Order::getPrice))
                .orElse(null);

        // Wybieranie najwyższej ceny dla Sell
        Order bestSell = sellOrders.stream()
                .max(Comparator.comparingDouble(Order::getPrice))
                .orElse(null);

        System.out.print("Best Buy Order: ");
        if (bestBuy != null) {
            System.out.printf("ID %d | Price: %.2f | Quantity: %d\n", bestBuy.getId(), bestBuy.getPrice(), bestBuy.getQuantity());
        } else {
            System.out.println("None");
        }

        System.out.print("Best Sell Order: ");
        if (bestSell != null) {
            System.out.printf("ID %d | Price: %.2f | Quantity: %d\n", bestSell.getId(), bestSell.getPrice(), bestSell.getQuantity());
        } else {
            System.out.println("None");
        }
    }
}