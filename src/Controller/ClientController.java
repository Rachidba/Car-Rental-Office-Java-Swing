package Controller;

import Model.Client;
import Model.ClientTableModel;
import Model.DAO;
import Model.DAOFactory;
import View.ClientsPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientController implements ActionListener {
	private ClientsPanel clientsPanel;
	private DAO<Client> clientDAO;

	public ClientController(ClientsPanel clientsPanel){
		this.clientDAO = DAOFactory.getClientDAO();
		this.clientsPanel = clientsPanel;
		this.clientsPanel.getAddButton().addActionListener(this);
		this.clientsPanel.getResetButton().addActionListener(this);
	}

	public void finalize() throws Throwable {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.clientsPanel.getAddButton()){
			//create a new client from field with dao
			this.clientDAO.create(new Client( this.clientsPanel.getCinField().getText(),
					this.clientsPanel.getFnameField().getText(),
					this.clientsPanel.getLnameField().getText()));
		}
		else{
			// 3awtani ma3reftch :/
		}
	}
}