package interfaces;

import java.sql.Timestamp;
import java.util.ArrayList;

import datatypes.MovieData;
import datatypes.RegisteredUserData;
import dbadapter.Rating;
import dbadapter.MovieDatabase;

/**
 * Interface for DBFacade to provide all necessary database function.
 * 
 *
 */
public interface IMovieDataBase {


	public void createUserProfile(RegisteredUserData username, RegisteredUserData age, RegisteredUserData email);

	public ArrayList<MovieDatabase> get_fbAccessedMovieListDB(MovieData Title, MovieData mId, MovieData movieDirector, MovieData Actor, MovieData movieRating, MovieData comment);

	public Rating get_fbMRA_RM(Timestamp arrivalTime,
			Timestamp departureTime, int hid, RegisteredUserData guestData, int persons);

	public void get_fbGetMovieListDB();

}
