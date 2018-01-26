package Controller;

import Model.*;
import View.CarsPanel;

import javax.swing.*;
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
		this.carsPanel.getExportButton().addActionListener(this);
		this.carsPanel.getUpdateButton().addActionListener(this);
		this.carsPanel.getDeleteButton().addActionListener(this);
	}

	public void finalize() throws Throwable {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.carsPanel.getAddButton()) {
			if (!this.carsPanel.getNumField().getText().equals("")
					&& !this.carsPanel.getModelField().getText().equals("")
					&& !this.carsPanel.getBrandField().getText().equals("")
					&& !this.carsPanel.getPriceField().getText().equals("")) {
				//create a new car from field with dao
				Car car = new Car( this.carsPanel.getNumField().getText(),
						this.carsPanel.getModelField().getText(),
						this.carsPanel.getBrandField().getText(),
						Double.parseDouble(this.carsPanel.getPriceField().getText()));
				String[] str = {
						this.carsPanel.getNumField().getText(),
						this.carsPanel.getModelField().getText(),
						this.carsPanel.getBrandField().getText(),
						this.carsPanel.getPriceField().getText()
				};

				if(this.carsPanel.getAddButton().getText().equals("Modify")) {
					this.carDAO.update(car);
					int i = this.carsPanel.getTable().getSelectedRow();

					this.carsPanel.getModel().setRow(i, str);

					this.carsPanel.getAddButton().setText("Add");
					this.carsPanel.getNumField().setEnabled(true);
					JOptionPane.showMessageDialog (null, "This car has been updated !","Information", JOptionPane.INFORMATION_MESSAGE);
				} else {
					this.carDAO.create(car);
					this.carsPanel.getModel().addRow(str);
					JOptionPane.showMessageDialog (null, "This car has been added !","Information", JOptionPane.INFORMATION_MESSAGE);
				}
				this.carsPanel.getNumField().setText("");
				this.carsPanel.getModelField().setText("");
				this.carsPanel.getBrandField().setText("");
				this.carsPanel.getPriceField().setText("");
			} else {
				JOptionPane.showMessageDialog (null, "There is an empty field!","Error", JOptionPane.ERROR_MESSAGE);
			}

		} else if (e.getSource() == this.carsPanel.getExportButton()){
			ExcelExporter.export(this.carsPanel.getModel().getTitles(), this.carsPanel.getModel().getData(), "Cars.xls");
			JOptionPane.showMessageDialog (null, "Export of cars done !?","Information", JOptionPane.INFORMATION_MESSAGE);

		} else if (e.getSource() == this.carsPanel.getResetButton()) {
			this.carsPanel.getNumField().setText("");
			this.carsPanel.getModelField().setText("");
			this.carsPanel.getBrandField().setText("");
			this.carsPanel.getPriceField().setText("");
			this.carsPanel.getNumField().setEnabled(true);
		}else if (e.getSource() == this.carsPanel.getDeleteButton()) {
			int dialogResult = JOptionPane.showConfirmDialog (null, "Would You Like to Delete selected elements?","Warning", JOptionPane.WARNING_MESSAGE);
			if(dialogResult == JOptionPane.YES_OPTION){
				int[] selection = this.carsPanel.getTable().getSelectedRows();
				for(int i = 0; i < selection.length; i++) {
					carDAO.delete(new Car(this.carsPanel.getTable().getModel().getValueAt(selection[i], 0).toString(),
							this.carsPanel.getTable().getModel().getValueAt(selection[i], 1).toString(),
							this.carsPanel.getTable().getModel().getValueAt(selection[i], 2).toString(),
							Double.parseDouble(this.carsPanel.getTable().getModel().getValueAt(selection[i], 3).toString())));
					this.carsPanel.getModel().removeRow(selection[i]);
				}
			}
		} else if (e.getSource() == this.carsPanel.getUpdateButton()) {
			int[] selection = this.carsPanel.getTable().getSelectedRows();
			if (selection.length == 1) {
				int dialogResult = JOptionPane.showConfirmDialog (null, "Would You Like to Update selected elements?","Warning", JOptionPane.WARNING_MESSAGE);
				if(dialogResult == JOptionPane.YES_OPTION){
					this.carsPanel.getNumField().setEnabled(false);
					this.carsPanel.getNumField().setText(this.carsPanel.getTable().getModel().getValueAt(selection[0], 0).toString());
					this.carsPanel.getModelField().setText(this.carsPanel.getTable().getModel().getValueAt(selection[0], 1).toString());
					this.carsPanel.getBrandField().setText(this.carsPanel.getTable().getModel().getValueAt(selection[0], 2).toString());
					this.carsPanel.getPriceField().setText(this.carsPanel.getTable().getModel().getValueAt(selection[0], 3).toString());
					this.carsPanel.getAddButton().setText("Modify");
				}
			} else {
				JOptionPane.showMessageDialog (null, "You have to choose just one row!","Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}