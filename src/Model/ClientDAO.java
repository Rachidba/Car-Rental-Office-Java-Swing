package Model;


import java.sql.Connection;

/**
 * @author R2S
 * @version 1.0
 * @created 20-Jan-2018 5:40:33 PM
 */
public class ClientDAO extends DAO<Client> {

	public ClientDAO(Connection connection){
		super(connection);
	}

	@Override
	public boolean create(Client obj) {
		return false;
	}

	@Override
	public boolean delete(Client obj) {
		return false;
	}

	@Override
	public boolean update(Client obj) {
		return false;
	}

	@Override
	public Client find(String ref) {
		return null;
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

}