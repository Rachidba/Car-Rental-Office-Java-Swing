package Model;


import java.beans.VetoableChangeListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

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

	@Override
	public List<Client> all() {
		Vector<Client> clients = new Vector<>();
		try {
			String query = "SELECT * FROM client";
			PreparedStatement state = this.connection.prepareStatement(query,
					ResultSet.TYPE_FORWARD_ONLY,
					ResultSet.CONCUR_READ_ONLY);
			ResultSet result = state.executeQuery();

			while(result.next()){
				clients.add(new Client(
						result.getString("CIN"),
						result.getString("firstName"),
						result.getString("lastName"))
				);
			}
			return clients;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clients;
	}

	public List<Client> available() {
		Vector<Client> clients = new Vector<>();
		try {
			String query = "SELECT * FROM client " +
					"WHERE cin NOT IN " +
					"(SELECT cin FROM ranting)";
			PreparedStatement state = this.connection.prepareStatement(query,
					ResultSet.TYPE_FORWARD_ONLY,
					ResultSet.CONCUR_READ_ONLY);
			ResultSet result = state.executeQuery();

			while(result.next()){
				clients.add(new Client(
						result.getString("CIN"),
						result.getString("firstName"),
						result.getString("lastName"))
				);
			}
			return clients;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clients;
	}


	public List<Client> search(ClientCriterionInter criterion){
		if(!criterion.getCriterions().isEmpty()){
			String query = "SELECT * FROM client WHERE ";
			if(criterion.getCriterions().firstElement() instanceof CINCriterion){
					query += " CIN = \""+((CINCriterion)(criterion.getCriterions().firstElement())).getCIN() + "\"";
			}else if(criterion.getCriterions().firstElement() instanceof FnameCriterion){
				query += " firstName = \""+((FnameCriterion)(criterion.getCriterions().firstElement())).getFname() + "\"";
			}else if(criterion.getCriterions().firstElement() instanceof LnameCriterion){
				query += " lastName = \""+((LnameCriterion)(criterion.getCriterions().firstElement())).getLname() + "\"";
			}

			for(Criterion<Client> item : criterion.getCriterions()){
				if(item instanceof CINCriterion){
					query += " AND CIN = \""+((CINCriterion)item).getCIN() + "\"";
				}else if(item instanceof FnameCriterion){
					query += " AND firstName = \""+((FnameCriterion)item).getFname() + "\"";
				}else if(item instanceof LnameCriterion){
					query += " AND lastName = \""+((LnameCriterion)item).getLname() + "\"";
				}
			}
			query += " ;";
			Vector<Client> clients = new Vector<>();
			try {
				PreparedStatement state = this.connection.prepareStatement(query,
						ResultSet.TYPE_FORWARD_ONLY,
						ResultSet.CONCUR_READ_ONLY);
				ResultSet result = state.executeQuery();
				while(result.next()){
					clients.add(new Client(
							result.getString("CIN"),
							result.getString("firstName"),
							result.getString("lastName"))
					);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			return clients;
		}
		return null;
	}

	public void finalize() throws Throwable {
		super.finalize();
	}
}
