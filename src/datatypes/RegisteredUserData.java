package datatypes;

/**
 * Contains the necessary informations about a user.
 * 
 * 
 *
 */
public class RegisteredUserData {
	private String name;
	private int age;
	private String email;

	public RegisteredUserData(String name, int age, String email) {
		this.name = name;
		this.age = age;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getEmail() {
		return email;
	}
}

	
		