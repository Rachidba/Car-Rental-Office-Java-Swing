package Model;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import java.util.Vector;

public class RantalsTableModel extends AbstractTableModel {
    private String[] titles = {"Car's Num", "Client CIN", "Rental Date", "Return Date"};
    private Vector<String[]> data;

    public RantalsTableModel() {
        data = new Vector<String[]>();
    }

    public RantalsTableModel(List<Ranting> rentals) {
        this.loadData(rentals);
    }

    public void loadData(List<Ranting> rentals) {
        this.data = new Vector<String[]>();
        for(Ranting c:rentals) {
            data.add(new String[]{
                    c.getCar().getRegistrationNumber(),
                    c.getClient().getCIN(),
                    c.getRentalDate().toString(),
                    c.getReturnDate().toString()
            });
        }
        fireTableChanged(null);
    }

    public int getRowCount() {
        return this.data.size();
    }

    public int getColumnCount() {
        return this.titles.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        return this.data.get(rowIndex)[columnIndex];
    }

    public String getColumnName(int col) {
        return this.titles[col];
    }
}
