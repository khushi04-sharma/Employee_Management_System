package employee.management.system;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame {

    public Splash() {
        // Load image safely
        java.net.URL imgUrl = getClass().getResource("/icons/front.gif"); // leading slash important
        if (imgUrl == null) {
            return; // exit constructor
        }

        ImageIcon i1 = new ImageIcon(imgUrl);
        Image i2 = i1.getImage().getScaledInstance(1170, 650, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1170, 650);
        add(image);

        setSize(1170, 650);
        setLocation(200, 50);
        setLayout(null);
        setVisible(true);

        try {
            Thread.sleep(3000); // show splash for 5 seconds
            setVisible(false);
            new Login(); // open your login window
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Splash();
    }
}
