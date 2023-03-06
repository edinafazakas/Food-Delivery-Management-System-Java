package BusinessLogic;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public interface IDeliveryServiceProcessing {
    void importProducts();
    void manageProduct(char m, BaseProduct o) throws IOException;
    void showMenu();
    ArrayList<BaseProduct> searchForProducts(String after, String p);

;}
