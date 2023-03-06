package BusinessLogic;

public class BaseProduct extends MenuItem{

    private String title;
    private float rating;
    private int  calories;
    private int proteins;
    private int fats;
    private int sodium;
    private int price;

    @Override
    public int computePrice() {

        return 0;
    }

    public String Stringto(){
        return this.getTitle() + ", " + this.getRating() + ", " + this.getCalories() + ", " + this.getProteins() + ", " + this.getSodium() + ", " + this.getPrice() + ", \n";
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getProteins() {
        return proteins;
    }

    public void setProteins(int proteins) {
        this.proteins = proteins;
    }

    public int getFats() {
        return fats;
    }

    public void setFats(int fats) {
        this.fats = fats;
    }

    public int getSodium() {
        return sodium;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public BaseProduct(String title, float rating, int calories, int proteins, int fats, int sodium, int price) {
        this.title = title;
        this.rating = rating;
        this.calories = calories;
        this.proteins = proteins;
        this.fats = fats;
        this.sodium = sodium;
        this.price = price;
    }
    public BaseProduct(){

    }
}

