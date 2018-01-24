import Controller.CarController;
import Controller.ClientController;

import View.*;

public class MainClass {
    public static void main(String[] args) {
        ClientsPanel clientsPanel = new ClientsPanel();
        CarsPanel carsPanel = new CarsPanel();
        RentalsPanel rentalsPanel = new RentalsPanel();
        AddRantingPanel addRantingPanel = new AddRantingPanel();

        UI ui = new UI(clientsPanel, carsPanel, rentalsPanel, addRantingPanel);

        ClientController clientController = new ClientController(clientsPanel);
        CarController carController = new CarController(carsPanel);

        ui.setVisible(true);
    }
}
