package Model;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import java.util.Vector;

public class CarTableModel extends AbstractTableModel{
    private String[] titles = {"R.NUMBER", "Model", "Brand", "Price"};
    private Vector<String[]> data;

    public CarTableModel() {
        initData();
    }

    public void loadData(List<Car> cars) {
        this.data = new Vector<String[]>();//[clients.size()][3];
        for(Car c:cars) {
            String[] str = {c.getRegistrationNumber(), c.getModel(), c.getBrand(), String.valueOf(c.getPrice())};
            data.add (str);
        }
        fireTableChanged(null);
    }

    public void availables() {
        this.loadData(DAOFactory.getCarDAO().available());
    }

    public void initData() {
        this.loadData(DAOFactory.getCarDAO().all());
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

    public String[] getTitles() {
        return titles;
    }

    public Vector<String[]> getData() {
        return data;
    }

    public void removeRow(int i) {
        this.data.remove(i);
        fireTableChanged(null);
    }

    public void setRow(int i, String[] str) {
        this.data.set(i, str);
        fireTableChanged(null);
    }

    public void addRow(String[] str) {
        this.data.add(str);
        fireTableChanged(null);
    }
}
