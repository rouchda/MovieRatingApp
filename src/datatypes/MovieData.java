package datatypes;

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

	public MovieData(int mId, String Title, String Actor, String MovieDirector) {
		this.mId = mId;
		this.Title = Title;
		this.Actor = Actor;
		this.MovieDirector = MovieDirector;
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

}
