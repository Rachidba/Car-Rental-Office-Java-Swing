package Model;


import java.sql.Connection;

/**
 * @author R2S
 * @version 1.0
 * @created 20-Jan-2018 5:40:36 PM
 */
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

	public void finalize() throws Throwable {

	}

}