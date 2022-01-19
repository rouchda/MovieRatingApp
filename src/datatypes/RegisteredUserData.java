package datatypes;

/**
 * Contains the necessary informations about a user.
 * 
 * @author Maher Mansour (3091490), Rouchda Pepouna Makwet (3091241), Walid Al Sibai(3087459), Mohamad Kalach (3074207), Tumamo Dzukou Joel Arnaud(3105963)
 *
 */
public class RegisteredUserData {

	//private int Uid;
	private String username;
	private int age;
	private String email;
	private String password;

	public RegisteredUserData(int Uid, String name, int age, String email, String password) {
		this.username = name;
		this.age = age;
		this.email = email;
		this.password = password;
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

	public String setusername(String name) {
		return this.username = name;
	}

	public int setAge(int age) {
		return this.age = age;
	}

	public String setemail(String email) {
		return this.email = email;
	}

	public String getPassword()
     {
        return password;
     }
	public String setPassword(String password)
     {
        return this.password = password;
}
}


	
		