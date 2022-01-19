package dbadapter;

import java.sql.Date;
import java.sql.Timestamp;

import datatypes.RegisteredUserData;

/**
 * Class representing a booking
 * 
 * 
 *
 */
public class Rating {

	int id;
	Timestamp creationDate;
	RegisteredUserData username;
	int movieRating;
	String comment;
	Date publishingDate;
	int mId;

	public Rating(int id, Timestamp creationDate, RegisteredUserData username, int movieRating, String comment,
			int mId, Date publishingDate) {
		super();
		this.id = id;
		this.creationDate = creationDate;
		this.username = username;
		this.movieRating = movieRating;
		this.comment = comment;
		this.mId = mId;
		this.publishingDate = publishingDate;
	}

	public int getmId() {
		return mId;
	}

	public void setmId(int mId) {
		this.mId = mId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public RegisteredUserData getusername() {
		return username;
	}

	public void setusername(RegisteredUserData username) {
		this.username = username;
	}

	public int getmovieRating() {
		return movieRating;
	}

	public void setmovieRating(int movieRating) {
		this.movieRating = movieRating;
	}

	public String getcomment() {
		return comment;
	}

	public void setcomment(String comment) {
		this.comment = comment;
	}

	public Date getpublishingDate() {
		return publishingDate;
	}

	public void setpublishingDate(Date publishingDate) {
		this.publishingDate = publishingDate;
	}

	/**
	 * Checks if this user has already rated the movie.
	 * 
	 * @param username
	 * @param mId
	 * @return
	 */
	/*public boolean verify(RegisteredUserData username, int mId) {
		//Check precondition
		assert this.username.before(this.mId) :
			"pre not satisfiedd: this.username < this.movieRating";
		assert username.before(movieRating) :
			"pre not satisfiedd: username < movieRating";
		// Case 1
		if ((username.after(this.username) || username.equals(this.username))
				&& (username.before(this.movieRating) || username.equals(this.movieRating))) {
			return true;
		}
		// Case 2
		if ((movieRating.after(this.username) || movieRating.equals(this.username))
				&& (movieRating.before(this.movieRating) || movieRating.equals(this.movieRating))) {
			return true;
		}
		// Case 3
		if (username.before(this.username) && movieRating.after(this.movieRating)) {
			return true;
		}
		return false;
	}  */

	/*
	*checks if movieRating >= 1 and movieRating <= 10
	* @param umovieRating
	 * @return
	 * */

	 public float Rate(int movieRating) {

		if (movieRating >= 1) && (movieRating <= 10) {
			return movieRating;	
		}
		else {
			System.out.println("invalid value");
		}
	 }

}
