public class Dish {
    private String title, image;
    private int price, preparationTime;

    public Dish(String title, String image, int price, int preparationTime) {
        this.title = title;
        this.image = image;

        if (price <= 0) {
            throw new IllegalArgumentException("Cena jídla musí být kladné číslo.");
        }
        this.price = price;
        if (preparationTime < 0) {
            throw new IllegalArgumentException("Doba přípravy musí být kladné číslo.");
        }
        this.preparationTime = preparationTime;
    }
    public Dish(String title, int price, int preparationTime){
        this(title,"Blank",price,preparationTime);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(int preparationTime) {
        this.preparationTime = preparationTime;
    }
    }

