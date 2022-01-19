package dbadapter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import datatypes.AddressData;
import datatypes.RegisteredUserData;
import interfaces.IMovieDatabase;

/**
 * Class which acts as the connector between application and database. Creates
 * Java objects from SQL returns. Exceptions thrown in this class will be
 * catched with a 500 error page.
 * 
 * @author swe.uni-due.de
 *
 */
public class DBFacade implements IMovieDatabase {
	private static DBFacade instance;

	/**
	 * Constructor which loads the corresponding driver for the chosen database type
	 */
	private DBFacade() {
		try {
			Class.forName("com." + Configuration.getType() + ".jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Implementation of the Singleton pattern.
	 * 
	 * @return
	 */
	public static DBFacade getInstance() {
		if (instance == null) {
			instance = new DBFacade();
		}

		return instance;
	}

	public static void setInstance(DBFacade dbfacade) {
		instance = dbfacade;
	}

	/**
	 * Function that returns all appropriate offers from the database.
	 * 
	 * @param RegisteredUserData  compared with existing ratings.
	 * @param mId compared with existing ratings.
	 * @param persons       compared with capacity.
	 * @return Arraylist of all rated objects.
	 */
	public ArrayList<MovieDatabase> getAvailableMovieDatabases(Timestamp arrivalTime, Timestamp departureTime,
			int persons) {
		ArrayList<MovieDatabase> result = new ArrayList<MovieDatabase>();

		// Declare the necessary SQL queries.
		String sqlSelect = "SELECT * FROM MovieDatabase WHERE starttime <= ? AND endtime >= ? AND capacity >= ?";
		String sqlSelectR = "SELECT * FROM Rating WHERE hid = ?";

		// Query all offers that fits to the given criteria.
		try (Connection connection = DriverManager
				.getConnection(
						"jdbc:" + Configuration.getType() + "://" + Configuration.getServer() + ":"
								+ Configuration.getPort() + "/" + Configuration.getDatabase(),
						Configuration.getUser(), Configuration.getPassword())) {

			try (PreparedStatement ps = connection.prepareStatement(sqlSelect);
					PreparedStatement psSelectB = connection.prepareStatement(sqlSelectB)) {
				ps.setTimestamp(1, arrivalTime);
				ps.setTimestamp(2, departureTime);
				ps.setInt(3, persons);

				try (ResultSet rs = ps.executeQuery()) {
					while (rs.next()) {
						MovieDatabase temp = new MovieDatabase(rs.getInt(1), rs.getTimestamp(2), rs.getTimestamp(3),
								new AddressData(rs.getString(4), rs.getString(5)), rs.getInt(6), rs.getDouble(7));
						psSelectB.setInt(1, temp.getId());

						// Query all ratings for the offer to check if its
						// available.
						try (ResultSet brs = psSelectB.executeQuery()) {
							ArrayList<Rating> ratings = new ArrayList<Rating>();
							while (brs.next()) {
								ratings.add(new Rating(brs.getInt(1), brs.getTimestamp(2), brs.getTimestamp(3),
										brs.getTimestamp(4), brs.getBoolean(5),
										new RegisteredUserData(brs.getString(6), brs.getString(7)), brs.getDouble(8),
										brs.getInt(9)));
							}
							temp.setratings(ratings);
						}
						if (temp.available(arrivalTime, departureTime))
							result.add(temp);
					}
					;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * Inserts a new offer in the database.
	 * 
	 * @param startTime
	 * @param endTime
	 * @param address
	 * @param capacity
	 * @param fee
	 */
	public void insertOffer(Timestamp startTime, Timestamp endTime, AddressData address, int capacity, double fee) {

		// Declare SQL query to insert offer.
		String sqlInsert = "INSERT INTO MovieDatabase (startTime,endTime,street,town,capacity,fee) VALUES (?,?,?,?,?,?)";

		// Insert offer into database.
		try (Connection connection = DriverManager
				.getConnection(
						"jdbc:" + Configuration.getType() + "://" + Configuration.getServer() + ":"
								+ Configuration.getPort() + "/" + Configuration.getDatabase(),
						Configuration.getUser(), Configuration.getPassword())) {

			try (PreparedStatement ps = connection.prepareStatement(sqlInsert)) {
				ps.setTimestamp(1, startTime);
				ps.setTimestamp(2, endTime);
				ps.setString(3, address.getStreet());
				ps.setString(4, address.getTown());
				ps.setInt(5, capacity);
				ps.setDouble(6, fee);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Inserts a rating into the database if there are enough capacities
	 * 
	 * @param movieRating
	 * @param comment
	 * @param mId
	 * @param RegisteredUserData
	 * @param persons
	 * @return new rating object if available or null if not available
	 */
	public Rating get_fbMRA_RM(String mId, String movieRating, String comment, RegisteredUserData username) 
	{
		MovieDatabase m = null;
		ArrayList<Rating> ratings = new ArrayList<Rating>();
		Rating rating = null;

		// Declare necessary SQL queries.
		String sqlSelectMDB = "SELECT * FROM MovieDatabase WHERE id=?";
		String sqlInsertRating = "INSERT INTO Rating (mId , movieRating, comment , username) VALUES (?,?,?,?)";
		String sqlSelectR = "SELECT * FROM Rating WHERE mId=?";

		/* Get selected offer
		try (Connection connection = DriverManager
				.getConnection(
						"jdbc:" + Configuration.getType() + "://" + Configuration.getServer() + ":"
								+ Configuration.getPort() + "/" + Configuration.getDatabase(),
						Configuration.getUser(), Configuration.getPassword())) {
			try (PreparedStatement psSelect = connection.prepareStatement(sqlSelectHO);
					PreparedStatement psSelectB = connection.prepareStatement(sqlSelectB);
					PreparedStatement psInsert = connection.prepareStatement(sqlInsertBooking,
							PreparedStatement.RETURN_GENERATED_KEYS)) {
				psSelect.setInt(1, hid);
				try (ResultSet hors = psSelect.executeQuery()) {
					if (hors.next()) {
						ho = new MovieDatabase(hors.getInt(1), hors.getTimestamp(2), hors.getTimestamp(3),
								new AddressData(hors.getString(4), hors.getString(5)), hors.getInt(6),
								hors.getDouble(7));
					}
				} 

				// Check if offer is still available
				if (ho != null) {
					psSelectB.setInt(1, hid);
					try (ResultSet brs = psSelectB.executeQuery()) {
						while (brs.next()) {
							ratings.add(new Rating(brs.getInt(1), brs.getTimestamp(2), brs.getTimestamp(3),
									brs.getTimestamp(4), brs.getBoolean(5),
									new RegisteredUserData(brs.getString(6), brs.getString(7)), brs.getDouble(8),
									brs.getInt(9)));
						}
						ho.setratings(ratings);
					} */

					// Insert new rating
					if (m.available(mId, username) && m.getCapacity() >= persons) {
						//Timestamp creationDate = new Timestamp(new Date().getTime());
						rating = new Rating(0, new Timestamp(creationDate.getTime()), mId, username,
								false, RegisteredUserData, createRating(arrivalTime, departureTime, ho.getFee()), m.getId());
						
						psInsert.setString(2, rating.username());
						psInsert.setInt(3, rating.getmId());
						psInsert.setTimestamp(1, booking.getCreationDate());
						psInsert.setTimestamp(3, booking.getDepartureTime());
						psInsert.setBoolean(4, booking.isPaid());
						psInsert.setString(5, booking.getGuestData().getName());
						psInsert.setString(6, booking.getGuestData().getEmail());
						psInsert.setDouble(7, booking.getPrice());
						psInsert.setInt(8, booking.getmId());
						psInsert.executeUpdate();
						try (ResultSet generatedKeys = psInsert.getGeneratedKeys()) {
							if (generatedKeys.next()) {
								booking.setId(generatedKeys.getInt(1));
							}
						}

					} else
						ho = null;

				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return booking;
	}

	/**
	 * Delete all ratings not paid and older than 14 days.
	 */
	public void setAvailableMovieDatabase() {

		// Declare necessary SQL statement.
		String deleteBO = "DELETE FROM Booking WHERE (paid = FALSE AND (TIMESTAMPADD( SQL_TSI_DAY , 14, creationData) < CURRENT_TIMESTAMP))";

		// Update Database.
		try (Connection connection = DriverManager
				.getConnection(
						"jdbc:" + Configuration.getType() + "://" + Configuration.getServer() + ":"
								+ Configuration.getPort() + "/" + Configuration.getDatabase(),
						Configuration.getUser(), Configuration.getPassword())) {
			try (PreparedStatement psDelete = connection.prepareStatement(deleteBO)) {
				psDelete.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Checks if offer with given id exists.
	 * 
	 * @param hid
	 * @return
	 */
	public boolean checkMovieDatabaseById(int hid) {

		// Declare necessary SQL query.
		String queryHO = "SELECT FROM MovieDatabase WHERE id=?";

		// query data.
		try (Connection connection = DriverManager
				.getConnection(
						"jdbc:" + Configuration.getType() + "://" + Configuration.getServer() + ":"
								+ Configuration.getPort() + "/" + Configuration.getDatabase(),
						Configuration.getUser(), Configuration.getPassword())) {
			try (PreparedStatement psSelect = connection.prepareStatement(queryHO)) {
				psSelect.setInt(1, hid);
				try (ResultSet rs = psSelect.executeQuery()) {
					return rs.next();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Function used to calculate the price for a booking.
	 * 
	 * @param rate1 movierating
	 * @param comment2 comment
	 * 
	 * @return
	 */
	private String createRating(int rate1, String comment1) {
		long dayDifference = (rate1.getTime() - date1.getTime()) / 1000 / 60 / 60 / 24;

		return dayDifference * fee;
	}
}
