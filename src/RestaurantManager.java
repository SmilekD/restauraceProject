import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RestaurantManager {

    public void notDelivered(List<Order> orderList){
        for (Order order : orderList){
            if (!order.isPaid()){
                System.out.println("Rozpracovaná objednávka: "+"číslo stolu: "+order.getTableNumber()+ " "+order.getDish().getTitle()+" "+order.getNumberOfUnits()+"ks"+" "
                        +order.isPaid());
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
}
