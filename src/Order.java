import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private int tableNumber;
    private Dish dish;
    private int numberOfUnits;
    private LocalDateTime orderedTime, fulfilmentTime;
    private boolean isDelivered;
    private boolean isPaid;

    public Order(int tableNumber, Dish dish, int numberOfUnits, LocalDateTime orderedTime,
                  LocalDateTime fulfilmentTime, boolean isDelivered, boolean isPaid) {
        this.tableNumber = tableNumber;
        this.dish = dish;
        this.numberOfUnits = numberOfUnits;
        this.orderedTime = orderedTime;
        this.fulfilmentTime = fulfilmentTime;
        this.isDelivered = isDelivered;
        this.isPaid = isPaid;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public int getNumberOfUnits() {
        return numberOfUnits;
    }

    public void setNumberOfUnits(int numberOfUnits) {
        this.numberOfUnits = numberOfUnits;
    }

    public LocalDateTime getOrderedTime() {
        return orderedTime;
    }

    public void setOrderedTime(LocalDateTime orderedTime) {
        this.orderedTime = orderedTime;
    }

    public LocalDateTime getFulfilmentTime() {
        return fulfilmentTime;
    }

    public void setFulfilmentTime(LocalDateTime fulfilmentTime) {
        this.fulfilmentTime = fulfilmentTime;
    }

    public boolean isDelivered() {
        return isDelivered;
    }

    public void setDelivered(boolean delivered) {
        isDelivered = delivered;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }
    public static void exportOrdersToFile(String fileName, List<List<Order>> ordersLists) {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(fileName)))) {
            for (List<Order> orders : ordersLists) {
                for (Order order : orders) {
                    writer.println(order.getTableNumber() + "\t" + order.getDish().getTitle() + "\t" +
                            order.getNumberOfUnits() + "\t" + order.getOrderedTime() + "\t" +
                            order.getFulfilmentTime() + "\t" + order.isDelivered() + "\t" + order.isPaid());
                }
            }
            System.out.println("Data objednávek byla úspěšně uložena do souboru: " + fileName);
        } catch (IOException e) {
            System.err.println("Chyba při ukládání dat objednávek do souboru: " + e.getMessage());
        }
    }

    public static void loadOrdersFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\t");

                int tableNumber = Integer.parseInt(parts[0]);
                String dishTitle = parts[1];
                int quantity = Integer.parseInt(parts[2]);
                LocalDateTime orderedTime = LocalDateTime.parse(parts[3]);
                LocalDateTime deliveredTime = null;
                if (!parts[4].equals("null")) {
                    deliveredTime = LocalDateTime.parse(parts[4]);
                }
                boolean isDelivered = Boolean.parseBoolean(parts[5]);
                boolean isPaid = Boolean.parseBoolean(parts[6]);

                Dish dish = new Dish(dishTitle, null, 1, 1);
                Order order = new Order(tableNumber, dish, quantity, orderedTime, deliveredTime, isDelivered, isPaid);

                System.out.println(order.getTableNumber()+"\t"+order.getDish().getTitle()+"\t"+order.getNumberOfUnits()+"\t"+order.getOrderedTime()+
                        "\t"+order.getFulfilmentTime()+"\t"+order.isDelivered+"\t"+order.isPaid);
            }

        } catch (IOException | IllegalArgumentException e) {
            System.err.println("Chyba při načítání dat objednávek ze souboru: " + e.getMessage());
        }
    }


}
