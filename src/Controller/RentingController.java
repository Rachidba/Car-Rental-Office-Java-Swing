package Controller;


import Model.*;
import View.AddRantingPanel;
import View.RentalsPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RentingController implements ActionListener {
	private DAO<Ranting> rantingDAO;
	private RentalsPanel rentalsPanel;
	private AddRantingPanel addRantingPanel;

	public RentingController(RentalsPanel rentalsPanel, AddRantingPanel addRantingPanel){
		rantingDAO = DAOFactory.getRantingDAO();
		this.rentalsPanel = rentalsPanel;
		this.addRantingPanel = addRantingPanel;

		this.rentalsPanel.getUpdateButton().addActionListener(this);
		this.rentalsPanel.getExportButton().addActionListener(this);
		this.rentalsPanel.getDeleteButton().addActionListener(this);
		this.addRantingPanel.getAddRantingButton().addActionListener(this);
	}

	public void finalize() throws Throwable {

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == this.rentalsPanel.getExportButton()){
			ExcelExporter.export(this.rentalsPanel.getModel().getTitles(), this.rentalsPanel.getModel().getData(), "Rentals.xls");
			JOptionPane.showMessageDialog (null, "Export of rentals done !","Information", JOptionPane.INFORMATION_MESSAGE);
		}else if (e.getSource() == this.rentalsPanel.getDeleteButton()) {
			int dialogResult = JOptionPane.showConfirmDialog (null, "Would You Like to Delete selected elements?","Warning", JOptionPane.WARNING_MESSAGE);
			if(dialogResult == JOptionPane.YES_OPTION){
				int[] selection = this.rentalsPanel.getTable().getSelectedRows();
				for(int i = 0; i < selection.length; i++) {
					rantingDAO.delete(
							new Ranting(
									Integer.parseInt(this.rentalsPanel.getTable().getModel().getValueAt(selection[i], 0).toString()),
									(Car)DAOFactory.getCarDAO().find(this.rentalsPanel.getTable().getModel().getValueAt(selection[i], 1).toString()),
									(Client)DAOFactory.getClientDAO().find(this.rentalsPanel.getTable().getModel().getValueAt(selection[i], 2).toString()),
									Boolean.getBoolean(this.rentalsPanel.getTable().getModel().getValueAt(selection[i], 3).toString()),
									java.sql.Date.valueOf(this.rentalsPanel.getTable().getModel().getValueAt(selection[i], 4).toString()),
									java.sql.Date.valueOf(this.rentalsPanel.getTable().getModel().getValueAt(selection[i], 5).toString())
							)
					);
					this.rentalsPanel.getModel().removeRow(selection[i]);
				}
			}
		}else if(e.getSource() == this.rentalsPanel.getUpdateButton()){
			int[] selection = this.rentalsPanel.getTable().getSelectedRows();
			if (selection.length == 1) {
				int dialogResult = JOptionPane.showConfirmDialog (null, "Would You Like to Update selected elements?","Warning", JOptionPane.WARNING_MESSAGE);
				if(dialogResult == JOptionPane.YES_OPTION){
					String msg;
					String newValue;
					Boolean newIsReturned;
					if(this.rentalsPanel.getTable().getModel().getValueAt(selection[0], 3).toString() == "YES"){

						msg = "This car is already returned!\nWould you like to set it to \"NOT RETURNED\"?";
						newValue = "NO";
						newIsReturned = false;
					}
					else{
						msg = "This car isn't returned!\nWould you like to set it to \"RETURNED\"?";
						newValue = "YES";
						newIsReturned = true;
					}
					int dialogR = JOptionPane.showConfirmDialog (null, msg,"Warning", JOptionPane.WARNING_MESSAGE);
					if(dialogR == JOptionPane.YES_OPTION){
						this.rantingDAO.update(
								new Ranting(
										Integer.parseInt(this.rentalsPanel.getTable().getModel().getValueAt(selection[0], 0).toString()),
										(Car)DAOFactory.getCarDAO().find(this.rentalsPanel.getTable().getModel().getValueAt(selection[0], 1).toString()),
										(Client)DAOFactory.getClientDAO().find(this.rentalsPanel.getTable().getModel().getValueAt(selection[0], 2).toString()),
										newIsReturned,
										java.sql.Date.valueOf(this.rentalsPanel.getTable().getModel().getValueAt(selection[0], 4).toString()),
										java.sql.Date.valueOf(this.rentalsPanel.getTable().getModel().getValueAt(selection[0], 5).toString())
								)
						);
						this.rentalsPanel.getTable().getModel().setValueAt(newValue, selection[0], 3);
						JOptionPane.showMessageDialog (null, "The modification is done !","Information", JOptionPane.INFORMATION_MESSAGE);

					}
				}
			} else {
				JOptionPane.showMessageDialog (null, "You have to choose just one row!","Error", JOptionPane.ERROR_MESSAGE);
			}
		}else if(e.getSource() == this.addRantingPanel.getAddRantingButton()){
			String[] str = {
					"0",
					this.addRantingPanel.getSelectedCar().getText(),
					this.addRantingPanel.getSelectedClient().getText(),
							"NO",
					this.addRantingPanel.getRentalDateField().getText(),
					this.addRantingPanel.getReturnDateField().getText()
			};
			this.addRantingPanel.getSelectedClient().setText("");
			this.addRantingPanel.getSelectedCar().setText("");
			this.addRantingPanel.getRentalDateField().setText("");
			this.addRantingPanel.getReturnDateField().setText("");
			this.rentalsPanel.getModel().addRow(str);
		}
	}
}