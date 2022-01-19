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
import interfaces.RUCmds;
import interfaces.UUCmds;

/**
 * This class contains the MRA_Application which acts as the interface between all
 * components.
 * @author Maher Mansour (3091490), Rouchda Pepouna Makwet (3091241), Walid Al Sibai(3087459), Mohamad Kalach (3074207), Tumamo Dzukou Joel Arnaud(3105963)
 *
 */
public class MRA_Application implements RUCmds, UUCmds {

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
	 * Calls DBFacace method to retrieve all movies fitting to the given
	 * parameters.
	 * param arrivalTime
	 * param departureTime
	 * param persons
	 * return
	 */
	public ArrayList<MovieDatabase> accessingMovieListDB(String Title, MovieData mId, MovieData movieDirector, MovieData Actor, MovieData movieRating, MovieData comment) {
		ArrayList<MovieDatabase> Movielist = null;

		// Parse string attributes to correct datatype
		try {
			Movielist = ((Object) DBFacade.getInstance()).accessingMovieListDB();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Movielist;
	}

	/**
	 * Forwards a new offer to the database.
	 * Add new movies to database.
	 * 
	 * @param mId
	 * @param Title
	 * @param movieDirector
	 * @param Actor
	 * @param publishingDate
	 * 
	 */
	public void setNewMovie(String Title, int mId, String movieDirector, String Actor, Date publishingDate) {

		// Parse inputs to correct datatypes
		try {
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			Date date = dateFormat(publishingDate);
			String title = new String(Title);
			String Director = new String(movieDirector); 
			String actor = new String(Actor);
			int Id = new int(mId);

			DBFacade.getInstance().setNewMovie();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Date dateFormat(Date publishingDate) {
		return null;
	}

	/**
	 * Forwards a rating request to the database. This will be returned to the UserGUI after.
	 * 
	 * @param mId
	 * @param movieRating
	 * @param comment
	 * @param username
	 * @param creationDate
	 * @param integer 
	 * @param persons
	 * @return
	 */
	public Rating makeRating(int mId, int movieRating, String comment, RegisteredUserData username, Timestamp creationDate, Date publishingDate, Object integer) 
	{

		// pre: md->one(m: MovieDatabase | m.movieID=mId
		//assert preOfferAvailable(Integer.parseInt(hid)) : "Precondition not satisfied";
		assert alreadyRated(Integer.parseInt(mId)) : "Precondition not satisfied";


		// Create result object
		Rating okfail = null;

		// Parse inputs to correct datatypes
		try {
			int Id = new int(mId); 
			String comment = new String(comment);
			long creationDate = creationDate.getTime();
			Timestamp creationDateSQL = new Timestamp(creationDate);
			int movieRatingSQL = Integer.parseInt(movieRating);
			okfail = DBFacade.getInstance().get_fbMRA_RM();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return okfail;
	}

	/**
	 * Initiates deleting of all bookings not paid and older than 14 days.
	 
	public void checkPayment() {
		DBFacade.getInstance().setAvailableHolidayOffer();
	}
	*/

	/**
	 * Checks precondition alreadyRated exists
	 * 
	 * @param mId
	 * @return
	 */
	private boolean alreadyRated(int mId) {
		return DBFacade.getInstance().checkRatingById(mId);
	}

	@Override
	public Rating makeRating(int id, Timestamp creationDate, RegisteredUserData username, int movieRating,
			String comment, int mId, Date publishingDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createUserProfile(RegisteredUserData username, RegisteredUserData age, RegisteredUserData email) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setNewMovie(MovieData Title, MovieData mId, MovieData movieDirector, MovieData Actor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<MovieDatabase> accessingMovieListDB(MovieData Title, MovieData mId, MovieData movieDirector,
			MovieData Actor, MovieData movieRating, MovieData comment) {
		// TODO Auto-generated method stub
		return null;
	}

    public Object get_fbGetMovieListDB(String parameter, String parameter2, String parameter3) {
        return null;
    }
}
