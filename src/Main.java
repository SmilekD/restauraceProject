import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //////////////// DISCORD UŽIVATELSKÉ JMÉNO: smilda.         v Engeto skupinách jako David S  :-)) /////////////////////////////////////////ú

        RestaurantManager restaurantManager = new RestaurantManager();
        CookBook cookBook = new CookBook();

        Dish kureciRizek = null;
        Dish hranolky = null;
        Dish pstruhNaVine = null;
        Dish kofola = null;
        Dish limonada = null;
        Dish ryze = null;

        try {
            limonada = new Dish("limonada","limonada",-3,0);
        } catch (IllegalArgumentException e) {
            System.err.println("Nastala chyba při vytváření jídla:\n" + e.getLocalizedMessage());
        }

        try {
            ryze = new Dish("Rýže","ryze",30,15);
        } catch (IllegalArgumentException e) {
            System.err.println("Nastala chyba při vytváření jídla:\n" + e.getLocalizedMessage());
        }
        try {
            kureciRizek = new Dish("Obalovaný kuřecí řízek", "kureci-rizek", 150, 20);
        } catch (IllegalArgumentException e) {
            System.err.println("Nastala chyba při vytváření jídla:\n" + e.getLocalizedMessage());
        }

        try {
            hranolky = new Dish("Hranolky", "hranolky", 50, 10);
        } catch (IllegalArgumentException e) {
            System.err.println("Nastala chyba při vytváření jídla:\n" + e.getLocalizedMessage());
        }

        try {
            pstruhNaVine = new Dish("Pstruh na víně", "pstruh-na-vine", 200, 60);
        } catch (IllegalArgumentException e) {
            System.err.println("Nastala chyba při vytváření jídla:\n" + e.getLocalizedMessage());
        }

        try {
            kofola = new Dish("Kofola", "kofola", 40, 5);
        } catch (IllegalArgumentException e) {
            System.err.println("Nastala chyba při vytváření jídla:\n" + e.getLocalizedMessage());
        }

        cookBook.loadCookBookFromFile(Settings.getFileNameCookBook());

        cookBook.addDish(kureciRizek);
        cookBook.addDish(hranolky);
        cookBook.addDish(kofola);
        cookBook.addDish(pstruhNaVine);
        cookBook.addDish(ryze);



        List<Order> orderListTable15 = new ArrayList<>();
        List<Order> orderListTable7 = new ArrayList<>();

        orderListTable15.add(new Order(15, kureciRizek, 2, LocalDateTime.now(), LocalDateTime.of(0, 1, 1, 0, 0), false, false));
        orderListTable15.add(new Order(15, hranolky, 2, LocalDateTime.now(), LocalDateTime.of(0, 1, 1, 0, 0), false, false));
        orderListTable15.add(new Order(15, kofola, 2, LocalDateTime.now(), LocalDateTime.now(), true, false));


        orderListTable7.add(new Order(7, kureciRizek, 2, LocalDateTime.now(), LocalDateTime.of(2024, 4, 9, 21, 20), true, false));
        orderListTable7.add(new Order(7, kofola, 2, LocalDateTime.now(), LocalDateTime.of(2024, 4, 9, 20, 45), true, false));

        cookBook.deleteDish(ryze);
        restaurantManager.exportOrdersForTable(orderListTable15, 15);
        restaurantManager.notDelivered(orderListTable15);
        restaurantManager.sortedByTime(orderListTable15);
        restaurantManager.averageTime(orderListTable7);
        restaurantManager.getDishesOrderedToday(Arrays.asList(orderListTable15,orderListTable7));

        try {
            cookBook.exportCookBookToFile(Settings.getFileNameCookBook(),cookBook);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        cookBook.loadCookBookFromFile(Settings.getFileNameCookBook());

        Order.exportOrdersToFile(Settings.getFileNameOrders(),Arrays.asList(orderListTable15,orderListTable7));

        Order.loadOrdersFromFile(Settings.getFileNameOrders());

        System.out.println("****************************************************");
        System.out.println(kofola.getPrice()+"\t"+kofola.getPreparationTime());
        System.out.println("****************************************************");
        cookBook.updateDish("kofola","kofola",60,60);
        System.out.println(kofola.getPrice()+"\t"+kofola.getPreparationTime());
    }
}