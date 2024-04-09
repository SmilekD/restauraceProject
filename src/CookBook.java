import java.util.ArrayList;
import java.util.List;

public class CookBook {
    private List<Dish> dishList = new ArrayList<>();
    public void addDish(Dish dish){
        dishList.add(dish);
    }
    public void deleteDish(Dish dish){
        dishList.remove(dish);
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

}
