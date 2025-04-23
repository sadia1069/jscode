import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class ViewPackages extends JFrame {
    JTable table;
    DefaultTableModel model;

    public ViewPackages() {
        setTitle("View Travel Packages");
        setSize(600, 400);
        setLayout(new BorderLayout());

        model = new DefaultTableModel();
        table = new JTable(model);
        model.addColumn("ID");
        model.addColumn("Destination");
        model.addColumn("Price");
        model.addColumn("Days");
        model.addColumn("Transport");
        model.addColumn("Hotel");

        loadPackages();

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    private void loadPackages() {
        try {
            Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM packages");

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getString("destination"),
                    rs.getString("price"),
                    rs.getString("days"),
                    rs.getString("transport"),
                    rs.getString("hotel")
                });
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ViewPackages();
    }
}