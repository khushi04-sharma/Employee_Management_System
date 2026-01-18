package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main_class extends JFrame implements ActionListener {

    JButton addBtn, viewBtn, removeBtn;

    public Main_class() {

        setSize(1120, 630);
        setLocation(250, 100);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel img = new JLabel(i3);
        img.setBounds(0, 0, 1120, 630);
        img.setLayout(null);   
        add(img);

        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(340, 155, 400, 40);
        heading.setFont(new Font("Raleway", Font.BOLD, 25));
        img.add(heading);

        addBtn = new JButton("Add Employee");
        addBtn.setBounds(335, 270, 150, 40);
        addBtn.addActionListener(this);
        img.add(addBtn);

        viewBtn = new JButton("View Employee");
        viewBtn.setBounds(565, 270, 150, 40);
        viewBtn.addActionListener(this);
        img.add(viewBtn);

        removeBtn = new JButton("Remove Employee");
        removeBtn.setBounds(440, 370, 150, 40);
        removeBtn.addActionListener(this);
        img.add(removeBtn);

        setVisible(true);
    }

    @Override
public void actionPerformed(ActionEvent e) {


    if (e.getSource() == addBtn) {
        new AddEmployee();
        setVisible(false);
    }
    if (e.getSource() == viewBtn) {
        new View_Employee();
        dispose();
    }

    if (e.getSource() == removeBtn) {
        new RemoveEmployee();
        dispose();
    }
}


    public static void main(String[] args) {
        new Main_class();
    }
}
