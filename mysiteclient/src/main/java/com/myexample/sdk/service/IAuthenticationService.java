package com.myexample.sdk.service;

import java.util.List;

import com.myexample.sdk.model.Oauth2Token;
import com.myexample.sdk.model.User;

public interface IAuthenticationService {
	/**
	 * Requests an OAuth2 token for the user. User's email, password, and
	 * grantType are required. The scope attribute is optional.
	 *
	 * @param user
	 * @return a user with the system generated OAuth2 credentials
	 */
	Oauth2Token requestToken(User user);
	
	List<User> getUserList(String requestToken);
}
