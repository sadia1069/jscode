import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainDashboard extends JFrame {

    public MainDashboard() {
        setTitle("Travel Management System");
        setSize(400, 400);
        setLayout(new GridLayout(4, 1, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JButton addPackageBtn = new JButton("Add Package");
        JButton viewPackageBtn = new JButton("View Packages");
        JButton deletePackageBtn = new JButton("Delete Package");
        JButton exitBtn = new JButton("Exit");

        add(addPackageBtn);
        add(viewPackageBtn);
        add(deletePackageBtn);
        add(exitBtn);

        addPackageBtn.addActionListener(e -> new AddPackage());
        viewPackageBtn.addActionListener(e -> new ViewPackages());
        deletePackageBtn.addActionListener(e -> new DeletePackage());
        exitBtn.addActionListener(e -> System.exit(0));

        setVisible(true);
    }

    public static void main(String[] args) {
        new MainDashboard();
    }
}