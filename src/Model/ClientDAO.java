package Model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

		try {
			String query = "INSERT INTO client VALUES (?, ?, ?)";
			PreparedStatement state = this.connection.prepareStatement(query,
					ResultSet.TYPE_FORWARD_ONLY,
					ResultSet.CONCUR_UPDATABLE);
			state.setString(1, obj.getCIN());
			state.setString(2, obj.getFirstName());
			state.setString(3, obj.getLastName());
			state.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Client obj) {

		try {
			String query = "DELETE FROM client WHERE CIN = ?";
			PreparedStatement state = this.connection.prepareStatement(query,
					ResultSet.TYPE_FORWARD_ONLY,
					ResultSet.CONCUR_UPDATABLE);
			state.setString(1, obj.getCIN());
			state.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Client obj) {

		try {
			String query = "UPDATE client SET firstName = ?, lastName = ? WHERE CIN = ?";
			PreparedStatement state = this.connection.prepareStatement(query,
					ResultSet.TYPE_FORWARD_ONLY,
					ResultSet.CONCUR_UPDATABLE);
			state.setString(1, obj.getFirstName());
			state.setString(2, obj.getLastName());
			state.setString(3, obj.getCIN());
			state.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Client find(String ref) {

		try {
			String query = "SELECT * FROM client WHERE CIN = ?";
			PreparedStatement state = this.connection.prepareStatement(query,
					ResultSet.TYPE_FORWARD_ONLY,
					ResultSet.CONCUR_READ_ONLY);
			state.setString(1, ref);
			ResultSet result = state.executeQuery();
			if(result.first()){
				Client newC = new Client(ref,
						result.getString("firstName"),
						result.getString("lastName"));
				return newC;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

}