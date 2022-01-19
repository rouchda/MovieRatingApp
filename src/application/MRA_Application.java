package application;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import datatypes.MovieData;
import datatypes.RegisteredUserData;
import dbadapter.Rating;
import dbadapter.DBFacade;
import dbadapter.MovieDatabase;
import interfaces.GCmds;
import interfaces.SMCmds;

/**
 * This class contains the MRA_Application which acts as the interface between all
 * components.
 * 
 * @author swe.uni-due.de
 *
 */
public class MRA_Application implements GCmds, SMCmds {

	private static MRA_Application instance;

	/**
	 * Implementation of the Singleton pattern.
	 * 
	 * @return
	 */
	public static MRA_Application getInstance() {
		if (instance == null) {
			instance = new MRA_Application();
		}

		return instance;
	}

	/**
	 * Calls DBFacace method to retrieve all offers fitting to the given
	 * parameters.
	 * 
	 * @param arrivalTime
	 * @param departureTime
	 * @param persons
	 * @return
	 */
	public ArrayList<MovieDatabase> getAvailableHolidayOffers(String arrivalTime, String departureTime, String persons) {
		ArrayList<MovieDatabase> result = null;

		// Parse string attributes to correct datatype
		try {
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			Date date = dateFormat.parse(arrivalTime);
			long time = date.getTime();
			Timestamp arrivalTimeSQL = new Timestamp(time);
			Date date2 = dateFormat.parse(departureTime);
			time = date2.getTime();
			Timestamp departureTimeSQL = new Timestamp(time);
			int personsSQL = Integer.parseInt(persons);
			result = DBFacade.getInstance().getAvailableHolidayOffers(arrivalTimeSQL, departureTimeSQL, personsSQL);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * Forwards a new offer to the database.
	 * 
	 * @param startTime
	 * @param endTime
	 * @param address
	 * @param capacity
	 * @param fee
	 */
	public void insertOffer(String startTime, String endTime, MovieData addressData, String capacity, String fee) {

		// Parse inputs to correct datatypes
		try {
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			Date date = dateFormat.parse(startTime);
			long time = date.getTime();
			Timestamp startTimeSQL = new Timestamp(time);
			date = dateFormat.parse(endTime);
			time = date.getTime();
			Timestamp endTimeSQL = new Timestamp(time);
			int capacitySQL = Integer.parseInt(capacity);
			double feeSQL = Double.parseDouble(fee);
			DBFacade.getInstance().insertOffer(startTimeSQL, endTimeSQL, addressData, capacitySQL, feeSQL);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Forwards a booking request to the database and waits for the new booking
	 * offer. This will be returned to the GUI after.
	 * 
	 * @param arrivalTime
	 * @param departureTime
	 * @param hid
	 * @param RegisteredUserData
	 * @param persons
	 * @return
	 */
	public Rating makeRating(String mId, String movieRating, String comment, RegisteredUserData username) 
	{

		// pre: md->one(m: MovieDatabase | m.movieID=mId
		//assert preOfferAvailable(Integer.parseInt(hid)) : "Precondition not satisfied";
		assert alreadyRated(Integer.parseInt(mId)) : "Precondition not satisfied";


		// Create result object
		Rating okfail = null;

		// Parse inputs to correct datatypes
		try {
			String comment = new String(comment);
			Date date = dateFormat.parse(arrivalTime);
			long time = date.getTime();
			Timestamp arrivalTimeSQL = new Timestamp(time);
			DateFormat dateFormat2 = new SimpleDateFormat("MM/dd/yyyy");
			Date date2 = dateFormat2.parse(departureTime);
			long time2 = date2.getTime();
			Timestamp departureTimeSQL = new Timestamp(time2);
			int mIdSQL = Integer.parseInt(mId);
			int movieRatingSQL = Integer.parseInt(movieRating);
			okfail = DBFacade.getInstance().get_fbMRA_RM(arrivalTimeSQL, departureTimeSQL, hidSQL, RegisteredUsers,
					personsSQL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return okfail;
	}

	/**
	 * Initiates deleting of all bookings not paid and older than 14 days.
	 */
	public void checkPayment() {
		DBFacade.getInstance().setAvailableHolidayOffer();
	}

	/**
	 * Checks precondition holidayoffer exists
	 * 
	 * @param mId
	 * @return
	 */
	private boolean alreadyRated(int mId) {
		return DBFacade.getInstance().checkHolidayOfferById(mId);
	}
}
