package interfaces;

import java.util.ArrayList;

import datatypes.RegisteredUserData;
import dbadapter.Rating;
import dbadapter.MovieDatabase;

/**
 * Interface that provides all method to interact with a guest.
 * 
 * @author swe.uni-due.de
 *
 */
public interface GCmds {

	public ArrayList<MovieDatabase> getAvailableHolidayOffers(String arrivalTime, String departureTime, String persons);

	public Rating makeBooking(String arrivalTime, String departureTime, String hid, RegisteredUserData guestData,
			String persons);

}
