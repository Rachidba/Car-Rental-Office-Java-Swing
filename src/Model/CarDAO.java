package Model;


import java.sql.Connection;

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
		return false;
	}

	@Override
	public boolean delete(Car obj) {
		return false;
	}

	@Override
	public boolean update(Car obj) {
		return false;
	}

	@Override
	public Car find(String ref) {
		return null;
	}


	public void finalize() throws Throwable {
		super.finalize();
	}

}