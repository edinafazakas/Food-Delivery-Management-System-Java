package Presentation;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FirstPage implements ActionListener{
      JPanel contentPane;
      JFrame f;

    public FirstPage() {

        f = new JFrame("Delivery system");
        f.setSize(1000, 800);
        f.setLayout(new FlowLayout(FlowLayout.CENTER, 2000, 200));
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        f.setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton b1 = new JButton("Administrator");
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AdministratorLogin frame = new AdministratorLogin();
                frame.setTitle("Administrator Login Form");
                frame.setVisible(true);
                frame.setBounds(10, 10, 370, 600);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setResizable(false);
                f.setVisible(false);
            }
        });
        b1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        b1.setBounds(300, 200, 347, 51);
        contentPane.add(b1);

        JButton b2 = new JButton("Client");
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ClientChoose frame = new ClientChoose();
                frame.setTitle("Client");
                frame.setVisible(true);
                frame.setBounds(10, 10, 360, 400);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setResizable(false);
                f.setVisible(false);
            }
        });
        b2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        b2.setBounds(300, 300, 347, 51);
        contentPane.add(b2);

        JButton b3 = new JButton("Employee");
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new EmployeeOperations();
            }
        });
        b3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        b3.setBounds(300, 400, 347, 51);
        contentPane.add(b3);


        JLabel l1 = new JLabel("FOOD DELIVERY SYSTEM");
        //l1.setFont(new Font("Segoe UI Black", Font.PLAIN, 25));
        //l1.setForeground(new Color(0, 102, 153));
        l1.setBounds(400, 10, 350, 80);
        contentPane.add(l1);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

