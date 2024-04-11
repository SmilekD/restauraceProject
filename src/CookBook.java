import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CookBook {
    private final List<Dish> dishList = new ArrayList<>();
    public void addDish(Dish dish){
        dishList.add(dish);
    }
    public void deleteDish(Dish dish){
        dishList.remove(dish);
    }
    public List<Dish> getDishes(){
        return dishList;
    }
    public void updateDish(String title, String image, int price, int preparationTime){
        for (Dish dish : dishList){
            try {
                if (price > 0){
                    dish.setPrice(price);
                } else {
                    throw new IllegalArgumentException("Aktualizovaná cena musí být větší než 0!!");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Chyba: " + e.getMessage());
            }

            try {
                if (preparationTime > 0){
                    dish.setPreparationTime(preparationTime);
                } else {
                    throw new IllegalArgumentException("Aktualizovaný čas přípravy musí být větší než 0!!");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Chyba: " + e.getMessage());
            }
        }
    }
    public void exportCookBookToFile(String fileName, CookBook cookBook) throws IOException {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(fileName)))) {
            List<Dish> dishes = cookBook.getDishes();

            for (Dish dish : dishes) {
                writer.println(dish.getTitle() + "," + dish.getImage() + "," + dish.getPrice() + "," + dish.getPreparationTime());
            }
            System.out.println("Data jídel byla úspěšně uložena do souboru: " + fileName);
        }
    }
    public void loadCookBookFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String title = parts[0];
                String image = parts[1];
                int price = Integer.parseInt(parts[2]);
                int preparationTime = Integer.parseInt(parts[3]);

                Dish dish = new Dish(title, image, price, preparationTime);
            }
            System.out.println("Seznam načtených jídel:");
            for (Dish dish : dishList) {
                System.out.println(dish.getTitle() + ", " + dish.getImage() + ", " + dish.getPrice() + ", " + dish.getPreparationTime());
            }

        } catch (IOException | IllegalArgumentException e) {
            System.err.println("Chyba při načítání seznamu jídel ze souboru: " + e.getMessage());
        }
    }
}
