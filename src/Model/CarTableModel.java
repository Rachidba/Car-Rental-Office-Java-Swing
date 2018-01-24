package Model;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import java.util.Vector;

public class CarTableModel extends AbstractTableModel{
    private String[] titles = {"R.NUMBER", "Model", "Brand", "Price"};
    private Object[][] data;
    List<Car> cars;

    public CarTableModel() {
        cars = DAOFactory.getCarDAO().all();
        this.loadData();
    }

    public void loadData() {
        int i=0;
        this.data = new Object[cars.size()][5];
        for(Car c:cars) {
            data[i][0] = c.getRegistrationNumber();
            data[i][1] = c.getModel();
            data[i][2] = c.getBrand();
            data[i][3] = String.valueOf(c.getPrice());
            data[i][4] = new Boolean(false);
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

    public String[] getTitles() {
        return titles;
    }

    public Object[][] getData() {
        return data;
    }
}
