package Presentation;
import BusinessLogic.BaseProduct;
import BusinessLogic.CompositeProduct;
import BusinessLogic.DeliveryService;
import BusinessLogic.Order;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class ClientOperations implements ActionListener{
    private JFrame f;
    private JTable table1, table2, table3;
    Dimension d, d2;
    private JLabel l1;
    private JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12;
    DeliveryService deliveryService;
    DefaultTableModel tableModel, tableModel2, tableModel3;
    JScrollPane scrollPane, scrollPane2, scrollPane3;
    String[] columnNames, columnNames1;
    JTextField t1, t2, t3, t4;
    TableColumn col;
    ArrayList<CompositeProduct> compositeToMenu;
    ArrayList<BaseProduct> baseToOrder;
    public ClientOperations() {
        f = new JFrame("Client operations");
        f.setSize(2000, 1000);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setLayout(null);
        b1 = new JButton("SHOW PRODUCTS");
        b2 = new JButton("SEARCH TITLE");
        b3 = new JButton("SEARCH RATING");
        b4 = new JButton("SEARCH CALORIES");
        b5 = new JButton("SEARCH PROTEINS ");
        b6 = new JButton("SEARCH FAT");
        b7 = new JButton("SEARCH SODIUM");
        b8 = new JButton("SEARCH PRICE");
        b9 = new JButton("SHOW MENU");
        b10 = new JButton("MAKE ORDER");
        b11 = new JButton("ADD TO ORDER");
        b12 = new JButton("BACK");

        t1 = new JTextField(15);
        t2 = new JTextField(15);
        t3 = new JTextField(15);
        t4 = new JTextField(15);


        b1.setBounds(750, 30, 150, 50);
        t1.setBounds(750, 100, 200, 20);
        b2.setBounds(750, 150, 180, 40);
        b3.setBounds(750, 200, 180, 40);
        b4.setBounds(750, 250, 180, 40);
        b5.setBounds(750, 300, 180, 40);
        b6.setBounds(750, 350, 180, 40);
        b7.setBounds(750, 400, 180, 40);
        b8.setBounds(750, 450, 180, 40);
        b9.setBounds(920, 30, 150, 50);
        t2.setBounds(750, 550, 180, 20);
        t3.setBounds(750, 580, 180, 20);
        t4.setBounds(750, 610, 180, 20);
        b10.setBounds(1300, 250, 200, 50);
        b11.setBounds(1300, 320, 200, 50);
        b12.setBounds(1600, 700, 150, 50);


        deliveryService = new DeliveryService();
        deliveryService.setBaseProducts(new ArrayList<>());
        deliveryService.importProducts();

        columnNames = new String[]{"Name", "Item", "Price"};
        columnNames1 = new String[]{"Title", "Rating", "Calories", "Proteins", "Fats", "Sodium", "Price"};

        tableModel = new DefaultTableModel(columnNames1, 0);
        tableModel2 = new DefaultTableModel(columnNames, 0);
        tableModel3 = new DefaultTableModel(columnNames, 0);
        tableModel2.setColumnIdentifiers(columnNames);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tableModel.setColumnIdentifiers(columnNames1);
        tableModel2.setColumnIdentifiers(columnNames);
        tableModel3.setColumnIdentifiers(columnNames);

        table1 = new JTable(tableModel);
        table2 = new JTable(tableModel2);
        table3 = new JTable(tableModel3);

        Dimension d = new Dimension(800, 600);
        Dimension d2 = new Dimension(600, 200);

        col = table2.getColumnModel().getColumn(1);

        table1.setSize(d);
        table1.setBounds(10, 30, 700, 400);
        scrollPane = new JScrollPane(table1);
        scrollPane.setBounds(table1.getBounds());
        scrollPane.setSize(new Dimension(700, 400));

        table2.setSize(d);
        table2.setBounds(10, 500, 700, 400);
        scrollPane2 = new JScrollPane(table2);
        scrollPane2.setBounds(table2.getBounds());
        scrollPane2.setSize(new Dimension(700, 400));

        table3.setSize(d);
        table3.setBounds(1100, 10, 600, 200);
        scrollPane3 = new JScrollPane(table3);
        scrollPane3.setBounds(table3.getBounds());
        scrollPane3.setSize(new Dimension(600, 200));

        compositeToMenu = new ArrayList<>();

        table1.getColumnModel().getColumn(0).setPreferredWidth(400);
        table1.getColumnModel().getColumn(1).setPreferredWidth(5);
        table1.getColumnModel().getColumn(2).setPreferredWidth(15);
        table1.getColumnModel().getColumn(3).setPreferredWidth(15);
        table1.getColumnModel().getColumn(4).setPreferredWidth(15);
        table1.getColumnModel().getColumn(5).setPreferredWidth(15);
        table1.getColumnModel().getColumn(6).setPreferredWidth(5);
        table2.getColumnModel().getColumn(0).setPreferredWidth(200);
        table2.getColumnModel().getColumn(1).setPreferredWidth(50);
        table2.getColumnModel().getColumn(2).setPreferredWidth(15);
        table1.getColumnModel().getColumn(0).setPreferredWidth(400);
        table3.getColumnModel().getColumn(1).setPreferredWidth(5);
        table3.getColumnModel().getColumn(2).setPreferredWidth(15);


        f.setVisible(true);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(b4);
        f.add(b5);
        f.add(b6);
        f.add(b7);
        f.add(b8);
        f.add(b9);
        f.add(b10);
        f.add(b11);
        f.add(b12);
        f.add(t1);
        f.add(t2);
        f.add(t3);
        f.add(t4);


        f.add(scrollPane);
        f.add(scrollPane2);
        f.add(scrollPane3);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        b10.addActionListener(this);
        b11.addActionListener(this);
        b12.addActionListener(this);


        table2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (e.getClickCount() == 1) {
                    Object[] o = new Object[3];
                    int row = table2.getSelectedRow();
                    o[0] = table2.getValueAt(row, 0);
                    o[1] = table2.getValueAt(row, 1);
                    o[2] = table2.getValueAt(row, 2);
                    t2.setText(o[0].toString());
                    t3.setText(o[1].toString());
                    t4.setText(o[2].toString());
                }
            }
        });

        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    Object[] o = new Object[3];
                    int row = table1.getSelectedRow();
                    o[0] = table1.getValueAt(row, 0);
                    o[1] = table1.getValueAt(row, 0);
                    o[2] = table1.getValueAt(row, 6);
                    t2.setText(o[0].toString());
                    t3.setText(o[1].toString());
                    t4.setText(o[2].toString());
                }
            }
        });
    }

    public void addProductTable(int i) {
        Object[] obj = new Object[8];
        obj[0] = deliveryService.getBaseProducts().get(i).getTitle();
        obj[1] = deliveryService.getBaseProducts().get(i).getRating();
        obj[2] = deliveryService.getBaseProducts().get(i).getCalories();
        obj[3] = deliveryService.getBaseProducts().get(i).getProteins();
        obj[4] = deliveryService.getBaseProducts().get(i).getFats();
        obj[5] = deliveryService.getBaseProducts().get(i).getSodium();
        obj[6] = deliveryService.getBaseProducts().get(i).getPrice();
        tableModel.addRow(obj);
    }

    public void addCompositeProduct(CompositeProduct c) {

        Object[] obj = new Object[8];
        obj[0] = c.getName();
        for(BaseProduct b: c.getBaseProducts()) {
            obj[1] = b.getTitle();
        }
        obj[2] = c.getPrice();

        tableModel2.addRow(obj);
    }

    public void searchAtfer(String after){
        tableModel.setRowCount(0);
        ArrayList<BaseProduct> b = deliveryService.searchForProducts(after, t1.getText());
        for (int i = 0; i < b.size(); i++) {
            Object[] obj = new Object[8];
            obj[0] = b.get(i).getTitle();
            obj[1] = b.get(i).getRating();
            obj[2] = b.get(i).getCalories();
            obj[3] = b.get(i).getProteins();
            obj[4] = b.get(i).getFats();
            obj[5] = b.get(i).getSodium();
            obj[6] = b.get(i).getPrice();
            tableModel.addRow(obj);
        }
    }

    public void addCompositeToOrder(CompositeProduct c) {

        Object[] obj = new Object[8];
        obj[0] = c.getName();
        for(BaseProduct b: c.getBaseProducts()) {
            obj[1] = b.getTitle();
        }
        obj[2] = c.getPrice();

        tableModel3.addRow(obj);
    }

    public void addBasicToOrder(BaseProduct b) {
        Object[] obj = new Object[8];
        obj[0] = b.getTitle();
        obj[1] = b.getTitle();
        obj[2] = b.getPrice();
        tableModel3.addRow(obj);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //show menu
        if (e.getSource() == b9) {
            tableModel2.setRowCount(0);
            deliveryService.showMenu();
            for (int i = 0; i < deliveryService.getCompositeProducts().size(); i++) {
                addCompositeProduct(deliveryService.getCompositeProducts().get(i));
            }
        }
        //search after title
        if (e.getSource() == b2) {
            searchAtfer("title");
        }

        //search after rating
        if (e.getSource() == b3) {
            searchAtfer("rating");
        }

        //search after calories
        if (e.getSource() == b4) {
            searchAtfer("calories");
        }

        //search after protein
        if (e.getSource() == b5) {
            searchAtfer("protein");
        }

        //search after fat
        if (e.getSource() == b6) {
            searchAtfer("fat");
        }

        //search after sodium
        if (e.getSource() == b7) {
            searchAtfer("sodium");
        }

        //search after price
        if (e.getSource() == b8) {
            searchAtfer("price");
        }

        //show products
        if (e.getSource() == b1) {
            tableModel.setRowCount(0);
            deliveryService.showProducts();
            for (int i = 0; i < this.deliveryService.getBaseProducts().size(); i++) {
                addProductTable(i);
            }
        }

        //add menu to order table
        if (e.getSource() == b11) {
            //compositeToMenu = new ArrayList<>();
            baseToOrder = new ArrayList<>();
            int k = 0;
            for (CompositeProduct c : deliveryService.getCompositeProducts()) {
                k = 0;
                if (t2.getText().equals(c.getName())) {
                    k++;
                    addCompositeToOrder(c);
                    compositeToMenu.add(c);
                }
            }
                if(k == 0){
                    for(BaseProduct b: deliveryService.getBaseProducts()){
                        if(t2.getText().equals(b.getTitle())) {
                            addBasicToOrder(b);
                            CompositeProduct co = new CompositeProduct();
                            baseToOrder.add(b);
                            co.setBaseProducts(baseToOrder);
                            co.setName(co.getBaseProducts().get(0).getTitle());
                            co.setPrice(co.getBaseProducts().get(0).getPrice());
                            compositeToMenu.add(co);
                        }
                    }
                }
            }

        //create order
        if (e.getSource() == b10) {

            String clientID = "";
            Order o = new Order();
            //int co = deliveryService.getContor().get(deliveryService.getContor().size() - 1) + 1;

            deliveryService.setMap(new HashMap<>());

            Client client = new Client();
            o.setClientID(client.getUsername());


            ArrayList<String> products = new ArrayList<>();
            for(CompositeProduct c: compositeToMenu)
                products.add(c.getName());
            deliveryService.getMap().put(o, products);
            if(compositeToMenu.isEmpty()){
                JOptionPane.showMessageDialog(null, "Order is empty!");
            }
            else {
                int s = 0;
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                Date date = new Date();
                System.out.println(formatter.format(date));
                    o.setOrderDate(formatter.format(date));
                for(CompositeProduct c: compositeToMenu)
                    s += c.computePrice();
                o.setFinalPrice(s);
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
                int co = Integer.parseInt(number);
                o.setOrderID(co);
                JOptionPane.showMessageDialog(null, "Order made successfully!");
                new EmployeeNotification();
                StringBuilder sb = new StringBuilder();
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
                System.out.println("clientID: " + clientID + "\n");
                sb.append("Order #" + co + "\nClient id: " + clientID + "\nOrder date: " + o.getOrderDate());
                for(CompositeProduct c: compositeToMenu)
                sb.append("\n+ Menu Item: " + c.getName());
                sb.append("\nTotal Price: " + o.getFinalPrice());
                deliveryService.createBill(sb.toString());
                deliveryService.writeOrders(s);
            }
            tableModel3.setRowCount(0);
            compositeToMenu = new ArrayList<>();
        }

        if(e.getSource() == b12){
            new FirstPage();
            f.setVisible(false);
        }
    }

    public static void main(String[] args) {

        new ClientOperations();
    }

}


