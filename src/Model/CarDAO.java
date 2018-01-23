package Model;


import java.sql.Connection;

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