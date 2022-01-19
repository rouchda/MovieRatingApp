package datatypes;

/**
 * Contains the necessary informations about a user.
 * 
 * 
 *
 */
public class RegisteredUserData {
	private String username;
	private int age;
	private String email;

	public RegisteredUserData(String name, int age, String email) {
		this.username = username;
		this.age = age;
		this.email = email;
	}

	public String getName() {
		return username;
	}

	public int getAge() {
		return age;
	}

	public String getEmail() {
		return email;
	}
}

	
		