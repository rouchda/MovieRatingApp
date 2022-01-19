package interfaces;

import datatypes.RegisteredUserData;

/**
 * Interface that provides all methods for the interaction with the unregisteredUser.
 * 
 *
 *
 */
public interface UUCmds {

	public void createUserProfile(RegisteredUserData username, RegisteredUserData age, RegisteredUserData email);


}
