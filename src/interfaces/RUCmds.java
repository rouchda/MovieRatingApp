package interfaces;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import datatypes.RegisteredUserData;
import dbadapter.Rating;
import dbadapter.MovieDatabase;

/**
 * Interface that provides all method to interact with a RegisteredUser.
 * 
 * @author swe.uni-due.de
 *
 */
public interface RUCmds {

	public ArrayList<MovieDatabase> getAvailableHolidayOffers(String arrivalTime, String departureTime, String persons);

	public Rating makeRating(int id, Timestamp creationDate, RegisteredUserData username, int movieRating, String comment,
	int mId, Date publishingDate);

	//createUserProfile(age..)
	//setNewMovie(title..)
	//accessingmovielistdb()

}
