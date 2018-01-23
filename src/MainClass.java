import Model.Car;
import Model.CarDAO;
import Model.SingletonConnection;

import java.sql.*;
public class MainClass {
    public static void main(String[] args) {
        System.out.println("Ca marche.");
        Connection conn = SingletonConnection.getInstance();
        CarDAO dc = new CarDAO(conn);
       // dc.delete(c);
        Car cc = new Car("SLM659Q", "olllll", "hhhhhhh", 69800);
        dc.delete(cc);
        Car c = new Car("SLM659Q", "Odyssey", "Honda", 69800);
       dc.create(c);
       System.out.println((dc.find(c.getRegistrationNumber())).getBrand());

    }
}
