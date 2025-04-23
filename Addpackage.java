import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AddPackage extends JFrame {
    JTextField destinationField, priceField, daysField, transportField, hotelField;
    JButton addBtn;

    public AddPackage() {
        setTitle("Add Travel Package");
        setSize(350, 300);
        setLayout(new GridLayout(6, 2));

        add(new JLabel("Destination:")); destinationField = new JTextField(); add(destinationField);
        add(new JLabel("Price:")); priceField = new JTextField(); add(priceField);
        add(new JLabel("Days:")); daysField = new JTextField(); add(daysField);
        add(new JLabel("Transport:")); transportField = new JTextField(); add(transportField);
        add(new JLabel("Hotel:")); hotelField = new JTextField(); add(hotelField);

        addBtn = new JButton("Add Package");
        add(addBtn);
        add(new JLabel(""));

        addBtn.addActionListener(e -> {
            try {
                Connection conn = DBConnection.getConnection();
                String sql = "INSERT INTO packages(destination, price, days, transport, hotel) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, destinationField.getText());
                pst.setString(2, priceField.getText());
                pst.setString(3, daysField.getText());
                pst.setString(4, transportField.getText());
                pst.setString(5, hotelField.getText());
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Package Added Successfully");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new AddPackage();
    }
}