package Presentation;
import BusinessLogic.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EmployeeOperations implements ActionListener {
    private JFrame f;
    private JTable table4;
    private JPanel p;
    private JButton b10, b11;
    DeliveryService deliveryService;
    DefaultTableModel tableModel4;
    JScrollPane scrollPane4;
    JComboBox<String> comboBox;
    TableColumn col;
    List<String[]> editData;
    ArrayList<BaseProduct> baseProductsMenu;
    ArrayList<CompositeProduct> compositeProducts;

    public EmployeeOperations() {

        deliveryService = new DeliveryService();
        deliveryService.setBaseProducts(new ArrayList<>());
        deliveryService.importProducts();

        f = new JFrame("Employee operations");
        f.validate();
        f.setSize(2000, 1000);
        f.setVisible(true);
        f.setLayout(null);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);


        b10 = new JButton("SHOW ORDERS");
        b11 = new JButton("BACK");
        b10.setBounds(1400, 800, 150, 50);
        b11.setBounds(1600, 800, 150, 50);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String[] columnNames3 = {"OrderID", "ClientID", "OrderDate", "MenuItems", "TotalPrice"};

        tableModel4 = new DefaultTableModel(columnNames3, 0);
        tableModel4.setColumnIdentifiers(columnNames3);
        table4 = new JTable(tableModel4);


        Dimension d = new Dimension(1800, 700);
        table4.setSize(d);
        table4.setBounds(50, 10, 1800, 700);
        scrollPane4 = new JScrollPane(table4);
        scrollPane4.setBounds(table4.getBounds());
        scrollPane4.setSize(new Dimension(1800, 700));

        table4.getColumnModel().getColumn(0).setPreferredWidth(15);
        table4.getColumnModel().getColumn(1).setPreferredWidth(5);
        table4.getColumnModel().getColumn(2).setPreferredWidth(30);
        table4.getColumnModel().getColumn(3).setPreferredWidth(200);
        table4.getColumnModel().getColumn(4).setPreferredWidth(15);

        b10.addActionListener(this);
        b11.addActionListener(this);

        baseProductsMenu = new ArrayList<>();
        p = new JPanel();
        p.setLayout(null);
        p.setBounds(5, 5, 2000, 1000);
        p.add(b10);
        p.add(b11);
        p.add(scrollPane4);
        f.add(p);
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

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b10) {
            tableModel4.setRowCount(0);
            deliveryService.setMap(deliveryService.showOrders());
            addOrderToTable(deliveryService.getMap());
        }

        if (e.getSource() == b11) {
            new FirstPage();
            f.setVisible(false);
        }

    }

    public static void main(String[] args) {

        new EmployeeOperations();
    }
}


