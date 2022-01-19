package interfaces;

import java.sql.Timestamp;
import java.util.ArrayList;

import datatypes.RegisteredUserData;
import dbadapter.Rating;
import dbadapter.MovieDatabase;

/**
 * Interface for DBFacade to provide all necessary database function.
 * 
 * @author swe.uni-due.de
 *
 */
public interface IMovieDataBase {

	public ArrayList<MovieDatabase> getAvailableHolidayOffers(
			Timestamp arrivalTime, Timestamp departureTime, int persons);

	//public User registration createuserprofile(age,username,email, 
	//get_fbaccessedmovielistdb(title, moviedirector, actor publishingdate)	
	//get_fbGetmovielistdb()

	public Rating get_fbMRA_RM(Timestamp arrivalTime,
			Timestamp departureTime, int hid, RegisteredUserData guestData, int persons);

	public void setAvailableHolidayOffer();

}
