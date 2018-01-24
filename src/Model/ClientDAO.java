package Model;


import java.sql.Connection;

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