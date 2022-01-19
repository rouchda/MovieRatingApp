package dbadapter;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

import datatypes.RegisteredUserData;

/**
 * Class representing an offer
 * 
 * 
 *
 */
public class MovieDatabase {

	
    public int mId;
	public String Title;
	public String MovieDirector;
	public String Actor;
	public int movieRating;
	public String comment;
	public Date publishingDate;
	private ArrayList<Rating> ratings;

	public MovieDatabase(int mId, String Title, String Actor, String MovieDirector, RegisteredUserData username, int movieRating, String comment,
	 Date publishingDate) {
		this.mId = mId;
		this.Title = Title;
		this.Actor = Actor;
		this.MovieDirector = MovieDirector;
		this.publishingDate = publishingDate;
		this.movieRating = movieRating;
		this.comment = comment;
		this.ratings = new ArrayList<Rating>();
	}

	public String toString() {
		return "mId" + mId + "Title " + Title + " Actor " + Actor +"Publishing Date:" + publishingDate "Rating" + movieRating + " comment: " + comment;
	}

	public int getmId() {
		return mId;
	}

	public String getTitle() {
		return Title;
	}

	public String getActor() {
		return Actor;
	}

	public Date getpublishingDate() {
		return publishingDate;
	}

	public int getmovieRating() {
		return movieRating;
	}

	public String getcomment() {
		return comment;
	}


	public ArrayList<Rating> getRatings() {
		return ratings;
	}

	public void setBookings(ArrayList<Rating> ratings) {
		this.ratings = ratings;
	}

}
