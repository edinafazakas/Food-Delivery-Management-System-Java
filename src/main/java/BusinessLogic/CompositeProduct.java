package BusinessLogic;
import java.util.ArrayList;

public class CompositeProduct extends MenuItem{
    private ArrayList<BaseProduct> baseProducts;
    private String name;
    private int price;

    public CompositeProduct() {
    }

    public CompositeProduct(ArrayList<BaseProduct> baseProducts, String name) {
        this.baseProducts = baseProducts;
        //this.name = name;
    }

    public ArrayList<BaseProduct> getBaseProducts() {
        return baseProducts;
    }

    public void setBaseProducts(ArrayList<BaseProduct> baseProducts) {
        this.baseProducts = baseProducts;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int computePrice() {
        int p = 0;
        for(BaseProduct b: baseProducts) {
              p += b.getPrice();
           }
        this.price = p;
        return p;
    }
}
