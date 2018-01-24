import Controller.CarController;
import Controller.ClientController;
import Model.*;

import java.awt.*;
import java.sql.*;


import View.*;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainClass {
    public static void main(String[] args) {
        ClientsPanel clientsPanel = new ClientsPanel();
        CarsPanel carsPanel = new CarsPanel();
        RentalsPanel rentalsPanel = new RentalsPanel();
        AddRantingPanel addRantingPanel = new AddRantingPanel();
        HomePanel home = new HomePanel();
        UI ui = new UI(clientsPanel, carsPanel, rentalsPanel, addRantingPanel, home);

        ClientController clientController = new ClientController(clientsPanel);
        CarController carController = new CarController(carsPanel);

        ui.setVisible(true);
        Dimension actualSize = ui.getContentPane().getSize();

        int extraW = actualSize.width;
        int extraH = actualSize.height;
        System.out.println(extraH+"+"+ extraW);
    }
}
