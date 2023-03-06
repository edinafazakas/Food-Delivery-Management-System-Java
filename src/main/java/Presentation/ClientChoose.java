package Presentation;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientChoose extends JFrame implements ActionListener {
    Container container = getContentPane();
    JButton b1;
    JButton b2, b3;
    public ClientChoose() {
        b1 = new JButton("LOGIN");
        b2 = new JButton("REGISTER");
        b3 = new JButton("BACK");
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        //Setting location and Size of each components using setBounds() method.
        b1.setBounds(110, 70, 100, 50);
        b2.setBounds(110, 150, 100, 50);
        b3.setBounds(110, 230, 100, 50);
    }

    public void addComponentsToContainer() {
        //Adding each components to the Container
        container.add(b1);
        container.add(b2);
        container.add(b3);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1) {
            ClientLogin frame = new ClientLogin();
            frame.setTitle("Client Login Form");
            frame.setVisible(true);
            frame.setBounds(10, 10, 370, 600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
            this.setVisible(false);
        }
        if(e.getSource() == b2) {
            ClientRegistration frame = new ClientRegistration();
            frame.setTitle("Client Registration");
            frame.setVisible(true);
            frame.setBounds(10, 10, 370, 600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
            this.setVisible(false);
        }
        if(e.getSource() == b3){
            new FirstPage();
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        ClientChoose frame = new ClientChoose();
        frame.setTitle("Client");
        frame.setVisible(true);
        frame.setBounds(10, 10, 360, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
}
