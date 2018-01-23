package Model;

import java.sql.Connection;

public class DAOFactory {
	private static final Connection connection = SingletonConnection.getInstance();

	private DAOFactory(){}

	public static DAO getClientDAO() {
		return new ClientDAO(connection);
	}

	public static DAO getCarDAO() {
		return new CarDAO(connection);
	}

	public static DAO getRantingDAO() {
		return new RantingDAO(connection);
	}

	public void finalize() throws Throwable {

	}

}