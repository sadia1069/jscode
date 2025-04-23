import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class DeletePackage extends JFrame {
    JTextField idField;
    JButton deleteBtn;

    public DeletePackage() {
        setTitle("Delete Travel Package");
        setSize(300, 150);
        setLayout(new GridLayout(2, 2));

        add(new JLabel("Enter Package ID:"));
        idField = new JTextField();
        add(idField);

        deleteBtn = new JButton("Delete");
        add(deleteBtn);
        add(new JLabel(""));

        deleteBtn.addActionListener(e -> {
            try {
                Connection conn = DBConnection.getConnection();
                String sql = "DELETE FROM packages WHERE id=?";
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setInt(1, Integer.parseInt(idField.getText()));
                int result = pst.executeUpdate();
                if (result > 0) {
                    JOptionPane.showMessageDialog(null, "Package Deleted Successfully");
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Package ID");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new DeletePackage();
    }
}