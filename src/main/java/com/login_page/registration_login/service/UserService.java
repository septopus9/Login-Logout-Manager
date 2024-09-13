package com.login_page.registration_login.service;

import com.login_page.registration_login.dto.UserDto;
import com.login_page.registration_login.model.User;

public interface UserService {

    void saveUser(UserDto userDto);

    User findUserByEmail(String email);
}
