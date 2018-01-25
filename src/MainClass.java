import Controller.AddRantingController;
import Controller.CarController;
import Controller.ClientController;
import Model.*;

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
        AddRantingController addRantingPanel1 = new AddRantingController(addRantingPanel);

        ui.setVisible(true);
    }
}
