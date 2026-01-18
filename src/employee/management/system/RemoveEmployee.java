package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class RemoveEmployee extends JFrame implements ActionListener {

    JComboBox<String> choiceEMPID;
    JButton delete, back;
    JLabel textName, textPhone, textEmail;

    public RemoveEmployee() {

        setSize(1000, 400);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel label = new JLabel("Employee ID");
        label.setBounds(50, 50, 120, 30);
        label.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(label);

        choiceEMPID = new JComboBox<>();
        choiceEMPID.setBounds(200, 50, 150, 30);
        add(choiceEMPID);

        try {
            conn c = new conn();
            ResultSet rs = c.statement.executeQuery("select empId from employee");
            while (rs.next()) {
                choiceEMPID.addItem(rs.getString("empId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel labelName = new JLabel("Name");
        labelName.setBounds(50, 100, 100, 30);
        add(labelName);

        textName = new JLabel();
        textName.setBounds(200, 100, 200, 30);
        add(textName);

        JLabel labelPhone = new JLabel("Phone");
        labelPhone.setBounds(50, 150, 100, 30);
        add(labelPhone);

        textPhone = new JLabel();
        textPhone.setBounds(200, 150, 200, 30);
        add(textPhone);

        JLabel labelEmail = new JLabel("Email");
        labelEmail.setBounds(50, 200, 100, 30);
        add(labelEmail);

        textEmail = new JLabel();
        textEmail.setBounds(200, 200, 200, 30);
        add(textEmail);

        choiceEMPID.addActionListener(e -> loadEmployee());

        delete = new JButton("Delete");
        delete.setBounds(80, 300, 120, 30);
        delete.addActionListener(this);
        add(delete);

        back = new JButton("Back");
        back.setBounds(240, 300, 120, 30);
        back.addActionListener(this);
        add(back);

        setVisible(true);
        loadEmployee();
    }

    private void loadEmployee() {
        try {
            conn c = new conn();
            ResultSet rs = c.statement.executeQuery(
                "select * from employee where empId = '" + choiceEMPID.getSelectedItem() + "'"
            );
            if (rs.next()) {
                textName.setText(rs.getString("name"));
                textPhone.setText(rs.getString("phone"));
                textEmail.setText(rs.getString("email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == delete) {
            try {
                conn c = new conn();
                c.statement.executeUpdate(
                    "delete from employee where empId = '" + choiceEMPID.getSelectedItem() + "'"
                );
                JOptionPane.showMessageDialog(this, "Employee Deleted Successfully");
                setVisible(false);
                new Main_class();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        if (e.getSource() == back) {
            setVisible(false);
            new Main_class();
        }
    }

    public static void main(String[] args) {
        new RemoveEmployee();
    }
}
