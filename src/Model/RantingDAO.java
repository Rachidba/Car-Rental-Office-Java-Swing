package Model;


import java.sql.Connection;

/**
 * @author R2S
 * @version 1.0
 * @created 20-Jan-2018 5:40:35 PM
 */
public class RantingDAO extends DAO<Ranting> {

	public RantingDAO(Connection connection){
		super(connection);
	}

	@Override
	public boolean create(Ranting obj) {
		return false;
	}

	@Override
	public boolean delete(Ranting obj) {
		return false;
	}

	@Override
	public boolean update(Ranting obj) {
		return false;
	}

	@Override
	public Ranting find(String ref) {
		return null;
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

}