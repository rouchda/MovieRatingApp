package datatypes;

/**
 * Contains the necessary informations about a user.
 * 
 * 
 *
 */
public class RegisteredUserData {

	private int Uid;
	private String username;
	private int age;
	private String email;

	public RegisteredUserData(int Uid, String name, int age, String email) {
		this.Uid = Uid;
		this.username = username;
		this.age = age;
		this.email = email;
	}

	public int getUid() {
		return Uid;
	}

	public String getusername() {
		return username;
	}

	public int getAge() {
		return age;
	}

	public String getEmail() {
		return email;
	}
}

	
		