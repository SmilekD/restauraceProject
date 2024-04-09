import java.time.LocalDateTime;

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
}
