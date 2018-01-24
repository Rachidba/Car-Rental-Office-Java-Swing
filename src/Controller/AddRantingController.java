package Controller;

import Model.DAO;
import Model.DAOFactory;
import Model.Ranting;
import View.AddRantingPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRantingController implements ActionListener {
    AddRantingPanel rantingPanel;
    private DAO<Ranting> rantingDAO;
    public AddRantingController(AddRantingPanel rantingPanel){
        this.rantingPanel = rantingPanel;
        this.rantingDAO = DAOFactory.getRantingDAO();
        /*this.rantingPanel.getAddButton().addActionListener(this);
        this.rantingPanel.getAddButton().addActionListener(this);*/
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       /* if(e.getSource() == this.rentalsPanel.getAddButton()){
			this.rantingDAO.create(new Ranting(,
									,
									false,
									this.rentalsPanel.get))

        }*/
    }
}
