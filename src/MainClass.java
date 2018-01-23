import Model.*;

import java.sql.*;


import View.UI;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainClass {
    public static void main(String[] args) {
        System.out.println("Ca marche.");
        Connection conn = SingletonConnection.getInstance();
        CarDAO dc = new CarDAO(conn);
        // dc.delete(c);
        // Car cc = new Car("SLM659Q", "olllll", "hhhhhhh", 69800);
        // dc.delete(cc);
        Car c = new Car("SL12697", "Odyssey", "Honda", 69800);
        ///dc.create(c);
        //System.out.println((dc.find(c.getRegistrationNumber())).getBrand());
        //ClientDAO cl = new ClientDAO(conn);
        Client cll  = new Client("A001", "ouma", "dhh");
        //cl.create(cll);
        //System.out.println(cl.find(cll.getCIN()).getCIN());
        //cl.delete(cll);
        //System.out.println(cl.find(cll.getCIN()));

        RantingDAO dd = new RantingDAO(conn);

        Ranting rr = new Ranting(1, c, cll, true, java.sql.Date.valueOf("2018-06-12"), java.sql.Date.valueOf("2017-10-09"));
        dd.create(rr);
        //System.out.println( (new SimpleDateFormat("MM/dd/yyy")).format((dd.find("2")).getReturnDate()) );
        //System.out.println((dd.find("1")).isReturned());
        dd.delete(rr);
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
