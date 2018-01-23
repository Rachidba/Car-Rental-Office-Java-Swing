package Model;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import java.util.Vector;

public class ClientTableModel extends AbstractTableModel {
    private String[] titles = {"CIN", "First Name", "LAST NAME"};
    private Vector<String[]> data;

    public ClientTableModel() {
        data = new Vector<String[]>();
    }

    public ClientTableModel(List<Client> clients) {
        this.loadData(clients);
    }

    public void loadData(List<Client> clients) {
        this.data = new Vector<String[]>();
        for(Client c:clients) {
            data.add(new String[]{
                    c.getCIN(),
                    c.getFirstName(),
                    c.getLastName()
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
