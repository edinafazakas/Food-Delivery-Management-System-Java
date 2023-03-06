package DataAccess;
import BusinessLogic.DeliveryService;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Serializator {

    DeliveryService deliveryService = new DeliveryService();

    public Serializator() throws IOException, ClassNotFoundException {
        deliveryService.setMap(new HashMap<>());
        deliveryService.setC("");
        deliveryService.setMenuItems(new ArrayList<>());
        deliveryService.setCompositeProducts(new ArrayList<>());
        deliveryService.setBaseProducts(new ArrayList<>());
        try {
            FileOutputStream fileOut = new FileOutputStream("serialization.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(deliveryService);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in serialization.txt");
        } catch (IOException i) {
            i.printStackTrace();
        }

        FileInputStream fileInputStream = new FileInputStream("serialization.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        DeliveryService deliveryService1 = (DeliveryService) objectInputStream.readObject();
        objectInputStream.close();

        assert(deliveryService.getC().equals(deliveryService1.getC()));
        assert(deliveryService1.getMenuItems() == deliveryService.getMenuItems());
        assert(deliveryService1.getMap() == deliveryService.getMap());
        assert(deliveryService1.getBaseProducts() == deliveryService.getBaseProducts());
        assert(deliveryService1.getCompositeProducts() == deliveryService.getCompositeProducts());
    }
}
