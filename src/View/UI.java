package View;

import Model.DefaultTableModel;
import com.sun.org.apache.regexp.internal.RE;

import javax.swing.*;

public class UI extends JFrame{
    private JTabbedPane tabbedPane;

    public UI(DefaultTableModel[] models) {
        ClientsPanel clients = new ClientsPanel(models[0]);
        CarsPanel cars = new CarsPanel(models[1]);
        RentalsPanel rentals = new RentalsPanel(models[2]);
        AddRantingPanel AddRanting = new AddRantingPanel(models[0], models[1]);

        tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
        tabbedPane.add("Clients", clients);
        tabbedPane.add("Cars", cars);
        tabbedPane.add("Rentals", rentals);
        tabbedPane.add("Add Renting", AddRanting);

        this.getContentPane().add(tabbedPane);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Car rental office");
        this.setSize(1020, 500);
    }
}
