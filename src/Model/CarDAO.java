package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

/**
 * @author R2S
 * @version 1.0
 * @created 20-Jan-2018 5:40:34 PM
 */
public class CarDAO extends DAO<Car> {

	public CarDAO(Connection connection){
		super(connection);
	}

	@Override
	public boolean create(Car obj) {

		try {
			String query = "INSERT INTO car VALUES (?, ?, ?, ?)";
			PreparedStatement state = this.connection.prepareStatement(query,
																		ResultSet.TYPE_FORWARD_ONLY,
																		ResultSet.CONCUR_UPDATABLE);
			state.setString(1, obj.getRegistrationNumber());
			state.setString(2, obj.getBrand());
			state.setString(3, obj.getModel());
			state.setDouble(4, obj.getPrice());
			state.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean delete(Car obj) {
		try {
			String query = "DELETE FROM car WHERE registrationNumber = ?";
			PreparedStatement state = this.connection.prepareStatement(query,
																		ResultSet.TYPE_FORWARD_ONLY,
																		ResultSet.CONCUR_UPDATABLE);
			state.setString(1, obj.getRegistrationNumber());
			state.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Car obj) {
		try {
			String query = "UPDATE car SET brand = ?, model = ?, price = ? WHERE registrationNumber = ?";
			PreparedStatement state = this.connection.prepareStatement(query,
																		ResultSet.TYPE_FORWARD_ONLY,
																		ResultSet.CONCUR_UPDATABLE);
			state.setString(1, obj.getBrand());
			state.setString(2, obj.getModel());
			state.setDouble(3, obj.getPrice());
			state.setString(4, obj.getRegistrationNumber());
			state.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Car find(String ref) {
		try {
			String query = "SELECT * FROM car WHERE registrationNumber = ?";
			PreparedStatement state = this.connection.prepareStatement(query,
																		ResultSet.TYPE_FORWARD_ONLY,
																		ResultSet.CONCUR_READ_ONLY);
			state.setString(1, ref);
			ResultSet result = state.executeQuery();
			if(result.first()){
				Car newC = new Car(ref,
									result.getString("model"),
									result.getString("brand"),
									result.getDouble("price"));
				return newC;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Car> all() {
		Vector<Car> cars = new Vector<>();
		try {
			String query = "SELECT * FROM car";
			PreparedStatement state = this.connection.prepareStatement(query,
					ResultSet.TYPE_FORWARD_ONLY,
					ResultSet.CONCUR_READ_ONLY);
			ResultSet result = state.executeQuery();

			while(result.next()){
				Car newC = new Car(
						result.getString("registrationNumber"),
						result.getString("model"),
						result.getString("brand"),
						result.getDouble("price"));
				cars.add(newC);
			}
			return cars;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cars;
	}


	public void finalize() throws Throwable {
		super.finalize();
	}

}