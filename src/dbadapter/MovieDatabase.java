package dbadapter;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

import datatypes.MovieData;
import datatypes.RegisteredUserData;

/**
 * Class representing an offer
 * 
 * 
 *
 */
public class MovieDatabase {

	int mId;
	MovieData Title;
	MovieData 
	MovieData movieRating;
	Date publishingDate;
	
	public MovieDatabase(int id, RegisteredUserData username, int movieRating, String comment,
	int mId, Date publishingDate) {
		this.id = id;
		this.startTime = startTime;
		this.endTime = endTime;
		this.addressData = addressData;
		this.capacity = capacity;
		this.fee = fee;
		this.bookings = new ArrayList<Rating>();
	}

	public String toString() {
		return "HolidayOffer " + id + " startTime: " + startTime + " endTime: " + endTime + " capacity: " + capacity
				+ " fee: " + fee;
	}

	public int getId() {
		return id;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public MovieData getAddressData() {
		return addressData;
	}

	public int getCapacity() {
		return capacity;
	}

	public double getFee() {
		return fee;
	}

	public ArrayList<Rating> getBookings() {
		return bookings;
	}

	public void setBookings(ArrayList<Rating> bookings) {
		this.bookings = bookings;
	}

	/**
	 * Checking if this offer is available. All bookings for this offer are
	 * iteratively checked. check if a movie is already present in the MDB
	 * 
	 * @param arrivalTime
	 * @param departureTime
	 * @return
	 */
	public boolean available(Timestamp arrivalTime, Timestamp departureTime) {
		for (int i = 0; i < bookings.size(); i++) {
			if (bookings.get(i).overlap(arrivalTime, departureTime)) {
				return false;
			}
		}
		return true;
	}
}
