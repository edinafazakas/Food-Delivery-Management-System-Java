package Presentation;
import javax.swing.*;
import java.awt.*;

public class EmployeeNotification {

    String message = "You got a new notification message. A new order has been performed.";
    String header = "Employee got a new notification of a new order";

    EmployeeNotification() {

    JFrame frame = new JFrame("Notification");
    frame.setSize(400,155);
    frame.setLayout(new GridBagLayout());
    GridBagConstraints constraints = new GridBagConstraints();
    constraints.gridx =0;
    constraints.gridy =0;
    constraints.weightx =1.0f;
    constraints.weighty =1.0f;
    constraints.insets =new

    Insets(5,5,5,5);

    constraints.fill =GridBagConstraints.BOTH;
    JLabel headingLabel = new JLabel(header);
        //headingLabel.setIcon(headingIcon); // --- use image icon you want to be as heading image.
        headingLabel.setOpaque(false);
        frame.add(headingLabel,constraints);
    constraints.gridx++;
    constraints.weightx =0f;
    constraints.weighty =0f;
    constraints.fill =GridBagConstraints.NONE;
    constraints.anchor =GridBagConstraints.NORTH;
    JButton cloesButton = new JButton("X");
        cloesButton.setMargin(new

    Insets(1,4,1,4));
        cloesButton.setFocusable(false);
        frame.add(cloesButton,constraints);
    constraints.gridx =0;
    constraints.gridy++;
    constraints.weightx =1.0f;
    constraints.weighty =1.0f;
    constraints.insets =new

    Insets(5,5,5,5);

    constraints.fill =GridBagConstraints.BOTH;
    JLabel messageLabel = new JLabel("<HtMl>" + message);
        frame.add(messageLabel,constraints);
        //frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
}

    public static void main(String[] args) {
        new EmployeeNotification();
    }
}