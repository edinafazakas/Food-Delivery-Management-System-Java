package DataAccess;
import BusinessLogic.BaseProduct;
import BusinessLogic.CompositeProduct;
import BusinessLogic.DeliveryService;
import BusinessLogic.Order;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FileWrite extends DeliveryService {
    private ArrayList<BaseProduct> baseProducts;
    private ArrayList<CompositeProduct> compositeProducts;
    private Map<Order,ArrayList<String>> map1;
    private Order order;
    ArrayList<CompositeProduct> compositeToOrder;
    ArrayList<Map<Order, ArrayList<CompositeProduct>>> map;
    ArrayList<String> products;


    public ArrayList<CompositeProduct> showMenu1(){
        try {
            File file = new File("menu.csv");
            FileReader fr = new FileReader(file);
            String delimiter = ",";
            BufferedReader br = new BufferedReader(fr);
            String line = " ";
            String[] tempArr;
            if ((line = br.readLine()) != null) {
                tempArr = line.split(delimiter);
                for (String tempStr: tempArr) {
                    //System.out.print(tempStr + ", ");
                }
                System.out.println();
            }

            compositeProducts = new ArrayList<>();
            baseProducts = importProducts1();
            while ((line = br.readLine()) != null) {
                tempArr = line.split(delimiter);
                CompositeProduct c = new CompositeProduct();
                ArrayList<BaseProduct> b2 = new ArrayList<>();
                c.setPrice(-1);

                c.setName(tempArr[0]);
                try {
                    for (BaseProduct b : baseProducts)
                        if (tempArr[1].equals(b.getTitle()))
                            b2.add(b);
                }
                catch (Exception e5){
                    System.out.println("");
                }
                try{
                    if(tempArr[5] != null) {
                        c.setPrice(Integer.parseInt(tempArr[5]));
                        for (int i = 2; i <= 4 ; i++) {
                            for (BaseProduct b : baseProducts)
                                if (tempArr[i].equals(b.getTitle()))
                                    b2.add(b);
                        }
                        c.setBaseProducts(b2);
                    }
                }
                catch (Exception e1) {
                    try {
                        if (tempArr[4] != null) {
                            c.setPrice(Integer.parseInt(tempArr[4]));
                            for (int i = 2; i <= 3; i++) {
                                for (BaseProduct b : baseProducts)
                                    if (tempArr[i].equals(b.getTitle()))
                                        b2.add(b);
                            }
                            c.setBaseProducts(b2);
                        }
                    } catch (Exception e2) {
                        try {
                            if (tempArr[3] != null) {
                                c.setPrice(Integer.parseInt(tempArr[3]));
                                for (BaseProduct b : baseProducts)
                                    if (tempArr[2].equals(b.getTitle()))
                                        b2.add(b);
                            }
                            c.setBaseProducts(b2);
                        } catch (Exception e4) {
                            try {
                                if (tempArr[2] != null) {
                                    c.setPrice(Integer.parseInt(tempArr[2]));
                                }
                                c.setBaseProducts(b2);
                            }
                            catch (Exception e5){
                                System.out.println("Exception");
                            }
                        }
                    }
                }
                compositeProducts.add(c);
        }
            br.close();
        }
        catch(IOException ioe) {
            ioe.printStackTrace();
        }

        return compositeProducts;
    }

    public Map<Order, ArrayList<String>> showOrder1(){

        try {
            File file = new File("order.csv");
            FileReader fr = new FileReader(file);
            String delimiter = ",";
            BufferedReader br = new BufferedReader(fr);
            String line = " ";
            String[] tempArr;
            if ((line = br.readLine()) != null) {
            }
            map1 = new HashMap<Order, ArrayList<String>>();
            while ((line = br.readLine()) != null) {
                tempArr = line.split(delimiter);
                order = new Order();
                compositeProducts = showMenu1();
                order.setOrderID(Integer.parseInt(tempArr[0]));
                order.setClientID(tempArr[1]);
                order.setOrderDate(tempArr[2]);
                order.setFinalPrice(Integer.parseInt(tempArr[3]));
                products = new ArrayList<>();

                int i = 4;
                try {
                    while (tempArr[i] != null) {
                        try {
                            products.add(tempArr[i]);
                            i++;
                        } catch (Exception e1) {
                            System.out.print("");
                        }
                        map1.put(order, products);
                    }
                }
                catch (Exception e2)
                {
                    System.out.print("");
                }
            }
            br.close();
        }
        catch(IOException ioe) {
            ioe.printStackTrace();
        }
        return map1;
    }

    public ArrayList<BaseProduct> importProducts1(){
        try {
            File file = new File("products.csv");
            FileReader fr = new FileReader(file);
            String delimiter = ",";
            BufferedReader br = new BufferedReader(fr);
            String line = " ";
            String[] tempArr;
            if ((line = br.readLine()) != null) {
                tempArr = line.split(delimiter);
                for (String tempStr: tempArr) {
                    //System.out.print(tempStr + ", ");
                }
                System.out.println();
            }
            baseProducts = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                tempArr = line.split(delimiter);
                int i = 0;
                int k=0;
                BaseProduct baseProduct1 = new BaseProduct();
                for(BaseProduct b: baseProducts)
                    if(b.getTitle().equals(tempArr[0]))
                        k++;
                if(k == 0) {
                    for (String tempStr : tempArr) {
                        if (i == 0) baseProduct1.setTitle(tempStr);
                        else if (i == 1) baseProduct1.setRating(Float.parseFloat(tempStr));
                        else if (i == 2) baseProduct1.setCalories(Integer.parseInt(tempStr));
                        else if (i == 3) baseProduct1.setProteins(Integer.parseInt(tempStr));
                        else if (i == 4) baseProduct1.setFats(Integer.parseInt(tempStr));
                        else if (i == 5) baseProduct1.setSodium(Integer.parseInt(tempStr));
                        else if (i == 6) baseProduct1.setPrice(Integer.parseInt(tempStr));
                        i++;
                    }

                    baseProducts.add(baseProduct1);
                }
            }
            br.close();
        }
        catch(IOException ioe) {
            ioe.printStackTrace();
        }
        return baseProducts;
    }

    public ArrayList<BaseProduct> showProducts1(){
        try {
            File file = new File("products3.csv");
            FileReader fr = new FileReader(file);
            String delimiter = ",";
            BufferedReader br = new BufferedReader(fr);
            String line = " ";
            String[] tempArr;
            if ((line = br.readLine()) != null) {
                tempArr = line.split(delimiter);
                for (String tempStr: tempArr) {
                    //System.out.print(tempStr + ", ");
                }
                System.out.println();
            }
            baseProducts = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                tempArr = line.split(delimiter);
                int i = 0;
                int k=0;
                BaseProduct baseProduct1 = new BaseProduct();
                for(BaseProduct b: baseProducts)
                    if(b.getTitle().equals(tempArr[0]))
                        k++;
                if(k == 0) {
                    for (String tempStr : tempArr) {
                        if (i == 0) baseProduct1.setTitle(tempStr);
                        else if (i == 1) baseProduct1.setRating(Float.parseFloat(tempStr));
                        else if (i == 2) baseProduct1.setCalories(Integer.parseInt(tempStr));
                        else if (i == 3) baseProduct1.setProteins(Integer.parseInt(tempStr));
                        else if (i == 4) baseProduct1.setFats(Integer.parseInt(tempStr));
                        else if (i == 5) baseProduct1.setSodium(Integer.parseInt(tempStr));
                        else if (i == 6) baseProduct1.setPrice(Integer.parseInt(tempStr));
                        i++;
                    }

                    baseProducts.add(baseProduct1);
                }
            }
            br.close();
        }
        catch(IOException ioe) {
            ioe.printStackTrace();
        }

        return baseProducts;
    }

    public void editProducts(BaseProduct o) throws IOException {
        File file = new File("products2.csv");
        FileReader fr = new FileReader(file);
        String delimiter = ",";
        BufferedReader br = new BufferedReader(fr);
        String line = " ";
        String[] tempArr;
        try {
            FileWriter myWriter = new FileWriter("products3.csv");
            myWriter.write("");
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if ((line = br.readLine()) != null) {
            tempArr = line.split(delimiter);
            for (String tempStr : tempArr) {
                try {
                    FileWriter myWriter = new FileWriter("products3.csv", true);
                    myWriter.write(tempStr + ",");
                    myWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println();
        }

        while ((line = br.readLine()) != null) {
            tempArr = line.split(delimiter);
            int i = 0;
            if (o.getTitle().equals(tempArr[0])) {

                try {
                    FileWriter myWriter = new FileWriter("products3.csv", true);
                    myWriter.write("\n");
                    myWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                for (String tempStr : tempArr) {
                    if (i == 0) tempStr = o.getTitle();
                    else if (i == 1) tempStr = String.valueOf(o.getRating());
                    else if (i == 2) tempStr = String.valueOf(o.getCalories());
                    else if (i == 3) tempStr = String.valueOf(o.getProteins());
                    else if (i == 4) tempStr = String.valueOf(o.getFats());
                    else if (i == 5) tempStr = String.valueOf(o.getSodium());
                    else if (i == 6) tempStr = String.valueOf(o.getPrice());

                    try {
                        FileWriter myWriter = new FileWriter("products3.csv", true);
                        if(i == 6)
                            myWriter.write(tempStr);
                        else
                            myWriter.write(tempStr + ",");

                        myWriter.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    i++;
                }
            }
            else{
                try {
                    FileWriter myWriter = new FileWriter("products3.csv", true);
                    myWriter.write("\n" + tempArr[0] + "," + tempArr[1] + "," + tempArr[2] + "," + tempArr[3] + "," + tempArr[4] + "," + tempArr[5] + "," + tempArr[6]);
                    myWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void deleteProduct(BaseProduct o) throws IOException {
        File file = new File("products2.csv");
        FileReader fr = new FileReader(file);
        String delimiter = ",";
        BufferedReader br = new BufferedReader(fr);
        String line = " ";
        String[] tempArr;
        try {
            FileWriter myWriter = new FileWriter("products3.csv");
            myWriter.write("");
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if ((line = br.readLine()) != null) {
            tempArr = line.split(delimiter);
            for (String tempStr : tempArr) {
                try {
                    FileWriter myWriter = new FileWriter("products3.csv", true);
                    myWriter.write(tempStr + ",");
                    myWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println();
        }

        while ((line = br.readLine()) != null) {
            tempArr = line.split(delimiter);
            int i = 0;
            if (!o.getTitle().equals(tempArr[0]))
                try {
                    FileWriter myWriter = new FileWriter("products3.csv", true);
                    try {
                        myWriter.write("\n" + tempArr[0] + "," + tempArr[1] + "," + tempArr[2] + "," + tempArr[3] + "," + tempArr[4] + "," + tempArr[5] + "," + tempArr[6]);
                    }
                    catch(ArrayIndexOutOfBoundsException e)
                    {
                        System.out.println("Exception");
                    }
                    myWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

    }

    public void addProducts(BaseProduct o){
        try {
            FileWriter myWriter = new FileWriter("products2.csv", true);
            myWriter.write("\n" + o.getTitle() + "," + o.getRating() + "," + o.getCalories() + "," + o.getProteins() + "," + o.getFats() + "," + o.getSodium() + "," + o.getPrice() + "\n");

            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        try {
            FileWriter myWriter = new FileWriter("products3.csv", true);
            myWriter.write("\n" +  o.getTitle() + "," + o.getRating() + "," + o.getCalories() + "," + o.getProteins() + "," + o.getFats() + "," + o.getSodium() + "," + o.getPrice() + "\n");

            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void addProductsToMenu1(CompositeProduct c){
        try {
            FileWriter myWriter = new FileWriter("menu.csv", true);
            myWriter.write(c.getName() + ",");
            for(BaseProduct b: c.getBaseProducts())
            myWriter.write( b.getTitle() + ",");
            myWriter.write( c.getPrice() + "\n");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void addOrders(Map<Order, ArrayList<String>> map, int price){
       assert price > 0;
        try {
            FileWriter myWriter = new FileWriter("order.csv", true);
            ArrayList<CompositeProduct> compositeProducts1 = new ArrayList<>();
            String clientID = "";

            try {
                File file = new File("currentClient.txt");
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                String line = br.readLine();
                clientID = line;
                br.close();
            }
            catch(IOException ioe) {
                ioe.printStackTrace();
            }
            for(Map.Entry<Order, ArrayList< String>> me : map.entrySet()){
                myWriter.write( "\n" + me.getKey().getOrderID() + "," + clientID + "," + me.getKey().getOrderDate() + ",");
                myWriter.write(price + ",");
                for(String s: me.getValue())
                            myWriter.write(s + ",");
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
