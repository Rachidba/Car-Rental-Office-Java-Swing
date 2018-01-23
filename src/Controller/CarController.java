package Controller;

import Model.Car;
import Model.DAO;
import Model.DAOFactory;
import View.CarsPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarController implements ActionListener{
	CarsPanel carsPanel;
	DAO<Car> carDAO;

	public CarController(CarsPanel carsPanel){
		this.carsPanel = carsPanel;
		carDAO = DAOFactory.getCarDAO();
		this.carsPanel.getAddButton().addActionListener(this);
		this.carsPanel.getResetButton().addActionListener(this);
	}

	public void finalize() throws Throwable {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.carsPanel.getAddButton()) {
			// code
		} else if (e.getSource() == this.carsPanel.getResetButton()) {
			//code
		}
	}
}