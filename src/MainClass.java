import Model.DefaultTableModel;
import View.UI;

import java.util.Date;

public class MainClass {
    public static void main(String[] args) {
        Object[][] data = {
                {"JK7854", "BRAND1", "NOM"},
                {"JK7854", "BRAND1", "NOM"},
                {"JK7854", "BRAND1", "NOM"},
                {"JK7854", "BRAND1", "NOM"},
                {"JK7854", "BRAND1", "NOM"},
                {"JK7854", "BRAND1", "NOM"},
                {"JK7854", "BRAND1", "NOM"},
                {"JK7854", "BRAND1", "NOM"},
                {"JK7854", "BRAND1", "NOM"},
                {"JK7854", "BRAND1", "NOM"}
        };
        String title[] = {"CIN", "First Name", "LAST NAME"};

        Object[][] data2 = {
                {"JK7854", "BRAND1", "NOM", new Double(125.6)},
                {"JK7854", "BRAND1", "NOM", new Double(125.6)},
                {"JK7854", "BRAND1", "NOM", new Double(125.6)},
                {"JK7854", "BRAND1", "NOM", new Double(125.6)},
                {"JK7854", "BRAND1", "NOM", new Double(125.6)},
                {"JK7854", "BRAND1", "NOM", new Double(125.6)},
                {"JK7854", "BRAND1", "NOM", new Double(125.6)}
        };
        String title2[] = {"R.NUMBER", "Model", "Brand", "Price"};

        Object[][] data3 = {
                {"JK7854", "BRAND1", "12/01/2017", new Date()},
                {"JK7854", "BRAND1", "12/01/2017", new Date()},
                {"JK7854", "BRAND1", "12/01/2017", new Date()},
                {"JK7854", "BRAND1", "12/01/2017", new Date()},
                {"JK7854", "BRAND1", "12/01/2017", new Date()},
                {"JK7854", "BRAND1", "12/01/2017", new Date()}
        };
        String title3[] = {"Car's Num", "Client CIN", "Rental Date", "Return Date"};

        DefaultTableModel model = new DefaultTableModel(data, title);
        DefaultTableModel model2 = new DefaultTableModel(data2, title2);
        DefaultTableModel model3 = new DefaultTableModel(data3, title3);
        /*DefaultTableModel model4 = new DefaultTableModel(data4, title);
        DefaultTableModel model5 = new DefaultTableModel(data4, title2);*/
        DefaultTableModel[] models = {model, model2, model3};
        UI ui = new UI(models);

        ui.setVisible(true);
    }
}
