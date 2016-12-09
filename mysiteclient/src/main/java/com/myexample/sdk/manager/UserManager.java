package com.myexample.sdk.manager;

import java.util.List;
import java.util.ResourceBundle;

import com.myexample.sdk.model.Oauth2Token;
import com.myexample.sdk.model.User;
import com.myexample.sdk.service.IAuthenticationService;
import com.myexample.sdk.service.OAuth2TokenService;


public class UserManager extends ConfigureManager {
	
	private static final ResourceBundle bundle = ResourceBundle.getBundle("drysign");
	private IAuthenticationService authenticationService;
	private String password = null;
	private String email = null;
	
	public UserManager() {
   	     authenticationService = new OAuth2TokenService();
        ((OAuth2TokenService) authenticationService).setObjectMapper(getObjectMapper());
        password = bundle.getString("drysign.user.password");
        email = bundle.getString("drysign.sender.email");
	}
	
	/*
     * Use this function for upload/sending document to signer
     */
    public Oauth2Token getToken(){
    	User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        return authenticationService.requestToken(user);
    }
    
    public List<User> getMyUserList(String requestToken){
    	
		return authenticationService.getUserList(requestToken);
    	
    }
}
