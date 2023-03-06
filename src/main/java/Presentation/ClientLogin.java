package Presentation;
import BusinessLogic.DeliveryService;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class ClientLogin extends JFrame implements ActionListener{
    Container container = getContentPane();
    JLabel userLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("LOGIN");
    JButton resetButton = new JButton("RESET");
    JCheckBox showPassword = new JCheckBox("Show Password");
    DeliveryService d;
    JButton back = new JButton("BACK");


    public ClientLogin() {
        //Calling methods inside constructor.
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        //Setting location and Size of each components using setBounds() method.
        userLabel.setBounds(50, 150, 100, 30);
        passwordLabel.setBounds(50, 220, 100, 30);
        userTextField.setBounds(150, 150, 150, 30);
        passwordField.setBounds(150, 220, 150, 30);
        showPassword.setBounds(150, 250, 150, 30);
        loginButton.setBounds(50, 300, 100, 30);
        resetButton.setBounds(200, 300, 100, 30);
        back.setBounds(200, 400, 100, 30);
    }

    public void addComponentsToContainer() {
        //Adding each components to the Container
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(loginButton);
        container.add(resetButton);
        container.add(back);
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
        back.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Client c = new Client();
        if(e.getSource() == loginButton) {
            int ok = 0;
            try {
                File file = new File("user.txt");
                FileReader fr = new FileReader(file);
                String delimiter = ",";
                BufferedReader br = new BufferedReader(fr);
                String line = " ";
                String[] tempArr;
                if ((line = br.readLine()) != null) {
                }
                while ((line = br.readLine()) != null) {
                    tempArr = line.split(delimiter);
                    if (tempArr[0].equals("client")) {
                        if (passwordField.getText().equals(tempArr[2])) {
                            JOptionPane.showMessageDialog(null, "Login success, " + userTextField.getText() + "!");
                            this.setVisible(false);
                            d = new DeliveryService();
                            d.setC(userTextField.getText());
                            ok = 1;
                            break;
                        }
                    }
                }
                br.close();
            }
        catch(IOException ioe) {
            ioe.printStackTrace();
        }
            if(ok == 0)
            JOptionPane.showMessageDialog(null, "Invalid password or username!");
            else {
                try {
                    FileWriter myWriter = new FileWriter("currentClient.txt");
                    myWriter.write(userTextField.getText() + "\n");
                    myWriter.close();
                } catch (IOException e1) {
                    System.out.println("An error occurred.");
                    e1.printStackTrace();
                }
                new ClientOperations();
            }
        }

        if(e.getSource() == resetButton) {
            passwordField.setText("");
            userTextField.setText("");
        }

        if(e.getSource() == back) {
            ClientChoose frame = new ClientChoose();
            frame.setTitle("Client");
            frame.setVisible(true);
            frame.setBounds(10, 10, 360, 400);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
            this.setVisible(false);;
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        ClientLogin frame = new ClientLogin();
        frame.setTitle("Client Login Form");
        frame.setVisible(true);
        frame.setBounds(10, 10, 370, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

    }
}
