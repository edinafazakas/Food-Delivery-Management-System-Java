package Presentation;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class ClientRegistration extends JFrame implements ActionListener {

    Container container = getContentPane();
    JLabel userLabel = new JLabel("ID:");
    JLabel passwordLabel = new JLabel("PASSWORD:");
    JLabel l3 = new JLabel("NAME:");
    JLabel l4 = new JLabel("ADDRESS:");
    JTextField userTextField = new JTextField();
    JTextField t3 = new JTextField();
    JTextField t4 = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton Button = new JButton("REGISTER");
    JButton back = new JButton("BACK");


    ClientRegistration() {
        //Calling methods inside constructor.
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        Button.addActionListener(this);
        back.addActionListener(this);
    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        //Setting location and Size of each components using setBounds() method.
        userLabel.setBounds(50, 150, 100, 30);
        passwordLabel.setBounds(50, 220, 100, 30);
        l3.setBounds(50, 290, 100, 30);
        l4.setBounds(50, 360, 100, 30);
        userTextField.setBounds(150, 150, 150, 30);
        passwordField.setBounds(150, 220, 150, 30);
        t3.setBounds(150, 290, 150, 30);
        t4.setBounds(150, 360, 150, 30);
        Button.setBounds(50, 430, 100, 30);
        back.setBounds(200, 430, 100, 30);
    }

    public void addComponentsToContainer() {
        //Adding each components to the Container
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(Button);
        container.add(back);
        container.add(l3);
        container.add(l4);
        container.add(t3);
        container.add(t4);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Button){
            try {
                FileWriter myWriter = new FileWriter("user.txt", true);
                myWriter.write("client," + userTextField.getText() + "," + passwordField.getText() + "," + t3.getText() + "," + t4.getText() + "\n");
                myWriter.close();
            } catch (IOException e1) {
                System.out.println("An error occurred.");
                e1.printStackTrace();
            }
            ClientChoose frame = new ClientChoose();
            frame.setTitle("Client");
            frame.setVisible(true);
            frame.setBounds(10, 10, 360, 350);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
            this.setVisible(false);
        }

        if(e.getSource() == back){
            ClientChoose frame = new ClientChoose();
            frame.setTitle("Client");
            frame.setVisible(true);
            frame.setBounds(10, 10, 400, 350);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
            this.setVisible(false);
        }
    }


    public static void main(String[] a) {
        ClientRegistration frame = new ClientRegistration();
        frame.setTitle("Client Registration");
        frame.setVisible(true);
        frame.setBounds(10, 10, 370, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
}
