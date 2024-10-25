import java.util.*;

class Order {
    private int id;
    private String order;
    private String type;  // "Add" or "Remove"
    private double price;
    private int quantity;
    private static int counter = 1;

    public Order(String order, String type, double price, int quantity) {
        this.id = counter++;
        this.order = order;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() { return id; }
    public String getOrder() { return order; }
    public String getType() { return type; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
}