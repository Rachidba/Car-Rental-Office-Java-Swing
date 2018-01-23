package Controller;

import Model.Client;
import Model.DAO;
import Model.DAOFactory;
import View.ClientsPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientController implements ActionListener {
	ClientsPanel clientsPanel;
	DAO<Client> clientDAO;

	public ClientController(ClientsPanel clientsPanel){
		this.clientDAO = DAOFactory.getClientDAO();
		this.clientsPanel = clientsPanel;
	}

	public void finalize() throws Throwable {

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}