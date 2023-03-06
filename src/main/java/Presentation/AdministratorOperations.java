package Presentation;
import BusinessLogic.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AdministratorOperations implements ActionListener {
    private JFrame f;
    private JTable table1, table2, table3, table4;
    private JPanel p;
    private JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11,l12,l13,l14;
    JTextField t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14;
    private JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15;
    DeliveryService deliveryService;
    DefaultTableModel tableModel, tableModel2, tableModel3, tableModel4;
    JScrollPane scrollPane, scrollPane2, scrollPane3, scrollPane4;
    JComboBox<String> comboBox;
    TableColumn col;
    List<String[]> editData;
    ArrayList<BaseProduct> baseProductsMenu;
    ArrayList<CompositeProduct> compositeProducts;

    public AdministratorOperations() {

        deliveryService = new DeliveryService();
        deliveryService.setBaseProducts(new ArrayList<>());
        deliveryService.importProducts();

        f = new JFrame("Adminstrator operations");
        f.validate();
        f.setSize(2000, 1000);
        f.setVisible(true);
        f.setLayout(null);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        l1 = new JLabel("Hours: ");
        l2 = new JLabel("--");
        l3 = new JLabel("Calories:");
        l4 = new JLabel("Protein:");
        l5 = new JLabel("Fat:");
        l6 = new JLabel("Sodium:");
        l7 = new JLabel("Price:");
        l8 = new JLabel("PRODUCTS");
        l9 = new JLabel("MENU");
        l10 = new JLabel("CREATE NEW MENU");
        l11 = new JLabel("Number:");
        l12 = new JLabel("Number:");
        l13 = new JLabel("Amount:");
        l14 = new JLabel("Day:");


        l1.setBounds(1150, 350, 100, 20);
        l2.setBounds(1220, 400, 100, 20);
        l3.setBounds(10, 600, 100, 20);
        l4.setBounds(10, 650, 100, 20);
        l5.setBounds(10, 700, 100, 20);
        l6.setBounds(10, 750, 100, 20);
        l7.setBounds(10, 800, 100, 20);
        l8.setBounds(600, 5, 100, 20);
        l9.setBounds(1300, 5, 100, 20);
        l10.setBounds(430, 550, 100, 20);
        l11.setBounds(1180, 480, 100, 20);
        l12.setBounds(900, 550, 100, 20);
        l13.setBounds(1170, 550, 100, 20);
        l14.setBounds(1200, 620, 80, 20);

        b1 = new JButton("IMPORT PRODUCTS");
        b2 = new JButton("SHOW MENU");
        b3 = new JButton("ADD PRODUCT");
        b4 = new JButton("EDIT PRODUCT");
        b5 = new JButton("DELETE PRODUCT");
        b6 = new JButton("ADD MENU (COMPOSITE PRODUCT)");
        b7 = new JButton("SHOW PRODUCTS");
        b8 = new JButton("ADD TO MENU");
        b9 = new JButton("SET NAME TO MENU");
        b10 = new JButton("SHOW ORDERS");
        b11 = new JButton("BACK");
        b12 = new JButton("MAKE REPORT 1");
        b13 = new JButton("MAKE REPORT 2");
        b14 = new JButton("MAKE REPORT 3");
        b15 = new JButton("MAKE REPORT 4");

        t1 = new JTextField(25);
        t2 = new JTextField(25);
        t3 = new JTextField(25);
        t4 = new JTextField(25);
        t5 = new JTextField(25);
        t6 = new JTextField(25);
        t7 = new JTextField(25);
        t8 = new JTextField(25);
        t9 = new JTextField(10);
        t10 = new JTextField(10);
        t11 = new JTextField(20);
        t12 = new JTextField(20);
        t13 = new JTextField(20);
        t14 = new JTextField(20);

        b1.setBounds(680, 400, 150, 40);
        b2.setBounds(880, 340, 150, 40);
        b3.setBounds(90, 750, 150, 30);
        b4.setBounds(90, 790, 150, 30);
        b5.setBounds(90, 830, 150, 30);
        b6.setBounds(420, 670, 300, 50);
        b7.setBounds(680, 340, 150, 40);
        b8.setBounds(90, 870, 150, 30);
        b9.setBounds(90, 910, 150, 30);
        b10.setBounds(880, 400, 150, 40);
        b11.setBounds(1600, 800, 150, 50);
        b12.setBounds(1400, 400, 150, 50);
        b13.setBounds(1400, 470, 150, 50);
        b14.setBounds(1400, 540, 150, 50);
        b15.setBounds(1400, 610, 150, 50);

        t1.setBounds(30, 430, 300, 30);
        t2.setBounds(30, 470, 300, 30);
        t3.setBounds(30, 510, 300, 30);
        t4.setBounds(30, 550, 300, 30);
        t5.setBounds(30, 590, 300, 30);
        t6.setBounds(30, 630, 300, 30);
        t7.setBounds(30, 670, 300, 30);
        t8.setBounds(30, 710, 300, 30);
        t9.setBounds(1150, 400, 50, 30);
        t10.setBounds(1250, 400, 50, 30);
        t11.setBounds(980, 550, 130, 30);
        t12.setBounds(1250, 550, 130, 30);
        t13.setBounds(1250, 480, 130, 30);
        t14.setBounds(1250, 620, 130, 30);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] columnNames = {"Title", "Rating", "Calories", "Protein", "Fat", "Sodium", "Price"};
        String[] columnNames2 = {"Name", "Items", "Price"};
        String[] columnNames3 = {"OrderID", "ClientID", "OrderDate", "MenuItems", "TotalPrice"};

        tableModel = new DefaultTableModel(columnNames, 0);
        tableModel2 = new DefaultTableModel(columnNames2, 0);
        tableModel3 = new DefaultTableModel(columnNames, 0);
        tableModel4 = new DefaultTableModel(columnNames3, 0);


        tableModel.setColumnIdentifiers(columnNames);
        tableModel2.setColumnIdentifiers(columnNames2);
        tableModel3.setColumnIdentifiers(columnNames);
        tableModel4.setColumnIdentifiers(columnNames3);

        table1 = new JTable(tableModel);
        table2 = new JTable(tableModel2);
        table3 = new JTable(tableModel3);
        table4 = new JTable(tableModel4);


        Dimension d = new Dimension(800, 600);
        Dimension d2 = new Dimension(600, 200);

        col = table2.getColumnModel().getColumn(1);

        table1.setSize(d);
        table1.setBounds(20, 20, 600, 400);
        scrollPane = new JScrollPane(table1);
        scrollPane.setBounds(table1.getBounds());
        scrollPane.setSize(new Dimension(600, 400));

        table2.setSize(d);
        table2.setBounds(650, 20, 400, 300);
        scrollPane2 = new JScrollPane(table2);
        scrollPane2.setBounds(table2.getBounds());
        scrollPane2.setSize(new Dimension(400, 300));

        table3.setSize(d);
        table3.setBounds(370, 450, 400, 200);
        scrollPane3 = new JScrollPane(table3);
        scrollPane3.setBounds(table3.getBounds());
        scrollPane3.setSize(new Dimension(400, 200));

        table4.setSize(d);
        table4.setBounds(1100, 20, 800, 300);
        scrollPane4 = new JScrollPane(table4);
        scrollPane4.setBounds(table4.getBounds());
        scrollPane4.setSize(new Dimension(750, 300));

        table1.getColumnModel().getColumn(0).setPreferredWidth(200);
        table1.getColumnModel().getColumn(1).setPreferredWidth(5);
        table1.getColumnModel().getColumn(2).setPreferredWidth(15);
        table1.getColumnModel().getColumn(3).setPreferredWidth(15);
        table1.getColumnModel().getColumn(4).setPreferredWidth(15);
        table1.getColumnModel().getColumn(5).setPreferredWidth(15);
        table1.getColumnModel().getColumn(6).setPreferredWidth(5);

        table2.getColumnModel().getColumn(0).setPreferredWidth(100);
        table2.getColumnModel().getColumn(1).setPreferredWidth(50);
        table2.getColumnModel().getColumn(2).setPreferredWidth(15);

        table3.getColumnModel().getColumn(0).setPreferredWidth(70);
        table3.getColumnModel().getColumn(1).setPreferredWidth(5);
        table3.getColumnModel().getColumn(2).setPreferredWidth(15);
        table3.getColumnModel().getColumn(3).setPreferredWidth(15);
        table3.getColumnModel().getColumn(4).setPreferredWidth(15);
        table3.getColumnModel().getColumn(5).setPreferredWidth(15);
        table3.getColumnModel().getColumn(6).setPreferredWidth(5);

        table4.getColumnModel().getColumn(0).setPreferredWidth(15);
        table4.getColumnModel().getColumn(1).setPreferredWidth(5);
        table4.getColumnModel().getColumn(2).setPreferredWidth(30);
        table4.getColumnModel().getColumn(3).setPreferredWidth(200);
        table4.getColumnModel().getColumn(4).setPreferredWidth(15);


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
        b13.addActionListener(this);
        b14.addActionListener(this);
        b15.addActionListener(this);

        baseProductsMenu = new ArrayList<>();

        p = new JPanel();
        p.setLayout(null);
        p.setBounds(5, 5, 2000, 1000);
        p.add(b1);
        p.add(b2);
        p.add(b3);
        p.add(b4);
        p.add(b5);
        p.add(b6);
        p.add(b7);
        p.add(b8);
        p.add(b9);
        p.add(b10);
        p.add(b11);
        p.add(b12);
        p.add(b13);
        p.add(b14);
        p.add(b15);
        p.add(t1);
        p.add(t2);
        p.add(t3);
        p.add(t4);
        p.add(t5);
        p.add(t6);
        p.add(t7);
        p.add(t8);
        p.add(t9);
        p.add(t10);
        p.add(t11);
        p.add(t12);
        p.add(t13);
        p.add(t14);

        p.add(scrollPane);
        p.add(scrollPane2);
        p.add(scrollPane3);
        p.add(scrollPane4);

        p.add(l1);
        p.add(l2);
        /*pp.add(l3);
        p.add(l4);
        p.add(l5);
        p.add(l6);
        p.add(l7);
        p.add(l8);
        p.add(l9);
        p.add(l10);*/
        p.add(l11);
        p.add(l12);
        p.add(l13);
        p.add(l14);
        //p.add(comboBox);

        f.add(p);

        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (e.getClickCount() == 1) {
                    Object[] o = new Object[8];
                    int row = table1.getSelectedRow();
                    o[0] = table1.getValueAt(row, 0);
                    o[1] = table1.getValueAt(row, 1);
                    o[2] = table1.getValueAt(row, 2);
                    o[3] = table1.getValueAt(row, 3);
                    o[4] = table1.getValueAt(row, 4);
                    o[5] = table1.getValueAt(row, 5);
                    o[6] = table1.getValueAt(row, 6);
                    t1.setText(o[0].toString());
                    t2.setText(o[1].toString());
                    t3.setText(o[2].toString());
                    t4.setText(o[3].toString());
                    t5.setText(o[4].toString());
                    t6.setText(o[5].toString());
                    t7.setText(o[6].toString());
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

    public void addBaseproduct(BaseProduct b) {

        Object[] obj = new Object[8];
        obj[0] = b.getTitle();
        obj[1] = b.getRating();
        obj[2] = b.getCalories();
        obj[3] = b.getProteins();
        obj[4] = b.getFats();
        obj[5] = b.getSodium();
        obj[6] = b.getPrice();
        tableModel.addRow(obj);
    }

    public void addBaseproductToMenu(BaseProduct b) {

        Object[] obj = new Object[8];
        obj[0] = b.getTitle();
        obj[1] = b.getRating();
        obj[2] = b.getCalories();
        obj[3] = b.getProteins();
        obj[4] = b.getFats();
        obj[5] = b.getSodium();
        obj[6] = b.getPrice();
        tableModel3.addRow(obj);
    }

    public void addOrderToTable(Map<Order,ArrayList<String>> map1) {
        Object[] obj = new Object[8];
        StringBuilder s = new StringBuilder();
        for (Order me : map1.keySet()) {
            obj[0] = me.getOrderID();
            obj[1] = me.getClientID();
            obj[2] = me.getOrderDate();
            obj[4] = me.getFinalPrice();
            List<String> str =  map1.get(me);
            obj[3] = str;
            System.out.println(obj[0] + ", " + obj[1] + ", " + obj[2] + ", " + obj[3] + ", " + obj[4]);
            tableModel4.addRow(obj);
        }
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

@Override
    public void actionPerformed(ActionEvent e) {


        //import products
        if (e.getSource() == b1) {
            tableModel.setRowCount(0);
            deliveryService.importProducts();
            for (int i = 0; i < deliveryService.getBaseProducts().size(); i++) {
                addProductTable(i);
            }
        }

        //show products - products2.csv
        if (e.getSource() == b7) {
            tableModel.setRowCount(0);
            deliveryService.showProducts();
            for (int i = 0; i < deliveryService.getBaseProducts().size(); i++) {
                addProductTable(i);
            }
        }

        //add product
        if (e.getSource() == b3) {
            BaseProduct b = new BaseProduct();
            b.setTitle(t1.getText());
            b.setRating(Float.parseFloat(t2.getText()));
            b.setCalories(Integer.parseInt(t3.getText()));
            b.setProteins(Integer.parseInt(t4.getText()));
            b.setFats(Integer.parseInt(t5.getText()));
            b.setSodium(Integer.parseInt(t6.getText()));
            b.setPrice(Integer.parseInt(t7.getText()));

            try {
                this.deliveryService.manageProduct('a', b);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            addBaseproduct(b);
        }


        //show menu
        if (e.getSource() == b2) {
            tableModel2.setRowCount(0);
            deliveryService.showMenu();
            for (int i = 0; i < deliveryService.getCompositeProducts().size(); i++) {
                addCompositeProduct(deliveryService.getCompositeProducts().get(i));
            }
            /*editData = new ArrayList<String[]>(deliveryService.getCompositeProducts().size());
            for (int i = 0; i < deliveryService.getCompositeProducts().size(); i++) {
                String[] strings = new String[5];
                addCompositeProduct(deliveryService.getCompositeProducts().get(i));
                int j = 0;
                for(BaseProduct b: deliveryService.getCompositeProducts().get(i).getBaseProducts()) {
                    strings[j] = b.getTitle();
                    editData.add(strings);
                    comboBox = new JComboBox<String>(editData.get(i));
                    j++;
                }
                table2.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(comboBox));
        }*/
    }
        //edit product
        if (e.getSource() == b4) {

            for(BaseProduct b: this.deliveryService.getBaseProducts())
                if(t1.getText().equals(b.getTitle())) {
                    b.setTitle(t1.getText());
                    b.setRating(Float.parseFloat(t2.getText()));
                    b.setCalories(Integer.parseInt(t3.getText()));
                    b.setProteins(Integer.parseInt(t4.getText()));
                    b.setFats(Integer.parseInt(t5.getText()));
                    b.setSodium(Integer.parseInt(t6.getText()));
                    b.setPrice(Integer.parseInt(t7.getText()));

                    try {
                        deliveryService.manageProduct('m', b);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }

            tableModel.setRowCount(0);
            for (int i = 0; i < deliveryService.getBaseProducts().size(); i++) {
                addProductTable(i);
            }
        }

        //delete product
        if(e.getSource() == b5){
            for(BaseProduct b: this.deliveryService.getBaseProducts())
                if(t1.getText().equals(b.getTitle())) {
                    b.setTitle(t1.getText());
                    b.setRating(Float.parseFloat(t2.getText()));
                    b.setCalories(Integer.parseInt(t3.getText()));
                    b.setProteins(Integer.parseInt(t4.getText()));
                    b.setFats(Integer.parseInt(t5.getText()));
                    b.setSodium(Integer.parseInt(t6.getText()));
                    b.setPrice(Integer.parseInt(t7.getText()));

                    try {
                        deliveryService.manageProduct('d', b);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }

            tableModel.setRowCount(0);
            for (int i = 0; i < deliveryService.getBaseProducts().size(); i++) {
                addProductTable(i);
            }
        }

        //add product to menu

        if(e.getSource() == b8){
            //tableModel3.setRowCount(0);
            for(BaseProduct b: this.deliveryService.getBaseProducts())
                if(t1.getText().equals(b.getTitle())) {
                    addBaseproductToMenu(b);
                    baseProductsMenu.add(b);
                }
        }

        //create menu - composite product
        if(e.getSource() == b6){
            if(baseProductsMenu.isEmpty()){
                JOptionPane.showMessageDialog(null, "Menu is empty!");
            }
            else if(baseProductsMenu.size() > 4){
                JOptionPane.showMessageDialog(null, "More than 4 items for menu!");
            }
            else {
                CompositeProduct c = new CompositeProduct();

                c.setName(t8.getText());
                c.setBaseProducts(baseProductsMenu);
                c.setPrice(c.computePrice());
                //addCompositeProduct(c);
                deliveryService.addProductToMenu(c);
            }
            tableModel3.setRowCount(0);
            baseProductsMenu = new ArrayList<>();
        }

        if (e.getSource() == b10) {
            tableModel4.setRowCount(0);
            deliveryService.setMap(deliveryService.showOrders());
            addOrderToTable(deliveryService.getMap());
        }

        if(e.getSource() == b11){
            new FirstPage();
            f.setVisible(false);
        }

        //make report1
        if(e.getSource() == b12){
            deliveryService.report1(Integer.parseInt(t9.getText()), Integer.parseInt(t10.getText()));
        }

        //make report 2
        if(e.getSource() == b13){
            deliveryService.report2(Integer.parseInt(t13.getText()));
        }
        //make report 3
        if(e.getSource() == b14){
        deliveryService.report3(Integer.parseInt(t11.getText()), Integer.parseInt(t12.getText()));
        }

    //make report 4
    if(e.getSource() == b15){
        deliveryService.report4(t14.getText());
    }
    }

    public static void main(String[] args) {

        new AdministratorOperations();
    }
}


