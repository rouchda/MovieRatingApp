package interfaces;

import java.sql.Timestamp;
import java.util.ArrayList;

import datatypes.RegisteredUserData;
import dbadapter.Rating;
import dbadapter.HolidayOffer;

/**
 * Interface for DBFacade to provide all necessary database function.
 * 
 * @author swe.uni-due.de
 *
 */
public interface IMovieDataBase {

	public ArrayList<HolidayOffer> getAvailableHolidayOffers(
			Timestamp arrivalTime, Timestamp departureTime, int persons);

	public Rating get_fbMRA_RM(Timestamp arrivalTime,
			Timestamp departureTime, int hid, RegisteredUserData guestData, int persons);

	public void setAvailableHolidayOffer();

}
