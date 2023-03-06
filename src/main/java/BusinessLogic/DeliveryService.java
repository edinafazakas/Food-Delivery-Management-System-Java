package BusinessLogic;
import DataAccess.FileWrite;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DeliveryService implements IDeliveryServiceProcessing, Serializable {
    private static final long serialVersionUID = 1L;
    private Map<Order, ArrayList<String>> map;
    private ArrayList<MenuItem> menuItems;
    private ArrayList<BaseProduct> baseProducts;
    private ArrayList<CompositeProduct> compositeProducts;
    String c;

    /**
    this method is importing the products
     */
    @Override
    public void importProducts() {
        FileWrite f = new FileWrite();
        baseProducts = f.importProducts1();
    }

    /**
     this method is getting the products from the file with baseproducts
     */
    public void showProducts() {
        FileWrite f = new FileWrite();
        baseProducts = f.showProducts1();
    }

    /**
     this method is used for writing orders to file
     */
    public void writeOrders(int price) {
        FileWrite f = new FileWrite();
        f.addOrders(map, price);
    }

    /**
     this method is used for adding, editing and deleting products
     */
    @Override
    public void manageProduct(char m, BaseProduct o) throws IOException {

        if (m == 'a') {
            baseProducts.add(o);
            FileWrite f = new FileWrite();
            f.addProducts(o);
        } else if (m == 'm') {
            FileWrite f = new FileWrite();
            f.editProducts(o);
        } else if (m == 'd') {
            FileWrite f = new FileWrite();
            f.deleteProduct(o);
        }
    }

    /**
     this method is used for extracting the menu from file
     */
    @Override
    public void showMenu() {

        FileWrite f = new FileWrite();
        compositeProducts = f.showMenu1();
        //compositeProducts = new ArrayList<>();
            /*for(BaseProduct b: baseProducts) {
                CompositeProduct c = new CompositeProduct();
                ArrayList<BaseProduct> baseProducts1 = new ArrayList<BaseProduct>();
                baseProducts1.add(b);
                c.setBaseProducts(baseProducts1);
                compositeProducts.add(c);
            }*/
    }

    /**
     this method is used for extracting orders from file
     */
    public Map<Order, ArrayList<String>> showOrders() {
        FileWrite f = new FileWrite();
        map = f.showOrder1();
        return map;
    }

    /**
     this method is used to add menus to menu
     */
    public void addProductToMenu(CompositeProduct c) {
        /*compositeProducts =
        compositeProducts.add(c);*/
        FileWrite f = new FileWrite();
        f.addProductsToMenu1(c);
    }

    /**
     this method is for client to search for products after criteria
     */
    @Override
    public ArrayList<BaseProduct> searchForProducts(String after, String p) {
        if (after.equals("title")) {
            List<BaseProduct> b = baseProducts
                    .stream()
                    .filter(q -> q.getTitle().contains(p)) //2.0 && q.getRating() < 3.0)
                    .collect(Collectors.toList());
            for (BaseProduct b1 : b)
                System.out.print(b1.Stringto());
            return (ArrayList<BaseProduct>) b;
        }

        if (after.equals("rating")) {
            List<BaseProduct> b = baseProducts
                    .stream()
                    .filter(q -> q.getRating() == Float.parseFloat(p))
                    .collect(Collectors.toList());
            for (BaseProduct b1 : b)
                System.out.print(b1.Stringto());
            return (ArrayList<BaseProduct>) b;
        }

        if (after.equals("calories")) {
            List<BaseProduct> b = baseProducts
                    .stream()
                    .filter(q -> q.getCalories() == Integer.parseInt(p))
                    .collect(Collectors.toList());
            for (BaseProduct b1 : b)
                System.out.print(b1.Stringto());
            return (ArrayList<BaseProduct>) b;
        }
        if (after.equals("protein")) {
            List<BaseProduct> b = baseProducts
                    .stream()
                    .filter(q -> q.getProteins() == Integer.parseInt(p))
                    .collect(Collectors.toList());
            for (BaseProduct b1 : b)
                System.out.print(b1.Stringto());
            return (ArrayList<BaseProduct>) b;
        }
        if (after.equals("fat")) {
            List<BaseProduct> b = baseProducts
                    .stream()
                    .filter(q -> q.getFats() == Integer.parseInt(p))
                    .collect(Collectors.toList());
            for (BaseProduct b1 : b)
                System.out.print(b1.Stringto());
            return (ArrayList<BaseProduct>) b;
        }
        if (after.equals("sodium")) {
            List<BaseProduct> b = baseProducts
                    .stream()
                    .filter(q -> q.getSodium() == Integer.parseInt(p))
                    .collect(Collectors.toList());
            for (BaseProduct b1 : b)
                System.out.print(b1.Stringto());
            return (ArrayList<BaseProduct>) b;
        }
        if (after.equals("price")) {
            List<BaseProduct> b = baseProducts
                    .stream()
                    .filter(q -> q.getPrice() == Integer.parseInt(p)) //2.0 && q.getRating() < 3.0)
                    .collect(Collectors.toList());
            for (BaseProduct b1 : b)
                System.out.print(b1.Stringto());
            return (ArrayList<BaseProduct>) b;
        }
        return null;
    }

    /**
     this method is for creating bill
     */
    public void createBill(String message) {
        String number = "";
        try {
            File file = new File("orderID.txt");
            FileReader fr = new FileReader(file);
            String delimiter = ",";
            BufferedReader br = new BufferedReader(fr);
            String line = " ";
            String[] tempArr;
            while ((line = br.readLine()) != null) {
                tempArr = line.split(delimiter);
                number = tempArr[0];
            }
            br.close();
        }
        catch(IOException ioe) {
            ioe.printStackTrace();
        }

        int i = Integer.parseInt(number);
        FileWriter myWriter;
        try {
            myWriter = new FileWriter("bill" + i + ".txt");
            myWriter.write(message);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            myWriter = new FileWriter("orderID.txt");
            myWriter.write(String.valueOf(i + 1));
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     this method is for report1
     */
    public void report1(int startHour, int endHour) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
        String fileName = "order.csv";
        List<String> list = new ArrayList<>();
        map = showOrders();
        try {
            FileWriter myWriter = new FileWriter("report1.csv");
            myWriter.write("Orders made between " + startHour + "-" + endHour + ":\n\n");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream
                    .filter(line -> !line.startsWith("OrderID"))
                    .map(line -> line.split(","))
                    .forEach(line -> {
                        StringBuilder sb = new StringBuilder();
                        sb.append(line[2].charAt(11));
                        sb.append(line[2].charAt(12));

                        String i = sb.toString();
                        System.out.println(i + "\n");
                        if (Integer.parseInt(i) >= startHour && Integer.parseInt(i) <= endHour) {
                            try {
                                FileWriter myWriter = new FileWriter("report1.csv", true);
                                myWriter.write(line[0] + "," + line[1] + "," + line[2] + "," + line[3] + ",");
                                int j = 4;
                                try {
                                    while (line[j] != null) {
                                        try {
                                            myWriter.write(line[j] + ",");
                                            j++;
                                        } catch (Exception e1) {
                                            System.out.println("Exception");
                                        }
                                    }
                                } catch (Exception e2) {
                                    System.out.println("Exception 2");
                                }
                                myWriter.write("\n");
                                myWriter.close();
                            } catch (IOException e) {
                                System.out.println("An error occurred.");
                                e.printStackTrace();
                            }
                        }
                    });

        } catch (IOException e) {
            e.printStackTrace();
        }
        //list.forEach(System.out::println);
    }

    /**
     this method is for returning the products from orders
     */
    public ArrayList<String> returnOrderProducts() {
        ArrayList<String> str = new ArrayList<>();

        try {
            File file = new File("order.csv");
            FileReader fr = new FileReader(file);
            String delimiter = ",";
            BufferedReader br = new BufferedReader(fr);
            String line = " ";
            String[] tempArr;
            if ((line = br.readLine()) != null) {
            }

            while ((line = br.readLine()) != null) {
                tempArr = line.split(delimiter);

                int i = 4;
                try {
                    while (tempArr[i] != null) {
                        try {
                            str.add(tempArr[i]);
                            i++;
                        } catch (Exception e1) {
                            System.out.print("");
                        }
                    }
                } catch (Exception e2) {
                    System.out.print("");
                }
            }
            br.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return str;
    }

    /**
     this method is for returning the clients from orders
     */
    public ArrayList<String> returnOrderClients() {
        ArrayList<String> str = new ArrayList<>();

        try {
            File file = new File("order.csv");
            FileReader fr = new FileReader(file);
            String delimiter = ",";
            BufferedReader br = new BufferedReader(fr);
            String line = " ";
            String[] tempArr;
            if ((line = br.readLine()) != null) {
            }

            while ((line = br.readLine()) != null) {
                tempArr = line.split(delimiter);

                try {
                    str.add(tempArr[1]);
                } catch (Exception e1) {
                    System.out.print("");
                }
            }
        br.close();
    }
        catch(IOException ioe) {
            ioe.printStackTrace();
        }
        return str;
    }

    /**
     * orders with products ordered more than a specified time - report2
     */
    public void report2(int number) {
        String fileName = "order.csv";
        map = showOrders();
        try {
            FileWriter myWriter = new FileWriter("report2.csv");
            myWriter.write("Orders made with products ordered more than " + number + " times so far:\n\n");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        List<String> str = new ArrayList<>();
        str = returnOrderProducts();
        Map<String, Long> frequencyMap = new HashMap<>();

        for (String s : str) {
            frequencyMap.merge(s, 1L, Long::sum);
        }
        for (Map.Entry<String, Long> entry : frequencyMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream
                    .filter(line -> !line.startsWith("OrderID"))
                    .map(line -> line.split(","))
                    .forEach(line -> {

                        //Set<Map.Entry<String, Long>> frequencyMap
                        for (Map.Entry<String, Long> entry : frequencyMap.entrySet()) {
                            if (Integer.parseInt(String.valueOf(entry.getValue())) > number) {
                                int j = 4;
                                int ok = 0;
                                try {
                                    while (line[j] != null) {
                                        if (line[j].equals(entry.getKey())) {
                                            ok = 1;
                                            break;
                                        }
                                        j++;
                                    }
                                }
                                catch (Exception e10) {
                                    System.out.print("");
                                }

                                if(ok == 1) {
                                    System.out.println(entry.getKey() + ": " + entry.getValue());
                                    try {
                                        FileWriter myWriter = new FileWriter("report2.csv", true);
                                        myWriter.write(line[0] + "," + line[1] + "," + line[2] + "," + line[3] + ",");
                                        j = 4;
                                        try {
                                            while (line[j] != null) {
                                                    try {
                                                        myWriter.write(line[j] + ",");
                                                        j++;
                                                    } catch (Exception e1) {
                                                        System.out.println("Exception");
                                                    }
                                                }
                                        } catch (Exception e2) {
                                            System.out.println("Exception 2");
                                        }
                                        myWriter.write("\n");
                                        myWriter.close();
                                    } catch (IOException e) {
                                        System.out.println("An error occurred.");
                                        e.printStackTrace();
                                    }
                                }
                            }
                        }
                    });
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     this method is for report 3
     */
    public void report3(int number, int amount){
        String fileName = "order.csv";
        map = showOrders();
        try {
            FileWriter myWriter = new FileWriter("report3.csv");
            myWriter.write("Orders with clients who ordered more than " + number + " times so far and the amount of order is higher than " + amount +":\n\n");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        List<String> str = new ArrayList<>();
        str = returnOrderClients();
        Map<String, Long> frequencyMap = new HashMap<>();

        for (String s : str) {
            frequencyMap.merge(s, 1L, Long::sum);
        }
        for (Map.Entry<String, Long> entry : frequencyMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream
                    .filter(line -> !line.startsWith("OrderID"))
                    .map(line -> line.split(","))
                    .forEach(line -> {

                        //Set<Map.Entry<String, Long>> frequencyMap
                        for (Map.Entry<String, Long> entry : frequencyMap.entrySet()) {
                            if (Integer.parseInt(String.valueOf(entry.getValue())) > number) {
                                int ok = 0;
                                if (line[1].equals(entry.getKey()) && Integer.parseInt(line[3]) > amount)
                                            ok = 1;
                                if(ok == 1) {
                                    System.out.println(entry.getKey() + ": " + entry.getValue());
                                    try {
                                        FileWriter myWriter = new FileWriter("report3.csv", true);
                                        myWriter.write(line[0] + "," + line[1] + "," + line[2] + "," + line[3] + ",");
                                        int j = 4;
                                        try {
                                            while (line[j] != null) {
                                                try {
                                                    myWriter.write(line[j] + ",");
                                                    j++;
                                                } catch (Exception e1) {
                                                    System.out.println("Exception");
                                                }
                                            }
                                        } catch (Exception e2) {
                                            System.out.println("Exception 2");
                                        }
                                        myWriter.write("\n");
                                        myWriter.close();
                                    } catch (IOException e) {
                                        System.out.println("An error occurred.");
                                        e.printStackTrace();
                                    }
                                }
                            }
                        }
                    });
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     this method is for returning products for report4
     */
    public Map<String, Long> returnReport4(String date){

        ArrayList<String> str = new ArrayList<>();

        try {
            File file = new File("order.csv");
            FileReader fr = new FileReader(file);
            String delimiter = ",";
            BufferedReader br = new BufferedReader(fr);
            String line = " ";
            String[] tempArr;
            if ((line = br.readLine()) != null) {
            }

            while ((line = br.readLine()) != null) {
                tempArr = line.split(delimiter);
                StringBuilder sb = new StringBuilder();
                for(int k = 0; k < 10; k++) {
                    sb.append(tempArr[2].charAt(k));
                }
                String i = sb.toString();
                System.out.println(i);
                int j = 4;
                try {
                    if(i.equals(date)){
                        try {
                            while(tempArr[j] != null) {
                                str.add(tempArr[j]);
                                j++;
                            }
                        } catch (Exception e1) {
                            System.out.print("");
                        }
                    }
                } catch (Exception e2) {
                    System.out.print("");
                }
            }
            br.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        Map<String, Long> frequencyMap = new HashMap<>();
        //ArrayList<String> list = d.returnReport4("23/05/2022");
        for (String s : str) {
            frequencyMap.merge(s, 1L, Long::sum);
        }
        for (Map.Entry<String, Long> entry : frequencyMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        return frequencyMap;
    }

    /**
     this method is for report4
     */
    public void report4(String day){
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
        String fileName = "order.csv";
        List<String> list = new ArrayList<>();
        map = showOrders();
        try {
            FileWriter myWriter = new FileWriter("report4.csv");
            myWriter.write("Products ordered on " + day + " with the number of times they have been ordered " + ":\n\n");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

                        Map<String, Long> frequencyMap = returnReport4(day);
                        for (Map.Entry<String, Long> entry : frequencyMap.entrySet()) {
                            System.out.println(entry.getKey() + ": " + entry.getValue());
                            try {
                                FileWriter myWriter = new FileWriter("report4.csv", true);
                                myWriter.write(entry.getKey() + ": " + entry.getValue());
                                myWriter.write("\n");
                                myWriter.close();
                            } catch (IOException e) {
                                System.out.println("An error occurred.");
                                e.printStackTrace();
                            }
                        }

    }



    public ArrayList<CompositeProduct> getCompositeProducts() {
        return compositeProducts;
    }

    public void setCompositeProducts(ArrayList<CompositeProduct> compositeProducts) {
        this.compositeProducts = compositeProducts;
    }

    public void setBaseProducts(ArrayList<BaseProduct> baseProducts) {
        this.baseProducts = baseProducts;
    }

    public ArrayList<BaseProduct> getBaseProducts() {
        return baseProducts;
    }

    public Map<Order, ArrayList<String>> getMap() {
        return map;
    }

    public void setMap(Map<Order, ArrayList<String>> map) {
        this.map = map;
    }

    public ArrayList<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(ArrayList<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public static void main(String[] args){
        DeliveryService d = new DeliveryService();
        d.baseProducts = new ArrayList<>();
        d.importProducts();
        d.returnReport4("23/05/2022");
    }
}
