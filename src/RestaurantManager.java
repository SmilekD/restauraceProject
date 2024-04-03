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

}
