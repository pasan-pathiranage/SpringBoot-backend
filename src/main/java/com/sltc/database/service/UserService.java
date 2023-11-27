package com.sltc.database.service;

import java.util.List;

import com.sltc.database.dto.UserPwdDto;
import com.sltc.database.entity.User;

public interface UserService {
    List<User> getAllUsers();
    User creatUser(User user);
    User getUserById(Long id);
    User changeUserPassword(Long id, UserPwdDto userPwdDto);
}
