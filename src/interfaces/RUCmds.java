package interfaces;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import datatypes.MovieData;
import datatypes.RegisteredUserData;
import dbadapter.Rating;
import dbadapter.MovieDatabase;

/**
 * Interface that provides all method to interact with a RegisteredUser.
 * 
 * 
 *
 */
public interface RUCmds {

	public ArrayList<MovieDatabase> accessingMovieListDB(MovieData Title, MovieData mId, MovieData movieDirector, MovieData Actor, MovieData movieRating, MovieData comment);

	public Rating makeRating(int id, Timestamp creationDate, RegisteredUserData username, int movieRating, String comment,
	int mId, Date publishingDate);

	public void setNewMovie(MovieData Title, MovieData mId, MovieData movieDirector, MovieData Actor);
}
