package Model;


import java.sql.Connection;
import java.util.List;

public abstract class DAO<T> {
	protected Connection connection = null;

	public DAO(Connection connection){
		this.connection = connection;
	}

	//Creation methode
	public abstract boolean create(T obj);

	//Delete methode
	public abstract boolean delete(T obj);

	//Update methode
	public abstract boolean update(T obj);

	//Search methode
	public abstract T find(String ref);

	public abstract List<T> all();

	public abstract List<T> available();

	public void finalize() throws Throwable {

	}

}