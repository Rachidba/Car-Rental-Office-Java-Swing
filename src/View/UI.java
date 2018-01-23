package View;

import javax.swing.*;

public class UI extends JFrame{
    private JTabbedPane tabbedPane;

    public UI(ClientsPanel clients, CarsPanel cars, RentalsPanel rentals, AddRantingPanel AddRanting) {
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
