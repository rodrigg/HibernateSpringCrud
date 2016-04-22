package com.rodionbykov.userdirectory.repository.custom;

import com.rodionbykov.userdirectory.model.User;

public interface UserRepositoryCustom {
	
	User findBySecurityToken(String securitytoken);
	User findByLoginAndPasswd(String login, String passwd);

}
