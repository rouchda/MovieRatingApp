package datatypes;

/**
 * Contains address informations about a Movie.
 * 
 * 
 *
 */
public class MovieData {

	public String Title;
	public String MovieDirector;
	public String Actor;

	public MovieData(String Title, String Actor, String MovieDirector) {
		this.Title = Title;
		this.Actor = Actor;
		this.MovieDirector = MovieDirector;
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
