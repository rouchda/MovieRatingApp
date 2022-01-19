package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import application.MRA_Application;
import datatypes.RegisteredUserData;
import dbadapter.MovieDatabase;

/**
 * Class responsible for the GUI of the user
 * 
 * @author swe.uni-due.de
 *
 */
public class UserGUI extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * doGet is responsible for search form and booking form
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {

		// Set navtype
		request.setAttribute("navtype", "guest");

		// Catch error if there is no page contained in the request
		String action = (request.getParameter("action") == null) ? "" : request.getParameter("action");

		// Case: Request rating form
		if (action.equals("selectRating")) {
			// Set request attributes
			request.setAttribute("pagetitle", "Rate Movie");
			request.setAttribute("mId", request.getParameter("mId"));

			// Dispatch request to template engine
			try {
				request.getRequestDispatcher("/templates/showBookHolidayOfferForm.ftl").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// Otherwise show search form
		} else {

			// Set request attributes
			request.setAttribute("pagetitle", "Search Movies");

			// Dispatch request to template engine
			try {
				request.getRequestDispatcher("/templates/defaultWebpageG.ftl").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * doPost manages handling of submitted forms.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {

		// Set attribute for navigation type.
		request.setAttribute("navtype", "guest");

		// Generate and show results of a search
		if (request.getParameter("action").equals("accessingMovieListDB")) {
			request.setAttribute("pagetitle", "Search results");
			List<MovieDatabase> availableOffers = null;

			// Call application to request the results
			try {
				Movielist = MRA_Application.getInstance().get_fbGetMovieListDB(
						request.getParameter("arrivalTime"), request.getParameter("departureTime"),
						request.getParameter("persons"));

				
				// Dispatch results to template engines
				request.setAttribute("Movielist", Movielist);
				request.getRequestDispatcher("/templates/offersRepresentation.ftl").forward(request, response);
			} catch (Exception e1) {
				try {
					request.setAttribute("errormessage", "Database error: please contact the administator");
					request.getRequestDispatcher("/templates/error.ftl").forward(request, response);
				} catch (Exception e) {
					request.setAttribute("errormessage", "System error: please contact the administrator");
					e.printStackTrace();
				}
				e1.printStackTrace();
			}
			// Insert Rating into database
		} else if (request.getParameter("action").equals("get_fbMRA_RM")) {
			// Decide whether rating was successful or not
			if (MRA_Application.getInstance().makeRating(request.getParameter("mId"),
					request.getParameter("movieRating"), request.getParameter("comment"),
					request.getParameter("creationDate"), request.getParameter("publishingDate"),
					new RegisteredUserData(request.getParameter("Uid"),request.getParameter("name"), request.getParameter("email"))) != null) {

				// Set request attributes
				request.setAttribute("pagetitle", "Rating Successful");
				request.setAttribute("message", "Rating successfully created.");

				// Dispatch to template engine
				try {
					request.getRequestDispatcher("/templates/okRepresentation.ftl").forward(request, response);
				} catch (ServletException | IOException e) {
					e.printStackTrace();
				}

				// Catch booking error and print an error on the gui
			} else {
				request.setAttribute("pagetitle", "Rating failed");
				request.setAttribute("message",
						"Rating failed. The selected offer is no longer available for your selected parameters.");

				try {
					request.getRequestDispatcher("/templates/failInfoRepresentation.ftl").forward(request,
							response);
				} catch (ServletException | IOException e) {
					e.printStackTrace();
				}

			}
			// If there is no page request, call doGet to show standard gui for
			// guest
		} else
			doGet(request, response);
	}
}