package Controller;


import Model.*;
import View.RentalsPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RentingController implements ActionListener {
	private DAO<Ranting> rantingDAO;
	private RentalsPanel rentalsPanel;

	public RentingController(RentalsPanel rentalsPanel){
		rantingDAO = DAOFactory.getRantingDAO();
		this.rentalsPanel = rentalsPanel;

		//this.rentalsPanel.getAddButton().addActionListener(this);
		this.rentalsPanel.getExportButton().addActionListener(this);
	}

	public void finalize() throws Throwable {

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}