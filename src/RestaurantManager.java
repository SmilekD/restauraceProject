import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RestaurantManager {

    public void notDelivered(List<Order> orderList){
        for (Order order : orderList){
            if (!order.isDelivered()){
                System.out.println("Rozpracovaná objednávka: "+"číslo stolu: "+order.getTableNumber()+ " "+order.getDish().getTitle()+" "+order.getNumberOfUnits()+"ks"+" "
                        +order.isDelivered()+" "+ order.isPaid());
            } else System.out.println("Nejsou žádné rozpracované objednávky");
        }
    }
    public void sortedByTime(List<Order> orderList){
        orderList.sort(Comparator.comparing(Order::getOrderedTime));
        System.out.println("Seřazeno dle času objednání: \n");
        for (Order order : orderList){
            System.out.println("Číslo stolu: "+order.getTableNumber()+" "+order.getDish().getTitle()+" "+order.getNumberOfUnits()+"ks.");
        }
    }
    public void averageTime(List<Order> orderList){
        long size, time = 0, minutesBetween, averageTime;
        List<Order> finishedList = new ArrayList<>();
        for (Order order : orderList){
            if (order.isPaid()){
                minutesBetween = ChronoUnit.MINUTES.between(order.getOrderedTime(), order.getFulfilmentTime());
                time += minutesBetween;
                finishedList.add(order);
            }
        }
        size = finishedList.size();
        averageTime = time / size;
        System.out.println("Průměrná doba zpracování objednávky je: "+averageTime+ " minut.");
    }
    public void getDishesOrderedToday(List<Order> orderList){
        LocalDateTime today = LocalDateTime.now();
        List<Dish> dishesOrderedToday = new ArrayList<>();
        for (Order order : orderList){
            if (order.getOrderedTime().toLocalDate().isEqual(today.toLocalDate())){
                Dish dish = order.getDish();
                dishesOrderedToday.add(dish);
            }
        } System.out.println("Seznam jídel, která byla objednána dnes: "+dishesOrderedToday);
    }
    public void exportOrdersForTable(List<Order> orderList,int tableNumber){
        System.out.println("** Objednávky pro stůl č. "+tableNumber+" **");
        System.out.println("****");

        int orderIndex = 1;
        for (Order order : orderList){
            if (order.getTableNumber() == tableNumber){
                System.out.print(orderIndex + ". " + order.getDish().getTitle() + " " + order.getNumberOfUnits() + " (" +
                        order.getDish().getPrice() + " Kč):    "+order.getOrderedTime().format(DateTimeFormatter.ofPattern("HH:mm")) + "-" +
                        order.getFulfilmentTime().format(DateTimeFormatter.ofPattern("HH:mm")) + "\t");
                if (order.isPaid()){
                    System.out.println("zaplaceno\n");
                } else {
                    System.out.println("\n");
                }
                orderIndex++;
            }
        }
        System.out.println("******");
    }
}
