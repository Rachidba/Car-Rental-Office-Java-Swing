package Model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

public class RantingDAO extends DAO<Ranting> {

	public RantingDAO(Connection connection){
		super(connection);
	}

	@Override
	public boolean create(Ranting obj) {

		try {
			String query = "INSERT INTO ranting (registrationNumber, CIN, isReturned, rentalDate, returnDate)" +
							"VALUES (?, ?, ?, ?, ?)";
			PreparedStatement state = this.connection.prepareStatement(query,
					ResultSet.TYPE_FORWARD_ONLY,
					ResultSet.CONCUR_UPDATABLE);
			state.setString(1, obj.getCar().getRegistrationNumber());
			state.setString(2, obj.getClient().getCIN());
			state.setBoolean(3, obj.isReturned());
			state.setDate(4, obj.getRentalDate());
			state.setDate(5,obj.getReturnDate());
			state.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Ranting obj) {

		try {
			String query = "DELETE FROM ranting WHERE rantID = ?";
			PreparedStatement state = this.connection.prepareStatement(query,
					ResultSet.TYPE_FORWARD_ONLY,
					ResultSet.CONCUR_UPDATABLE);
			state.setInt(1, obj.getRantID());
			state.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Ranting obj) {

		try {
			String query = "UPDATE ranting SET isReturned = ?, rentalDate = ?, returnDate = ?, registrationNumber = ?, CIN = ? WHERE rantID = ?";
			PreparedStatement state = this.connection.prepareStatement(query,
					ResultSet.TYPE_FORWARD_ONLY,
					ResultSet.CONCUR_UPDATABLE);
			state.setBoolean(1, obj.isReturned());
			state.setDate(2, obj.getRentalDate());
			state.setDate(3,obj.getReturnDate());
			state.setString(4, obj.getCar().getRegistrationNumber());
			state.setString(5, obj.getClient().getCIN());
			state.setInt(6, obj.getRantID());
			state.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Ranting find(String ref) {

		try {
			String query = "SELECT * FROM ranting WHERE rantID = ?";
			PreparedStatement state = this.connection.prepareStatement(query,
					ResultSet.TYPE_FORWARD_ONLY,
					ResultSet.CONCUR_READ_ONLY);
			state.setInt(1, Integer.parseInt(ref));
			ResultSet result = state.executeQuery();

			if(result.first()){
				Ranting newR = new Ranting( result.getInt("rantID"),
						(new CarDAO(this.connection)).find(result.getString("registrationNumber")),
						(new ClientDAO(this.connection)).find(result.getString("CIN")),
						 result.getBoolean("isReturned"),
						result.getDate("rentalDate"),
						result.getDate("returnDate"));
				return newR;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Ranting> all() {
		Vector<Ranting> rantings = new Vector<>();
		try {
			String query = "SELECT * FROM ranting";
			PreparedStatement state = this.connection.prepareStatement(query,
					ResultSet.TYPE_FORWARD_ONLY,
					ResultSet.CONCUR_READ_ONLY);
			ResultSet result = state.executeQuery();

			while(result.next()){
				rantings.add(new Ranting(
						result.getInt("rantID"),
						(new CarDAO(this.connection)).find(result.getString("registrationNumber")),
						(new ClientDAO(this.connection)).find(result.getString("CIN")),
						result.getBoolean("isReturned"),
						result.getDate("rentalDate"),
						result.getDate("returnDate"))
				);
			}
			return rantings;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rantings;
	}

	@Override
	public List<Ranting> available() {
		return null;
	}

	public List<Ranting> all(String ref) {
		return null;
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

}