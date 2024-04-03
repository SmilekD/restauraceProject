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
            if (dish.getTitle().equals(title)){
                if (price >0){
                    dish.setPrice(price);
                }
                if (preparationTime >0){
                    dish.setPreparationTime(preparationTime);
                }
                if (image != null){
                    dish.setImage(image);
                }
            }
        }
    }

}
