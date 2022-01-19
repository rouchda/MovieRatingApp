package datatypes;

import java.sql.Date;

/**
 * Contains address informations about a Movie.
 * 
 * 
 *
 */
public class MovieData {



    public int mId;
	public String Title;
	public String MovieDirector;
	public String Actor;
	public int movieRating;
	public String comment;
	public Date publishingDate;

	public MovieData(int mId, String Title, String Actor, String MovieDirector, int movieRating, String comment, Date publishingDate) {
		this.mId = mId;
		this.Title = Title;
		this.Actor = Actor;
		this.MovieDirector = MovieDirector;
		this.movieRating = movieRating;
		this.comment = comment;
		this.publishingDate = publishingDate;
	}

	public int getmId() {
		return mId;
	}

	public String getTitle() {
		return Title;
	}

	public String getMovieDirector() {
		return MovieDirector;
	}

	public String getActor() {
		return Actor;
	}

	public String getcomment() {
		return comment;
	}

	public int getmovieRating() {
		return movieRating;
		}

	public Date getpublishingDate() {
		return publishingDate;
		}
	}


