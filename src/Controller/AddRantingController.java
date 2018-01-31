package Controller;

import Model.*;
import View.AddRantingPanel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Observable;

public class AddRantingController implements ActionListener {
    AddRantingPanel rantingPanel;
    private DAO<Ranting> rantingDAO;
    public AddRantingController(final AddRantingPanel rantingPanel){
        this.rantingPanel = rantingPanel;
        this.rantingDAO = DAOFactory.getRantingDAO();

        this.rantingPanel.getCarSearchButton().addActionListener(this);
        this.rantingPanel.getClientSearchButton().addActionListener(this);
        this.rantingPanel.getAddRantingButton().addActionListener(this);
        this.rantingPanel.getResetRantingButton().addActionListener(this);


        final ListSelectionModel lsm = this.rantingPanel.getClientsTable().getSelectionModel();
        lsm.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(! lsm.isSelectionEmpty()) {
                    int selectedRow = lsm.getMinSelectionIndex();
                    //System.out.println(selectedRow);
                    rantingPanel.getSelectedClient().setText(rantingPanel.getClientsTable().getValueAt(selectedRow, 0).toString());
                }
            }
        });

        final ListSelectionModel lsm2 = this.rantingPanel.getCarsTable().getSelectionModel();
        lsm2.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(! lsm2.isSelectionEmpty()) {
                    int selectedRow = lsm2.getMinSelectionIndex();
                    //System.out.println(selectedRow);
                    rantingPanel.getSelectedCar().setText(rantingPanel.getCarsTable().getValueAt(selectedRow, 0).toString());
                }
            }
        });

    }
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == this.rantingPanel.getClientSearchButton()){
			if (this.rantingPanel.getCinField().getText().equals("")
                    && this.rantingPanel.getFnameField().getText().equals("")
                    && this.rantingPanel.getLnameField().getText().equals("")) {
                this.rantingPanel.getClientModel().initData();
			    //int dialogResult = JOptionPane.showConfirmDialog (null, "You have to enter a value to search!","Warning", JOptionPane.DEFAULT_OPTION);
            } else {
                ClientCriterionInter criterionInter = new ClientCriterionInter();
                if (!this.rantingPanel.getCinField().getText().equals("")) {
                    criterionInter.addCriterion(new CINCriterion(this.rantingPanel.getCinField().getText()));
                }
                if(!this.rantingPanel.getFnameField().getText().equals("")) {
                    criterionInter.addCriterion(new FnameCriterion(this.rantingPanel.getFnameField().getText()));
                }
                if(!this.rantingPanel.getLnameField().getText().equals("")) {
                    criterionInter.addCriterion(new LnameCriterion(this.rantingPanel.getLnameField().getText()));
                }
                ClientDAO clientDAO = new ClientDAO(SingletonConnection.getInstance());
                this.rantingPanel.getClientModel().loadData(clientDAO.search(criterionInter));
            }
       } else if (e.getSource() == this.rantingPanel.getCarSearchButton()) {
           if (this.rantingPanel.getNumField().getText().equals("")
                   && this.rantingPanel.getModelField().getText().equals("")
                   && this.rantingPanel.getBrandField().getText().equals("")
                   && this.rantingPanel.getPriceField().getText().equals(""))
           {
               this.rantingPanel.getCarModel().initData();
               //int dialogResult = JOptionPane.showConfirmDialog (null, "You have to enter a value to search!","Warning", JOptionPane.DEFAULT_OPTION);
           } else {
               CarCriterionInter criterionInter = new CarCriterionInter();
               if (!this.rantingPanel.getNumField().getText().equals("")) {
                   criterionInter.addCriterion(new RegistrationNumberCriterion(this.rantingPanel.getNumField().getText()));
               }
               if (!this.rantingPanel.getModelField().getText().equals("")) {
                   criterionInter.addCriterion(new ModeleCriterion(this.rantingPanel.getModelField().getText()));
               }
               if (!this.rantingPanel.getBrandField().getText().equals("")) {
                   criterionInter.addCriterion(new BrandCriterion(this.rantingPanel.getBrandField().getText()));
               }
               if(!this.rantingPanel.getPriceField().getText().equals("")) {
                   criterionInter.addCriterion(new PriceCriterion(Double.parseDouble(this.rantingPanel.getPriceField().getText())));
               }
               CarDAO carDAO = new CarDAO(SingletonConnection.getInstance());
               this.rantingPanel.getCarModel().loadData(carDAO.search(criterionInter));
           }
       } if (e.getSource() == this.rantingPanel.getAddRantingButton()) {
           if(
               !this.rantingPanel.getSelectedCar().getText().equals("") &&
               !this.rantingPanel.getSelectedClient().getText().equals("") &&
               !this.rantingPanel.getRentalDateField().getText().equals("") &&
               !this.rantingPanel.getReturnDateField().getText().equals("")
               ){
               rantingDAO.create(new Ranting(0,
                       new Car(this.rantingPanel.getSelectedCar().getText(), "", "", 0.0),
                       new Client(this.rantingPanel.getSelectedClient().getText(), "", ""),
                       false,
                       java.sql.Date.valueOf(this.rantingPanel.getRentalDateField().getText()),
                       java.sql.Date.valueOf(this.rantingPanel.getReturnDateField().getText())
               ));
               this.rantingPanel.getClientModel().removeRow(this.rantingPanel.getClientsTable().getSelectedRow());
               this.rantingPanel.getCarModel().removeRow(this.rantingPanel.getCarsTable().getSelectedRow());
               JOptionPane.showMessageDialog (null, "This renting has been added !","Information", JOptionPane.INFORMATION_MESSAGE);

           }else {
               JOptionPane.showMessageDialog (null, "There is an empty field!","Error", JOptionPane.ERROR_MESSAGE);
           }

        } if (e.getSource() == this.rantingPanel.getResetRantingButton()) {
           this.rantingPanel.getSelectedClient().setText("");
           this.rantingPanel.getSelectedCar().setText("");
           this.rantingPanel.getRentalDateField().setText("");
           this.rantingPanel.getReturnDateField().setText("");

           this.rantingPanel.getNumField().setText("");
           this.rantingPanel.getModelField().setText("");
           this.rantingPanel.getBrandField().setText("");
           this.rantingPanel.getPriceField().setText("");

           this.rantingPanel.getCinField().setText("");
           this.rantingPanel.getLnameField().setText("");
           this.rantingPanel.getFnameField().setText("");
        }

    }
}
