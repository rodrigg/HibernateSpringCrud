package com.rodionbykov.userdirectoryapi.repository.custom;

import com.rodionbykov.userdirectoryapi.model.User;

public interface UserRepositoryCustom {
	
	User findBySecurityToken(String securitytoken);
	User findByLoginAndPasswd(String login, String passwd);

}
