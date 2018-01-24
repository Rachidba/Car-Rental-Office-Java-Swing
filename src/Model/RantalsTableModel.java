package Model;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import java.util.Vector;

public class RantalsTableModel extends AbstractTableModel {
    private String[] titles = {"Car's Num", "Client CIN", "Rental Date", "Return Date"};
    private Object[][] data ;
    List<Ranting> rentals;
    public RantalsTableModel() {

        rentals = DAOFactory.getRantingDAO().all();
        this.loadData();
    }


    public void loadData() {
        int i=0;
        this.data = new Object[rentals.size()][4];
        for(Ranting c:rentals) {
            data[i][0] = c.getCar().getRegistrationNumber();
            data[i][1] = c.getClient().getCIN();
            data[i][2] = c.getRentalDate().toString();
            data[i][3] = c.getReturnDate().toString();
            i++;
        }

        fireTableChanged(null);
    }

    public int getRowCount() {
        return this.data.length;
    }

    public int getColumnCount() {
        return this.titles.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        return this.data[rowIndex][columnIndex];
    }

    public String getColumnName(int col) {
        return this.titles[col];
    }
}
